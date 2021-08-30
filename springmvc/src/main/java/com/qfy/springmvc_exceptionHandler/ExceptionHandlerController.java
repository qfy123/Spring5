package com.qfy.springmvc_exceptionHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {
    @RequestMapping("/exception01")
    public String handle01(Integer i){
        System.out.println("handle01方法执行");
        System.out.println(10/i);
        return "success";
    }
    @RequestMapping("/exception02")
    public String handle02(@RequestParam("username")String username){
        if (!"admin".equals(username)){
            System.out.println("登录失败");
            throw new UsernameNotFound();
        }
        System.out.println("登录成功");
        return "success";
    }

    /**
     * 告诉springmvc这个方法专门处理它指定类型的异常
     * 给这个方法传入一个exception，就可以在页面获得错误信息
     * 要在页面展示错误信息，不能给这个方法传入model，springmvc不认，返回ModelAndView就行
     * 如果发生了某一种异常，先找有没有针对该类型的异常处理，如果没有就去找全局异常处理
     */

}
