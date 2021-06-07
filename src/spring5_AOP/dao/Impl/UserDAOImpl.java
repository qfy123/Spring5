package spring5_AOP.dao.Impl;

import spring5_AOP.dao.UserDAO;

/**
 * @author QFY
 * @Description
 * @create 2021-06-02 17:13
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
