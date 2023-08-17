package wiz.fbaa.branchclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BranchClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BranchClientApplication.class, args);
    }

}
