package spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5.Book;
import spring5.User;
import spring5.autowrite.Emp;
import spring5.config.SpringConfig;
import spring5.service.UserService;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 18:07
 */
public class BookTest {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("abc6.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
    //测试工厂bean，定义类型跟返回类型可以不一致，在MyBean中继承factoryBean后重写getObject方法
    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory1.xml");
        Book myBean = context.getBean("MyBean", Book.class);
        System.out.println(myBean);
    }
    //spring默认bean是单实例
    @Test
    public void test3(){
        /*
        当spring加载xml配置文件时，如果scope是单例，那么在读取xml就会创建一个单例
        如果是多例，那么在调用getBean时才会创建
         */
        ApplicationContext context=new ClassPathXmlApplicationContext("abc6.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        Book book3 = new Book();
        Book book4 = new Book();
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
    }
    //自动装配
    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory2.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
    //用注解方式来生成bean对象
    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory4.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
    //使用注解方式来注入属性
    @Test
    public void test6(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory4.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
    //使用配置类代替xml配置文件的方式
    @Test
    public void test7(){
        //加载配置类
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
