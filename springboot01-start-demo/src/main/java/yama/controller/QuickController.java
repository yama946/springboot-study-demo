package yama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此类之所以能够完成功能是因为spring-boot-starter-web坐标，为我们引入了springmvc相关的东西
 * springboot之所以易用就是因为这些starter中集成了很多东西，简化了配置。
 *
 * springboot中是集成了tomcat，可以直接运行，叫做入式服务器，
 * 没有初始化界面，需要定位到：项目名/controller方法，才会响应响应的页面
 *
 */
@RestController
public class QuickController {

    @RequestMapping("/start")
    public String quick(){
        return "springboot 访问成功";
    }
}


