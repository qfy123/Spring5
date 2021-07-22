package com.qfy.springmvc.REST;


import com.qfy.springmvc.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author QFY
 * @Description
 * @create 2021-06-08 15:37
 */
@Controller
public class BookController {
    /*
    如果我们的请求参数是一个pojo，springmvc会自动为这个pojo赋值
     */
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String add(Book book){
        System.out.println("添加成功！");
        System.out.println(book);
        return "success";
    }
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("bid") Integer id){
        System.out.println("删除了"+id+"号图书");
        return "success";
    }
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String update(@PathVariable("bid") Integer id){
        System.out.println("更新了"+id+"号图书");
        return "success";
    }
    //通过get请求来执行查询操作
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String get(@PathVariable("bid")Integer id){
        System.out.println("查询到了"+id+"号图书");
        return "success";
    }
    @RequestMapping(value = "/tosuccess")
    public String toSuccess(){
        return "success";
    }
}
