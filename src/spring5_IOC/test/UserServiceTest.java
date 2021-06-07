package spring5_IOC.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_IOC.service.UserService;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:10
 */
public class UserServiceTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("abc2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
