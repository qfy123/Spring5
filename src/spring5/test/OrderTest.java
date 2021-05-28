package spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5.Order;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 18:19
 */
public class OrderTest {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("abc.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);

    }
}
