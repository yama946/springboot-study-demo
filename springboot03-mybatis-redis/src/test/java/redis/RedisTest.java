package redis;

import mybatis.redis.MybatisRedisApplication;
import mybatis.redis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * springboot集成redis
 * 1、在pom文件中添加相关配置spring-boot-start-data-redis
 * 2、在配置文件中配置redis数据
 * 如果没有另行配置redisTemplate，会自动配置生成
 * 如果自行配置会使用，我们自定义配置注入的对象
 */
@SpringBootTest(classes = MybatisRedisApplication.class)
public class RedisTest {

    //直接表示操作字符串类型
    @Autowired
    private StringRedisTemplate redis;
    //需要指定操作的数据类型,如果使用Object类型存储，会出现序列化
    //序列化后保存到redis数据库中会出现多余符号。
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Test
    public void testRedis(){
        ValueOperations<String, String> str = redis.opsForValue();
        str.set("name","yama");
        String name = str.get("name");
        System.out.println(name);
    }
}
