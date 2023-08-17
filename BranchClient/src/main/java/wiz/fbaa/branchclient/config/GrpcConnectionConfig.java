package wiz.fbaa.branchclient.config;

import io.grpc.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import wiz.fbaa.branchclient.grpc.FBAAGrpc;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class GrpcConnectionConfig {

    private final PropertiesConfig propertiesConfig;

    @Profile("test")
    @Bean("fbaaManagedChannel")
    public ManagedChannel testFbaaManagedChannel() {
       log.info("Found test channel");
        return new ManagedChannel() {
            @Override
            public ManagedChannel shutdown() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public ManagedChannel shutdownNow() {
                return null;
            }

            @Override
            public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
                return false;
            }

            @Override
            public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
                return null;
            }

            @Override
            public String authority() {
                return null;
            }
        };
    }

    @Profile("!test")
    @Bean("fbaaManagedChannel")
    public ManagedChannel fbaaManagedChannel() {
        log.info("Found channel {}", propertiesConfig.getServerUrl());
        return Grpc.newChannelBuilder(propertiesConfig.getServerUrl(), InsecureChannelCredentials.create()).build();
    }

    @Bean("fbaaBlockingGrpcImpl")
    public FBAAGrpc.FBAABlockingStub fbaaBlockingStub(ManagedChannel fbaaManagedChannel) {
        if (fbaaManagedChannel == null) {
            return null;
        }
        log.info("Creating stub {} {}", !fbaaManagedChannel.isShutdown(), !fbaaManagedChannel.isTerminated());
        return FBAAGrpc.newBlockingStub(fbaaManagedChannel);
    }
}
