package com.massafra.club.dispatch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.massafra.club.dispatch.clients.FidemaxClient;
import com.massafra.club.dispatch.constants.RabbitMQ;
import com.massafra.club.dispatch.exceptions.IntegrationInternalException;
import com.massafra.club.dispatch.publishers.Publisher;
import com.massafra.club.dispatch.records.internal.FidemaxCustomerInternalRecord;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRequestRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxCustomerService {

    private final FidemaxClient client;

    private final ModelMapper mapper;

    private final Publisher publisher;

    public void sendCustomer(FidemaxCustomerInternalRecord customerRecord) {
        try {
            var requestBody = mapper.map(customerRecord, FidemaxCustomerRequestRecord.class);
            var response = client.sendCustomer(requestBody);

            if (response.statusCode() != 100 && response.statusCode() != 110)
                throw new IntegrationInternalException(response.message(), response.statusCode());

            publisher.sendAsString(RabbitMQ.EXCHANGE_CLUB, RabbitMQ.DISPATCHED_CUSTOMER_ROUTING_KEY, customerRecord.id());

        } catch (
                IntegrationInternalException | JsonProcessingException e) {
            log.error("FidemaxCustomerService.sendCustomer - Error customer {} message: {}",
                    customerRecord.name(), e.getMessage());
        }
    }
}
