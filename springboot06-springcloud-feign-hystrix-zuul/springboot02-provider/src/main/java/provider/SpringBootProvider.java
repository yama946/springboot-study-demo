package provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 提供者启动类
 */
//启用断路器功能
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootProvider {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProvider.class,args);
    }
}
