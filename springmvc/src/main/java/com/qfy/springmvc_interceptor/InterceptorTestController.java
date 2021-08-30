package com.qfy.springmvc_interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {
    @RequestMapping("/test01")
    public String test01(){
        System.out.println("拦截器测试01方法通过");
        return "success";
    }
}
