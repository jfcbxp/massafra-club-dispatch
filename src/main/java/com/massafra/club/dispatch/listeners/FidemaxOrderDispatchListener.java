package com.massafra.club.dispatch.listeners;


import com.massafra.club.dispatch.annotations.Listener;
import com.massafra.club.dispatch.constants.RabbitMQ;
import com.massafra.club.dispatch.records.internal.FidemaxCustomerInternalRecord;
import com.massafra.club.dispatch.services.FidemaxCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@Listener
@RequiredArgsConstructor
public class FidemaxOrderDispatchListener {

    private final FidemaxCustomerService service;

    @RabbitListener(queues = RabbitMQ.CREATE_ORDER_QUEUE)
    public void processDispatchOrderListener(
            @Header(AmqpHeaders.RECEIVED_ROUTING_KEY)
            String routingKey,
            @Payload
            FidemaxCustomerInternalRecord payload) {

        log.info("FidemaxOrderDispatchListener.processDispatchOrderListener - Start - routingKey: [{}], orderWrapper: [{}]", routingKey, payload);

        service.sendCustomer(payload);

        log.info("FidemaxOrderDispatchListener.processDispatchOrderListener - End - routingKey: [{}]", routingKey);
    }
}
