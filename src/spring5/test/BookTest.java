package spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5.Book;

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
}
