package com.massafra.club.dispatch.clients;

import com.massafra.club.dispatch.configs.FidemaxFeignConfig;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "protheus-redemption-client",
        value = "protheus-redemption-client",
        url = "${protheus.url}",
        path = "/rest",
        configuration = FidemaxFeignConfig.class
)
public interface ProtheusRedemptionClient {
    Logger log = LoggerFactory.getLogger(ProtheusRedemptionClient.class);

    @PostMapping(
            value = "/GERENCIABOX",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    void sendRedemption(
            @RequestBody()
            FidemaxCustomerRedemptionRequestRecord data);

    default void serviceFallbackMethod(FidemaxCustomerRedemptionRequestRecord request, boolean ignoreInvalid, Throwable exception) {
        log.error("ProtheusRedemptionClient.serviceFallbackMethod - error request availability {}", exception.getMessage());
    }
}
