package hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

//@EnableHystrixDashboard注解用来启用Hystrix仪表盘功能
@EnableHystrixDashboard
@SpringBootApplication
public class SpringbootHystrix {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHystrix.class,args);
    }

}
