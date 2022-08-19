package com.yama.springboot02initializrdemo.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController注解相当于controller与responsebody注解结合使用
 * 此类中方法都是直接返回字符串，不再经过视图解析器。
 */

/**
 * 使用注解Value，实现将配置文件中的数据进行注入
 * 直接使用注解即可，不需要再引入文件，因为application.yml配置文件，已经被默认加载
 * 需要配置el表达式使用，因为配置文件被加载，其中的对象被加载到spring的ioc域中
 */
@RestController
public class QuickController {
    @Value("${person1.name}")
    private String name;
    @Value("${person1.age}")
    private Integer age;

    @RequestMapping("/init")
    public String demo(){
        return "快速创建springboot"+"姓名："+name+"---年龄："+age;
        //输出：快速创建springboot姓名：yama---年龄：23
    }
}
