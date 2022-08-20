package consumer.handler;

import common.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConsumerHandler {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 不使用注册中心，仅仅使用restTemplate方法
     * @param request
     * @return
     */
    @RequestMapping("/get/employee/resttemplate")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        // 远程调用方法的主机地址
        String host = "http://localhost:8000";
        // 远程调用方法的具体URL 地址
        String url = "/provider/get/employee/remote";
        return restTemplate.getForObject(host + url, Employee.class);
    }


    /**
     * 从注册中心中获取服务
     * @return
     */
    @RequestMapping("/get/employee/eureka")
    public Employee getEmployeeRemote2() {
        // 远程调用方法的主机地址
        // String host = "http://localhost:8888";
        // 引入Eureka 和Ribbon 后，就可以使用微服务名称替代IP 地址+端口号
        //这样就是
        String host = "http://provider";
        // 远程调用方法的具体URL 地址
        String url = "/provider/get/employee/remote";

        return restTemplate.getForObject(host + url, Employee.class);
    }
}
