package com.massafra.club.dispatch.services;

import com.massafra.club.dispatch.clients.FidemaxClient;
import com.massafra.club.dispatch.exceptions.IntegrationInternalException;
import com.massafra.club.dispatch.records.internal.FidemaxLoyaltynternalRecord;
import com.massafra.club.dispatch.records.request.FidemaxLoyaltyRequestRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxOrderService {

    private final FidemaxClient client;

    private final ModelMapper mapper;

    public void sendOrder(FidemaxLoyaltynternalRecord loyalty) {
        try {
            var requestBody = mapper.map(loyalty, FidemaxLoyaltyRequestRecord.class);
            var response = client.sendLoyalty(requestBody);

            if (response.statusCode() != 200)
                throw new IntegrationInternalException(response.message(), response.statusCode());

        } catch (IntegrationInternalException e) {
            log.error("FidemaxOrderService.sendOrder - Error order {} message: {}",
                    loyalty.id(), e.getMessage());
        }
    }
}
