package spring5_AOP.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author QFY
 * @Description
 * @create 2021-06-02 18:29
 */
//增强类
@Component
@Aspect
@Order(3)
public class UserProxy {
    //相同切入点抽取
    @Pointcut(value = "execution(* spring5_AOP.aop_annotation.User.add(..))")
    public void pointdemo(){

    }

    //前置通知，加上切入点表达式
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("前置通知....");
    }
    //最终通知
    //异常通知
    //在方法返回值之后执行
    @AfterReturning(value = "pointdemo()")
    public void afterReturning(){
        System.out.println("后置通知....");
    }
    @After(value = "pointdemo()")
    public void after(){
        System.out.println("最终通知....");
    }
    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing(){
        System.out.println("异常通知....");
    }
    @Around(value = "pointdemo()")
    //环绕通知
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.....");
        //中间是被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.....");
    }

}
