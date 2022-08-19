package common.handler;

import common.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 远程服务提供者，响应的是json数据。
 */
@RestController
public class ProviderHandler {

    @RequestMapping("/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        // 获取当前Web 应用的端口号
        int serverPort = request.getServerPort();

        return new Employee(555, "tom555"+"provider实例端口："+serverPort, 555.55);
    }
}