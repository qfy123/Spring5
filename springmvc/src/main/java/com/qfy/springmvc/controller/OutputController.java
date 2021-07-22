package com.qfy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author QFY
 * @Description
 * @create 2021-06-10 9:58
 */
@Controller
/*
SessionAttributes:该注解可以临时给session域中添加数据
该注解只能写在类上
该注解的value属性，我们这里写的是msg，跟下面方法中添加的数据的key是一样的，给BindingAwareModelMap传数据时，也会传一份给session，因为它们的key是一样的
 */
@SessionAttributes(value = "msg")//不常用
public class OutputController {
    //在方法参数处传入map、model或者modelmap，给这些参数里保存的数据都会放在域中，可以在页面获取
    @RequestMapping("/output01")
    public String output01(Map<String,Object> map){//传map数据会放在请求域中
        map.put("msg","map芜湖！~");
        System.out.println("map的类型"+map.getClass());
        return "success";
    }
    @RequestMapping("/output02")
    public String output02(Model model){//model的数据放在请求域中
        model.addAttribute("msg","model芜湖");
        System.out.println("map的类型"+model.getClass());
        return "success";
    }
    @RequestMapping("/output03")
    public String output03(ModelMap modelMap){//model的数据放在请求域中
        modelMap.addAttribute("msg","modelMap芜湖");
        System.out.println("map的类型"+modelMap.getClass());
        return "success";
    }
    //map、model、modelMap这三种其实都是org.springframework.validation.support.BindingAwareModelMap这个类
    //相当于给BindingAwareModelMap中保存的东西都会放在请求域中
    @RequestMapping("/output04")
    public ModelAndView output04(){
        //之前return的success就是视图名，视图解析器会帮我们最终拼串得到页面的真实地址
        //ModelAndView既包含视图信息（页面地址），也包含模型数据（给页面带的数据），且数据是放在请求域中的
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg","视图解析器芜湖");
        return view;
    }
}
