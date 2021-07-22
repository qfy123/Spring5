package com.qfy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author QFY
 * @Description
 * @create 2021-06-08 14:01
 */
//@RequestMapping("/hh")
@Controller
public class RequestMappingController {
    @RequestMapping("/handle01")//如果在类上加@RequestMapping注解，就代表给这个类的所有方法提供了基准地址，此时的请求为/hh/handle01，而不是/handle01
    public String handle01(){
        return "success";
    }
    /**
     * RequestMapping的其他属性
     * method:限定请求方式，只有指定的请求方式（get、post等）才会接受，默认为全接受
     * params:规定请求参数
     * headers:规定请求头，和params一样，
     * consumes:只接受内容类型是哪种的请求，规定请求头中的Content-Type
     * produces:告诉浏览器返回的内容类型是什么
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST)//客户端输入或点击网址都是get请求，非get请求就不接受，以4开头的错误都为客户端错误
    public String handle02(){
        return "success";
    }
//    比如：params={"username"}，发送请求的时候必须有叫username的参数,没带就会404
//     *          params={"!username"}，发送请求的时候不能有叫username的参数，带了就会404
//     *          params={"username=value"}，发送请求是必须username的参数值为value，否则404
//     *          params={"username!=value"}，发送请求必须username参数值不是value（不带username或者值不是value），否则404
//     *          params={"","",""},多规则，请求参数必须都满足，否则404
    @RequestMapping(value = "/handle03",params = {"username"})
    public String handle03(){
        return "success";
    }

    /**
     * User-Agent:浏览器信息
     *
     */
    @RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.864.41"})
    public String handle04(){
        return "success";
    }
    //url精准匹配
    @RequestMapping(value = "/urlTest01")
    public String urlTest01(){
        return "success";
    }
    //？通配符可以代替任意字符,少一个多一个都不行
    @RequestMapping(value = "/urlTest0?")
    public String urlTest02(){
        return "success";
    }
    //*代替任意字符，一串字符也行，没有字符也行
    @RequestMapping(value = "/urlTest0*")
    public String urlTest03(){
        return "success";
    }
    /*
    路径中可以有占位符(只能占一层)，比如我们要访问的地址有一部是变动的，可以把变动的这部分用{}引起来，里面加一个变量名（自己定义）
    用@PathVariable注解来获取这个变量
     */
    @RequestMapping(value = "/user/{id}")
    public String pathVariableTest(@PathVariable("id")String id){
        System.out.println("路径上的占位符的值是"+id);
        return "success";
    }

    /*
    SpringMVC中如何获取请求的信息
    默认方式获取请求参数：
        直接在方法的形参中写一个和参数名同名的变量，这个变量就来接受请求参数的值

    RequestParam：获取请求参数，默认是必须有的
        该注解有三个属性：
            value：指定要获取的参数的key（比如下面写的"user"）
            required：是否必须要有参数，默认为true
            defaultValue：设置默认值，默认为null
        @RequestParam("user") String username和
        username=req.getParameter("user")一样的效果
    RequestHeader：获取请求头中的某个key的值
    CookieValue:获取某个cookie的值

     */
    @RequestMapping("/requestTest01")
    public String requestTest01(@RequestParam("user") String username, @RequestHeader("User-Agent") String userAgent,@CookieValue("JSESSIONID") String jid){
        System.out.println("请求参数为"+username);
        System.out.println("请求头信息为"+userAgent);
        System.out.println("cookie中的jid是"+jid);
        return "success";
    }
}
