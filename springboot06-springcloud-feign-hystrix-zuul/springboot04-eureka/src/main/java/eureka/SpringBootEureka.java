package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka与nacos注册中心使用：
 * eureka使用：
 * 服务器端：通过springboot建立微服务
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringBootEureka {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootEureka.class,args);
    }
}
