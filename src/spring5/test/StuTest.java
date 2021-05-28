package spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5.Stu;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:51
 */
public class StuTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("abc4.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.print();
    }
}
