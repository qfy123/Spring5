package jdbcTemplate.service;

import jdbcTemplate.dao.BookDAO;
import jdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 10:46
 */
@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDAO bookDAO;

    //添加方法
    public void add(User user){
        bookDAO.add(user);
    }
    //修改方法
    public void update(User user){
        bookDAO.update(user);
    }
    //删除方法
    public void delete(Integer id){
        bookDAO.delete(id);
    }
    //查询记录数
    public int queryCount(){
        return bookDAO.queryCount();
    }
    //根据id查询某条记录
    public User queryForOne(Integer id){
        return bookDAO.queryForOne(id);
    }
    //查询所有记录
    public List<User> queryAll(){
        return bookDAO.queryAll();
    }
    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDAO.batchAdd(batchArgs);
    }
    //批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDAO.batchUpdate(batchArgs);
    }
    //批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDAO.batchDelete(batchArgs);
    }
}
