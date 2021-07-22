package com.qfy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author QFY
 * @Description
 * @create 2021-06-10 16:24
 */
@Controller
public class ViewController {
    @RequestMapping("/view01")
    public String view01(){
        /*
        我们在视图解析器中设置了前缀和后缀
        返回success时，视图解析器会自动帮我们拼串，解析为/WEB-INF/pages/success.jsp
        如果我们不想返回这个页面，比如返回项目路径下的一个页面，有两种方式
        一种是使用相对路径：
            return "../../view.jsp"
        另一种是使用forward前缀,添加forward后不会添加前缀后缀拼串，转发到当前项目下的view.jsp
         */
        return "forward:/view.jsp";
    }
    @RequestMapping("/view02")
    public String view02(){
        //forward前缀还可以进行多次转发
        //view02请求收到，forward转发到view01请求，view01请求再转发到view.jsp
        return "forward:/view01";
    }
    @RequestMapping("/view03")
    public String view03(){
        //重定向：redirect，原生的servlet需要加上项目名才能成功，而redirect会自动添加项目名
        return "redirect:/view.jsp";
    }
    @RequestMapping("/view04")
    public String view04(){
        return "login";
    }
}
