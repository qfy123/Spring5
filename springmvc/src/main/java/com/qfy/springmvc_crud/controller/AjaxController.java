package com.qfy.springmvc_crud.controller;

import com.qfy.springmvc_crud.dao.EmployeeDao;
import com.qfy.springmvc_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class AjaxController {
    @Autowired
    EmployeeDao employeeDao;
    /*
    将返回的数据放在响应体中，如果是对象，自动将对象转为json格式，返回给浏览器
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){//@RequestBody:接收json数据，封装为对象
        System.out.println("请求体:"+body);
        return "success";
    }
}
