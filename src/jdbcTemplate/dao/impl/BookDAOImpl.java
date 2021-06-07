package jdbcTemplate.dao.impl;

import jdbcTemplate.dao.BookDAO;
import jdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 10:46
 */
@Repository
public class BookDAOImpl implements BookDAO {
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql="insert into t_user(username,uStatus) values(?,?)";
        int update = jdbcTemplate.update(sql, user.getUserId(), user.getUsername(), user.getuStatus());
        System.out.println(update);
    }

    @Override
    public void update(User user) {
        String sql="update t_user set username=?,uStatus=? where userId=?";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getuStatus(), user.getUserId());
        System.out.println(update);
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from t_user where userId=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int queryCount() {
        String sql="select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public User queryForOne(Integer id) {
        String sql="select * from t_user where userId=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public List<User> queryAll() {
        String sql="select * from t_user";
        List<User> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql="insert into t_user(username,uStatus) values(?,?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);

    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql="update t_user set username=?,uStatus=? where userId=?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql="delete from t_user where userId=?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
}
