package provider.handler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import common.entity.Employee;
import common.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 远程服务提供者，响应的是json数据。
 */
@RestController
public class ProviderHandler {

    @RequestMapping("/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        // 获取当前Web 应用的端口号
        int serverPort = request.getServerPort();

        String name = (String) request.getAttribute("name");

        return new Employee(555, "tom555"+"provider实例端口："+serverPort+"姓名："+name, 555.55);
    }

    /**
     * Hystrix通过@HystrixCommand(fallbackMethod = "NewEmployeeBackUp")注解中的fallbackMethod属性，
     * 定义当达到某种触电，调用异常，触发备用方法处理。
     * @param id
     * @return
     * @throws InterruptedException
     */
    @HystrixCommand(fallbackMethod = "newEmployeeBackUp")
    @RequestMapping("/get/employee/new")
    public ResultUtil<Employee> getNewEmployee(@RequestParam("id") Integer id) {
        if(id==18){
            throw new RuntimeException("启动断路器备用熔断机制");
        }
        if (id==19){
            //也会启用熔断机制，调用延迟
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 获取当前Web 应用的端口号
        return ResultUtil.successWithData(new Employee(id, "tom555", 555.55));
    }
    /**
     * 备用方法要与异常调用方法返回值类型相同，否则消费者无法处理数据
     * 要求：备用方法与主方法的参数相同，否则调用方无法找到备用方法
     */
    public ResultUtil<Employee> newEmployeeBackUp(@RequestParam("id") Integer id){
        return ResultUtil.failed("当前调用方法失效，请稍后再试");
    }

}