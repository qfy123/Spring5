package spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring5.dao.UserDAO;
import spring5.dao.impl.UserDAOImpl;

import javax.annotation.Resource;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:00
 */
@Service
public class UserService {
    //创建UserDAO类型的属性，添加注入属性的注解，不需要生成set方法
//    @Autowired //根据属性类型进行自动装配
//    @Qualifier (value = "userDAOImpl")
    @Resource(name = "userDAOImpl") //根据属性类型进行注入
    private UserDAO userDAO;
    @Value(value = "abc")
    private String name;

    public void add(){
        System.out.println("UserService的add方法");
        System.out.println(name);
        userDAO.update();
    }


}
