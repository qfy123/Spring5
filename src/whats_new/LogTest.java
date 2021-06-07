package whats_new;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Spring5框架自带了通用的日志封装
 * 1、Spring5已经移除了Log4ConfigListener，官方建议使用Log4j2
 * 2、Spring5框架整合Log4j2
 * @author QFY
 * @Description
 * @create 2021-06-07 15:13
 */
public class LogTest {
    private static final Logger log= LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
