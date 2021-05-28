package spring5.service;

import spring5.dao.UserDAO;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:00
 */
public class UserService {
    //创建UserDAO类型的属性，生成set方法
    private UserDAO userDAO;
    public void add(){
        System.out.println("UserService的add方法");
        userDAO.update();
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
