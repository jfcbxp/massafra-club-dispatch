package com.massafra.club.dispatch.services;

import com.massafra.club.dispatch.clients.ProtheusRedemptionClient;
import com.massafra.club.dispatch.exceptions.IntegrationInternalException;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxRedemptionService {

    private final ProtheusRedemptionClient client;

    public void createRedemption(FidemaxCustomerRedemptionRequestRecord redemption) {
        try {

            client.sendRedemption(redemption);

            log.info("FidemaxRedemptionService.createRedemption - redemption {} ",
                    redemption.voucher());


        } catch (IntegrationInternalException e) {
            log.error("FidemaxRedemptionService.createRedemption - Error redemption {} message: {}",
                    redemption.voucher(), e.getMessage());
        }
    }
}
