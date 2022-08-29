package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//启用zuul路由功能
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudZuul {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuul.class);
    }
}
