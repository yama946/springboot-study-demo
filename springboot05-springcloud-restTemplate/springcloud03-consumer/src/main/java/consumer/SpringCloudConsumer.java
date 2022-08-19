package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 这里的版本指的是springcloud版本，当版本是以Dxxx开头，或者更低版本必须使用，两者选择一个标识即可
 * 使用：
 * @EnableEurekaClient只能用来开启eureka注册中心的客户端功能，@EnableDiscoveryClient和前者功能一样；
 * 区别是@EnableDiscoveryClient不仅仅是开启eureka注册中心，还可用来开启其他注册中心比如nacos。
 *      较低版本需要使用@EnableDiscoveryClient 注解。
 *              -----启动eureka客户端功能
 *       稍高版本也可以使用 @EnableDiscoveryClient注解。
 *              ------发现注册中心中服务的功能
 *              这个注解也可以用到其他注册中心启动，不局限于eureka注册中心
 * 由于此时版本较高，客户端可以不用这两个注解也是可以的
 */

//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer.class,args);
    }
}
