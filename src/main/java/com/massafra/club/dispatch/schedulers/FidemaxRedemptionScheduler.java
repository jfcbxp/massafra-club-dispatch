package com.massafra.club.dispatch.schedulers;


import com.massafra.club.dispatch.services.FidemaxRedemptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FidemaxRedemptionScheduler {

    private final FidemaxRedemptionService service;

    @Scheduled(
            cron = "${fidemax-redemption.scheduler.cron-value}",
            zone = "America/Sao_Paulo"
    )
    @SchedulerLock(
            name = "FIDEMAX_REDEMPTION",
            lockAtLeastFor = "${fidemax-redemption.scheduler.least-lock-time}",
            lockAtMostFor = "${fidemax-redemption.scheduler.most-lock-time}"
    )
    public void checkOutOfSyncRedemptions() {
        var start = System.currentTimeMillis();
        try {
            log.info("RedemptionScheduler.checkOutOfSyncRedemptions - Start");

            service.syncRedemptions();

        } finally {
            log.info("RedemptionScheduler.checkOutOfSyncProducts - End - took [{}ms]", (System.currentTimeMillis() - start));
        }
    }
}