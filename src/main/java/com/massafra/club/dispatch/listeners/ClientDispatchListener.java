package com.massafra.club.dispatch.listeners;


import com.massafra.club.dispatch.constants.RabbitMQ;
import com.massafra.club.dispatch.record.FidemaxCustomerRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientDispatchListener {

    @RabbitListener(queues = RabbitMQ.CREATE_CUSTOMER_QUEUE)
    public void processOrderListener(
            @Header(AmqpHeaders.RECEIVED_ROUTING_KEY)
            String routingKey,
            @Payload
            FidemaxCustomerRecord payload) {

        log.info("ClientDispatchListener.processClientDispatcher - Start - routingKey: [{}], orderWrapper: [{}]", routingKey, payload);


        log.info("ClientDispatchListener.processClientDispatcher - End - routingKey: [{}]", routingKey);
    }
}
