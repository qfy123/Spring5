package whats_new;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import transaction.service.UserService;


/**
 * Spring5整合junit5
 * @author QFY
 * @Description
 * @create 2021-06-07 15:56
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:jdbcTemplate2.xml")
@SpringJUnitConfig(locations = "classpath:jdbcTemplate2.xml")//使用复合注解来代替上面两个注解
public class JUnit5Test {
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.transfer();
    }
}
