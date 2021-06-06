package cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"cloud.provider.feign" })
public class CloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderApplication.class, args);
    }

}
