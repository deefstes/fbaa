package wiz.fbaa.branchclient.config;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import wiz.fbaa.branchclient.grpc.FBAAGrpc;

@RequiredArgsConstructor
@Configuration
public class GrpcConnectionConfig {

    private final PropertiesConfig propertiesConfig;

    @Profile("test")
    @Bean("fbaaManagedChannel")
    public ManagedChannel testFbaaManagedChannel() {
        return null;
    }

    @Profile("!test")
    @Bean("fbaaManagedChannel")
    public ManagedChannel fbaaManagedChannel() {
        ManagedChannel mc = Grpc.newChannelBuilder(propertiesConfig.getServerUrl(), InsecureChannelCredentials.create()).build();
        return mc;
    }

    @Bean("fbaaBlockingGrpcImpl")
    public FBAAGrpc.FBAABlockingStub fbaaBlockingStub(ManagedChannel fbaaManagedChannel) {
        if (fbaaManagedChannel == null) {
            return null;
        }
        return FBAAGrpc.newBlockingStub(fbaaManagedChannel);
    }
}
