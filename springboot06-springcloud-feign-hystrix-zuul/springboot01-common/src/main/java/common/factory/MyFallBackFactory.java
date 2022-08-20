package common.factory;

import common.entity.Employee;
import common.remote.EmployeeRemoteService;
import common.util.ResultUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 请注意自动扫描包的规则：比如：feign-consumer 工程需要使用 MyFallBackFactory，那么 MyFallBackFactory 应该在
 * consumer 工程的主启动类所在包或它的子包下，简单来说：哪个工程用这个类，哪个工程必须想办法扫描到这个类
 * 当前工厂类要求：
 * 1、实现FallbackFactory接口
 * 2、FallbackFactory接口中泛型必须是@FeignClient注解标志的接口类型
 * 3、FallbackFactory接口实现方法必须返回@FeignClient注解标志的接口类型，并实现接口。
 */

@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    @Override
    public EmployeeRemoteService create(Throwable throwable) {
        return new EmployeeRemoteService() {
            @Override
            public Employee getEmployeeRemote() {
                return null;
            }

            @Override
            public ResultUtil<Employee> getNewEmployee(Integer id) {
                return ResultUtil.failed("降级机制生效");
            }
        };
    }
}
