package com.yama.springboot02initializrdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Conditionalon注解的使用：有条件导入
 *
 * @Import注解的使用：无参导入对象进ioc
 * @Import是Spring基于 Java 注解配置的主要组成部分。@Import注解提供了@Bean注解的功能，
 * 同时还有原来Spring基于 xml 配置文件里的标签组织多个分散的xml文件的功能，
 * 当然在这里是组织多个分散的@Configuration的类。
 */
@SpringBootApplication
public class Springboot02InitializrDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02InitializrDemoApplication.class, args);
    }

}
