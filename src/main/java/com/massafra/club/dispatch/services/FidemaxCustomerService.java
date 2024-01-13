package com.massafra.club.dispatch.services;

import com.massafra.club.dispatch.clients.FidemaxClient;
import com.massafra.club.dispatch.exceptions.FidemaxCustomerException;
import com.massafra.club.dispatch.records.internal.FidemaxCustomerInternalRecord;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRequestRecord;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxCustomerService {

    private final FidemaxClient client;

    private final ModelMapper mapper;

    public void sendCustomer(FidemaxCustomerInternalRecord customerRecord) {
        try {
            var requestBody = mapper.map(customerRecord, FidemaxCustomerRequestRecord.class);
            var response = client.createClient(requestBody);

            if (Objects.nonNull(response.getBody()))
                throw new FidemaxCustomerException(response.getBody().message());

        } catch (
                FeignException e) {
            log.error("getCustomerBalance - Error getting customer {} balance. Returning balance with amount 0",
                    customerRecord.name(), e);
        }
    }
}
