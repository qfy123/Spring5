package spring5_AOP.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author QFY
 * @Description
 * @create 2021-06-02 19:04
 */
@Component
@Aspect
@Order(1)   //order注解可以设置不同类对同一个方法的增强的优先级，数字越小优先级越高
public class PersonProxy {
    @Before(value = "execution(* spring5_AOP.aop_annotation.User.add(..))")
    public void before(){
        System.out.println("person的前置通知....");
    }
}
