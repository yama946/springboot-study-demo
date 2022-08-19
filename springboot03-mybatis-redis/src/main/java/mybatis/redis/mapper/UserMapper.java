package mybatis.redis.mapper;

import mybatis.redis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * springboot集成mybatis步骤
 * 1、在pom文件中添加相关注解：mybatis-spring-boot-starter、线程池、数据库驱动
 * 2、建立mybatis的配置文件、相关mapper
 * 3、在mapper上添加注解@Mapper或者在启动类上添加@MapperScan注解
 * 4、在配置文件中进行相关配置
 */


/**
 * 1、@Mapper注解
 * 注解在mapper类上进行使用，需要在springboot默认包扫描规则包中，此时不需要使用@MapperScan注解
 * Mapper标记该类是一个mybatis的mapper接口，可以被springboot自动扫描到spring上下文中
 * 依照配置文件中的配置生成一个代理对象注入到ioc容器中
 * 2、@MapperScan注解
 * 主要用在不在默认包扫描规则下进行指定扫描的类，为mybatis的mapper接口，扫描后依照配置内容
 * 生成代理对象，注入到ioc容器中
 */

@Mapper
//@Repository注解无实际意义，仅仅为了注入对象是无异常提示，
@Repository
public interface UserMapper {
    List<User> queryUserList();
}
