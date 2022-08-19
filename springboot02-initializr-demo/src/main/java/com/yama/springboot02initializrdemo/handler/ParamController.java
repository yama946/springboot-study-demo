package com.yama.springboot02initializrdemo.handler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 使用注解@ConfigurationProperties映射
 * 通过注解@ConfigurationProperties(prefix="配置文件中的key的前缀")
 * 可以将配置文件中的配置自动与实体进行映射
 * 自动匹配，容器中的变量进行注入，适合较多的变量的配置
 * 注意：
 *      使用此注解进行映射时，需要通过set方式设置值，所有成员变量需要存在set方法
 */
@RestController
@ConfigurationProperties(prefix="person2")
public class ParamController {
    //注解用来指定：yml文件中映射值的日期格式，默认格式为2091/23/23
    //如果使用注解，需要依照注解中格式进行配置值
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime;

    private String name;

    private Integer age;

    @GetMapping("/param")
    public String ConfigProperties(){
        return "姓名："+name+"-----年龄："+age+"---"+dateTime;
        //输出：姓名：yama-----年龄：23
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
