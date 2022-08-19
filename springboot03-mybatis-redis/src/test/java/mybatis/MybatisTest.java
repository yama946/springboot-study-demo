package mybatis;

import lombok.extern.slf4j.Slf4j;
import mybatis.redis.MybatisRedisApplication;
import mybatis.redis.domain.User;
import mybatis.redis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
/**
 * springboot集成junit4测试单元
 * 第一步：添加依赖test
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-test</artifactId>
 *             <scope>test</scope>
 *         </dependency>
 * 第二步：添加注解
 * RunWith(SpringRunner.class)
 * 作用：用来改变main方法
 * SpringBootTest(classes = Springboot03mybatisApplication.class)
 * 作用；告知测试类，ioc容器位置，进行加载注入
 */
//此处使用的junit5集成测试
@Slf4j
@SpringBootTest(classes = MybatisRedisApplication.class)
public class MybatisTest {
    //此处报错，也可以正常运行，如果需要可以在mapper上添加一个@Repository注解消除，但是没有实际作用
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMybatis(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }
}
