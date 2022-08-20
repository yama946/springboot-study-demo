# springboot学习DEMO

##注意点1：springcloud与springboot版本之间的问题
springboot版本与springcloud版本需要进行匹配兼容，否则通过两者创建的微服务是无法正常启动的。
比如使用springboot创建微服务同时使用springcloud中的组件。详细匹配规则参考：https://spring.io/projects/spring-cloud#overview

##注意点2：Feign传递HttpServletRequest对象
通过Feign进行模块间远程过程调用，消费者不能直接向提供者直接传递request、response对象，否则会异常。
场景：
提供者：需要传递request对象
```java
    @RequestMapping("/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        // 获取当前Web 应用的端口号
        int serverPort = request.getServerPort();

        String name = (String) request.getAttribute("name");

        return new Employee(555, "tom555"+"provider实例端口："+serverPort+"姓名："+name, 555.55);
    }
```
调用接口：
```java
    @RequestMapping("/get/employee/remote")
    Employee getEmployeeRemote();
```
此时调用接口不需要将request对象作为调用时传参，也就是不需要传入消费者的请求，提供者本身的controller中springmvc会自动传参。
只不过，消费者中request参数需要通过其他方式传递。如果直接通过request传递会报错。

## Hystrix熔断使用步骤以及注意事项--->服务提供者
1、首先需要添加Hystrix依赖，熔断和降级所添加的依赖相同
>         <!--添加hystrix熔断功能-->
>           <dependency>
>             <groupId>org.springframework.cloud</groupId>
>              <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
>           </dependency>
          
2、在提供方启动器处添加启动hystrix熔断功能的注解---->
```java
//启用断路器功能
@EnableCircuitBreaker
```
3、在提供者的handler要提供备用处理方案的方法上添加注解@HystrixCommand(fallbackMethod = "newEmployeeBackUp")
   其中fallbackMethod表示熔断后的备用处理方法名。
```java
    @HystrixCommand(fallbackMethod = "newEmployeeBackUp")
    @RequestMapping("/get/employee/new")
    public ResultUtil<Employee> getNewEmployee(@RequestParam("id") Integer id)
```
备用方法
```java
/**
     * 备用方法要与异常调用方法返回值类型相同，否则消费者无法处理数据
     * 要求：备用方法与主方法的参数相同，否则调用方无法找到备用方法
     */
    public ResultUtil<Employee> newEmployeeBackUp(@RequestParam("id") Integer id){
        return ResultUtil.failed("当前调用方法失效，请稍后再试");
    }
```

**注意：备用方法要求参数与主方法相同，否则消费者调用时会报无法找到备用方法异常**

## Hystrix降级使用步骤及注意事项
1、在公共接口处添加相关hustrix依赖
2、在@FeignClient注解中添加fallbackfactory属性，执行备用处理工厂类
3、备用处理工厂类，必须实现fallbackfactroy接口并返回@FeignClient注解标志的接口类
4、在消费者中开启相关hystrix配置，将fallbackfactroy接口实现通过启动器扫描添加到ioc容器中，进行调用。

## 针对ThreadLocal的理解
ThreadLocal就是线程本地变量。当一个线程中需要传递值时使用。
场景：比如同一个线程中一个方法需要调用另一个方法中的数据，我们就可以使用线程本地变量来传递这个数据。
 

