package jdbcTemplate.test;

import jdbcTemplate.entity.User;
import jdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 11:05
 */
public class UserTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user=new User();
        user.setUsername("芜湖");
        user.setuStatus("起飞了");
        bookService.add(user);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        User user=new User();
        user.setUserId(1);
        user.setUsername("大司马");
        user.setuStatus("芜湖");
        bookService.update(user);
    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delete(1);
    }
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.queryCount());
    }
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.queryForOne(4));
    }
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        for (User user : bookService.queryAll()) {
            System.out.println(user);
        }

    }
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"java","a"};
        Object[] o2={"c++","b"};
        Object[] o3={"php","c"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={"java111","a","6"};
        Object[] o2={"c++222","b","7"};
        Object[] o3={"php333","c","8"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }
    @Test
    public void test9(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        Object[] o1={6};
        Object[] o2={7};
        Object[] o3={8};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }
}
