package yama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot项目的引导类也就是入口，项目的类名没有要求，建议名字可读性要好
 * 但是要使用注解@SpringBootApplication告知springboot环境这是一个引导类，才能使用
 * 注意：引导类不能在子包中，因为在一个子包中其他类引导类无法加载，可以和所有类在一个包内也行，
 * 情况2；
 * 如果要扫描的包不在引导类的子包中可以通过注解
 * componentscan进行指定要扫描的包，但是此时的默认规则将失效
 */
/*手动指定要扫描的包，当要扫描的包不在启动类默认扫描包中可以使用此注解
但是，与此同时约定的默认扫描的包规则也就失效了
 */
//@ComponentScan("com.yama.controller")
@SpringBootApplication
public class MySpringbootApplication {
    /**
     * 引导类，可以启动springboot中集成的tomcat，日志如下，
     * 2021-09-09 14:51:52.849  INFO 9156 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  :
     *                                          Tomcat started on port(s): 8080 (http) with context path ''
     * 但是这个tomcat不像本地tomcat并没有自带初始化界面，直接访问会显示----Whitelabel Error Page
     * 我们需要自建一个controller类进行，接受访问进行处理请求，返回页面。
     * @param args
     */
    //main是Java程序的入口
    public static void main(String[] args) {
        //运行引导类
        //run方法，表示运行springboot的引导类，run参数就是springboot引导类的字节码对象
        SpringApplication.run(MySpringbootApplication.class);
    }
}
