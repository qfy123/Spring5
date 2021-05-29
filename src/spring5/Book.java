package spring5;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 17:58
 */
@Component(value = "book")//注解方式的效果等同于   <bean id="book" class="包类名"/> ,注解的value属性可以不写，默认是类名称，首字母小写
public class Book {
    private String name;
    private String author;
    private List<String> list;
    //set方法注入
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


}
