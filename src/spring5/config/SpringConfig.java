package spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //添加这个注解就把这个类变成了配置类，来代替xml配置文件
@ComponentScan(basePackages = {"spring5"})
public class SpringConfig {
}
