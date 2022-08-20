package common.remote;

import common.entity.Employee;
import common.factory.MyFallBackFactory;
import common.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口方法声明注意：
 *      1、服务提供者接口方法声明处，被依赖后需要被启动类扫描的到，因此需要在子包
 *      2、服务提供者只需要声明与接口声明方法相同，不需要实现方法，
 *      3、如果是handler方法方法，接口声明时也需要使用requestmapping注解，来标识某个handler方法
 */
//@FeignClient注解标识当前接口和一个provider对应，注解中value属性指定要调用的provider的微服务名称

/**
 * 在@FeignClient 注解中增加 fallbackFactory 属性，指定 FallbackFactory 类型的类，保证备用方案返回相同类型的数据
 * 指定 consumer 调用 provider 时如果失败所采取的备用方案
 */
@FeignClient(value = "provider",fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
    @RequestMapping("/get/employee/remote")
    Employee getEmployeeRemote();

    @RequestMapping("/get/employee/new")
    public ResultUtil<Employee> getNewEmployee(@RequestParam("id") Integer id);
}
