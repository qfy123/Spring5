package spring5.dao.impl;

import spring5.dao.UserDAO;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 19:01
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void update() {
        System.out.println("UserDAO的update方法");
    }
}