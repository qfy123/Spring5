package whats_new;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.service.UserService;

/**
 * spring5整合junit4
 * @author QFY
 * @Description
 * @create 2021-06-07 15:46
 */
@RunWith(SpringJUnit4ClassRunner.class)//单元测试框架
@ContextConfiguration("classpath:jdbcTemplate2.xml")//加载配置文件
public class JUnit4Test {
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.transfer();
    }
}
