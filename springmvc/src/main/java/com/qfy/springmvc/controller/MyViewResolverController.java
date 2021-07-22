package com.qfy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器和视图对象
 * @author QFY
 * @Description
 * @create 2021-07-16 16:17
 */
@Controller
public class MyViewResolverController {
    @RequestMapping("/handleplus")
    public String handleplus(Model model){
        List<String> vname=new ArrayList<>();
        List<String> imgname=new ArrayList<>();
        vname.add("肉蛋冲击");
        vname.add("巨龙撞击");
        imgname.add("自拍1");
        imgname.add("自拍2");
        model.addAttribute("video",vname);
        model.addAttribute("imgs",imgname);
        return "wuhu:/qifei";
    }

}
