package spring5_IOC.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5_IOC.Emp;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:24
 */
public class EmpTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("abc3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
