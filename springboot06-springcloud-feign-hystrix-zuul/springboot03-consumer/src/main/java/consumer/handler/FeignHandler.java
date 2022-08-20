package consumer.handler;

import common.entity.Employee;
import common.remote.EmployeeRemoteService;
import common.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class FeignHandler {
    /**
     * 注入远程调用接口
     */
    @Autowired
    private EmployeeRemoteService remoteService;


    @RequestMapping("/get/employee/feign")
    public ResultUtil<Employee> getEmployeByFeign(HttpServletRequest request){
        request.setAttribute("name","yama");//无法传递到提供者
        Employee employeeRemote = remoteService.getEmployeeRemote();
        return ResultUtil.successWithData(employeeRemote);
    }

    @RequestMapping("/get/employee/save")
    public ResultUtil<Employee> saveEmployee(){
        return remoteService.getNewEmployee(18);
    }
}
