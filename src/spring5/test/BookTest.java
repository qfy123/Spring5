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
        ApplicationContext context=new ClassPathXmlApplicationContext("abc.xml");
        Book book = context.getBean("book", Book.class);
        book.sout();
    }
}
