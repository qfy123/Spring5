package transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.config.TxConfig;
import transaction.service.UserService;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 16:40
 */
public class UserTest {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbcTemplate2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }

    @Test
    public void test2(){
        ApplicationContext context=new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }
}
