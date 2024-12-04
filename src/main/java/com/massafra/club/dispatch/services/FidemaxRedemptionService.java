package com.massafra.club.dispatch.services;

import com.massafra.club.dispatch.clients.ProtheusRedemptionClient;
import com.massafra.club.dispatch.exceptions.IntegrationInternalException;
import com.massafra.club.dispatch.mapper.FidemaxRedemptionMapper;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import com.massafra.club.dispatch.records.request.ProtheusCustomerRedemptionRequestRecord;
import com.massafra.club.dispatch.repositories.FidemaxRedemptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class FidemaxRedemptionService {

    private static final String PROTHEUS_REDEMPTION_DEFAULT_METHOD = "/incluirResgateFidemax";

    private final ProtheusRedemptionClient client;

    private final FidemaxRedemptionRepository repository;

    public void syncRedemptions() {


        var redemptions = repository.findAll();

        redemptions.forEach(redemption -> {

            try {

                var requestToRedemption = FidemaxRedemptionMapper.INSTANCE.redemptionToRedemptionRequest(redemption);

                log.info("FidemaxRedemptionService.createRedemption - redemption {} ",
                        redemption.getVoucher());

                var request = new ProtheusCustomerRedemptionRequestRecord(PROTHEUS_REDEMPTION_DEFAULT_METHOD, requestToRedemption);

                client.sendRedemption(request);

                repository.delete(redemption);

            } catch (IntegrationInternalException e) {
                log.error("FidemaxRedemptionService.createRedemption - Error redemption {} message: {}",
                        redemption.getVoucher(), e.getMessage());
            }
        });


    }

    public String registerRedemption(FidemaxCustomerRedemptionRequestRecord redemption) {

        var entity = FidemaxRedemptionMapper.INSTANCE.redemptionRequestToRedemption(redemption);

        entity.setDateReceived(LocalDateTime.now());

        log.info("FidemaxRedemptionService.registerRedemption - redemption {} ",
                redemption.voucher());

        return this.repository.save(entity).getId();

    }

}
