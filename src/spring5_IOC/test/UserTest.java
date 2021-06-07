package spring5_IOC.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_IOC.User;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 16:57
 */
public class UserTest {
    @Test
    public void test1(){
        //加载spring的配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("abc.xml");
        //获取配置文件的配置的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}
