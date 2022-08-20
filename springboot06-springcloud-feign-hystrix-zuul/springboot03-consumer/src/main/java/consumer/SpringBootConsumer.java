package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

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

/**
 * @EnableFeignClients(basePackages = "common.remote")注解，开启远程调用功能，
 * 前提要将远程调用接口应用扫描注册到当前应用的ioc容器中，所以需要通过basePackages
 * 参数进行指定依赖中包结构，将所需对象进行扫描。
 */

//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
//注意：@EnableFeignClients注解只能够将@FeignClients扫描到容器中，Component注解标志的对象无法扫描
@EnableFeignClients(basePackages = {"common.remote"})
@ComponentScan(basePackages = {"consumer","common.factory"})
public class SpringBootConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumer.class,args);
    }
}
