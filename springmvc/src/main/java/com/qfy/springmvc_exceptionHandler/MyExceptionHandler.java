package com.qfy.springmvc_exceptionHandler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理异常的类要加入ioc容器中
 * 如果说其他类中自带异常处理方法，那么在处理异常的时候，优先执行其他类自带的异常处理
 * 其他类中如果只有处理全局异常的，而专门处理异常的类中有精确处理某个异常的方法，那么当该种异常发生时，还是会执行其他类的全局异常处理（自扫门前雪）
 */
@ControllerAdvice//该注解表示该类专门处理异常
public class MyExceptionHandler {
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handleException01(Exception e){
        System.out.println("handleException01方法执行"+e);
        ModelAndView error = new ModelAndView("error");
        error.addObject("ex",e);
        return error;
    }
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView handleException02(Exception e){
//        System.out.println("全局handleException02方法执行"+e);
//        ModelAndView error = new ModelAndView("error");
//        error.addObject("ex",e);
//        return error;
//    }
}
