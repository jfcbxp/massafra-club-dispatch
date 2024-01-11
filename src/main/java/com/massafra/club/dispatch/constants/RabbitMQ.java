package com.massafra.club.dispatch.constants;

public class RabbitMQ {

    private static final String CLUB_QUEUE_PREFIX = "club.";
    public static final String CREATE_CUSTOMER_ROUTING_KEY = "create.customer";
    public static final String CREATE_CUSTOMER_QUEUE = CLUB_QUEUE_PREFIX + CREATE_CUSTOMER_ROUTING_KEY;


}
