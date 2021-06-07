package spring5_AOP.aop_annotation;

import org.springframework.stereotype.Component;

/**
 * @author QFY
 * @Description
 * @create 2021-06-02 18:29
 */
//被增强的类
@Component
public class User {
    public void add(){

        System.out.println("add.........");
    }
}
