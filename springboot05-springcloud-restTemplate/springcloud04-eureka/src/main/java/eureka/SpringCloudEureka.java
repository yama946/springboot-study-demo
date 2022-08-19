package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * EnableEurekaServer注解
 * 作用：
 *      启用Eureka 服务器功能,此时此springboot工程就会作为eureka服务器，并加载相关bean组件
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEureka {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEureka.class);
    }
}
