package wiz.fbaa.branchclient.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wiz.fbaa.branchclient.grpc.FBAAGrpcImpl;


@RequiredArgsConstructor
@Component
@Slf4j
public class SchedulerConfig {

    private final FBAAGrpcImpl fbaaGrpcImpl;

    @Scheduled(initialDelay = 1000 * 3, fixedDelay = 1000 * 30)
    public void randomlyReserveBeast() {
        try {
            fbaaGrpcImpl.randomlyReserveCreature();
        } catch (Exception e) {
            log.error("Error reserving creature", e);
        }
    }
}
