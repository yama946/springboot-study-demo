package consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestTemplate，使用RestTemplate实现模块之间的远程调用，两种情况：
 * 第一种情况：
 * 不使用注册中心的情况下，单独使用RestTemplate实现两端远程调用
 * 第二种情况：
 * 有注册中心eureka参数的情况下，实现两个模块之间的远程调用
 * 两种情况的区别：
 * 只有在添加注册中心的情况下，才需要添加添加注解@LoadBalanced，来开启ribbon的负载均衡功能
 * eureka注册中心依赖ribbon。
 */
@Configuration
public class RestTemplateConfig {
    /**
     * 将RestTemplate对象注入ioc中进行调用
     * @return
     */
    //获取restTemplate，用来进行远程调用，在没有springcloud组件的参与下
    //相当于springcloud组件中的feign
    @Bean
    @LoadBalanced   //开启此远程调用方法的负载均衡功能，否则ribbon无法通过微服务名发现服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
