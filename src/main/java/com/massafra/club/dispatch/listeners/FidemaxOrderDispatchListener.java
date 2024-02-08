package com.massafra.club.dispatch.listeners;


import com.massafra.club.dispatch.annotations.Listener;
import com.massafra.club.dispatch.constants.RabbitMQ;
import com.massafra.club.dispatch.records.internal.FidemaxLoyaltynternalRecord;
import com.massafra.club.dispatch.services.FidemaxOrderService;
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

    private final FidemaxOrderService service;

    @RabbitListener(
            queues = RabbitMQ.CREATE_ORDER_QUEUE,
            concurrency = "1-1"
    )
    public void processDispatchOrderListener(
            @Header(AmqpHeaders.RECEIVED_ROUTING_KEY)
            String routingKey,
            @Payload
            FidemaxLoyaltynternalRecord payload) {

        log.info("FidemaxOrderDispatchListener.processDispatchOrderListener - Start - routingKey: [{}], orderWrapper: [{}]", routingKey, payload);

        service.sendOrder(payload);

        log.info("FidemaxOrderDispatchListener.processDispatchOrderListener - End - routingKey: [{}]", routingKey);
    }
}
