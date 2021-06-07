package transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.dao.UserDAO;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 16:30
 */
@Service
@Transactional(transactionManager = "transactionManager") //开启事务的注解，可以写在类上，表示类里所有方法都开启事务，写在方法上就单独给这个方法开启事务
public class UserService {
    @Autowired
    private UserDAO userDAO;
    //转账方法
    public void transfer(){
        userDAO.reduceMoney();
        userDAO.addMoney();
    }
}
