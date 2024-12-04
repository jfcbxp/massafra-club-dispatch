package com.massafra.club.dispatch.configs;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ConnectionPoolSettings;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.mongodb.MongoMetricsCommandListener;
import io.micrometer.core.instrument.binder.mongodb.MongoMetricsConnectionPoolListener;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("!test")
@Slf4j
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.auto-index-creation}")
    private boolean autoIndex;

    @Value("${spring.data.mongodb.uri}")
    private String databaseUri;

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean(MongoProperties properties, MeterRegistry meterRegistry) {
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();

        var uri = databaseUri.replace("\n", "").replace("\\n", "");

        mongoClientFactoryBean.setConnectionString(new ConnectionString(uri));

        MongoClientSettings settings = MongoClientSettings.builder()
                .addCommandListener(new MongoMetricsCommandListener(meterRegistry))
                .applyConnectionString(new ConnectionString(uri))
                .applyToClusterSettings(builder ->
                        builder.mode(ClusterConnectionMode.MULTIPLE)
                                .applyConnectionString(new ConnectionString(uri))
                                .build())
                .applyToConnectionPoolSettings(builder ->
                        builder.addConnectionPoolListener(new MongoMetricsConnectionPoolListener(meterRegistry)))

                .build();
        mongoClientFactoryBean.setMongoClientSettings(settings);

        return mongoClientFactoryBean;
    }

    @Override
    @Bean
    public MongoClient mongoClient() {

        var uri = databaseUri.replace("\n", "").replace("\\n", "");
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings((ConnectionPoolSettings.Builder builder) ->
                        builder.maxSize(20)
                                .minSize(0)
                                .maxConnectionLifeTime(30, TimeUnit.MINUTES)
                                .maxConnectionIdleTime(5000, TimeUnit.MILLISECONDS)
                )
                .applyToSocketSettings(builder ->
                        builder.connectTimeout(2000, TimeUnit.MILLISECONDS)
                )
                .applicationName(appName)
                .build();

        return MongoClients.create(clientSettings);
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return this.database.replace("\n", "").replace("\\n", "");
    }

    @Override
    public boolean autoIndexCreation() {
        return autoIndex;
    }
}