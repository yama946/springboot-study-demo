package mybatis.redis;

import mybatis.redis.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@MapperScan("mybatis.redis.mapper")
@Import(User.class)
@SpringBootApplication
public class MybatisRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisRedisApplication.class,args);
    }
}
