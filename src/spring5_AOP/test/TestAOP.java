package spring5_AOP.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_AOP.aop_annotation.User;

/**
 * @author QFY
 * @Description
 * @create 2021-06-02 18:42
 */
public class TestAOP {
    //测试前置通知
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
