package com.qfy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1、告訴springmvc这是一个处理器
 * @author QFY
 * @Description
 * @create 2021-06-07 19:19
 */
@Controller//标识哪个组件是控制器
public class FirstController {
    //RequestMapping告诉SpringMVC这个方法用来处理什么请求，参数里的/可以省略，省略就表示默认从当前项目下开始
    @RequestMapping("/hello")//  表示处理当前项目的下的hello请求
    public String firstRequest(){
        System.out.println("请求收到了");
        //视图解析器自动拼串
        return "success";
    }
}
