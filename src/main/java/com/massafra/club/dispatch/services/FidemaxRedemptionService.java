package com.massafra.club.dispatch.services;

import com.massafra.club.dispatch.clients.ProtheusRedemptionClient;
import com.massafra.club.dispatch.exceptions.IntegrationInternalException;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import com.massafra.club.dispatch.records.request.ProtheusCustomerRedemptionRequestRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxRedemptionService {

    private static final String PROTHEUS_REDEMPTION_DEFAULT_METHOD = "/incluirResgateFidemax";

    private final ProtheusRedemptionClient client;

    public void createRedemption(FidemaxCustomerRedemptionRequestRecord redemption) {
        try {

            var request = new ProtheusCustomerRedemptionRequestRecord(PROTHEUS_REDEMPTION_DEFAULT_METHOD, redemption);
            
            client.sendRedemption(request);

            log.info("FidemaxRedemptionService.createRedemption - redemption {} ",
                    redemption.voucher());


        } catch (IntegrationInternalException e) {
            log.error("FidemaxRedemptionService.createRedemption - Error redemption {} message: {}",
                    redemption.voucher(), e.getMessage());
        }
    }
}
