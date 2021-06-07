package jdbcTemplate.dao;

import jdbcTemplate.entity.User;

import java.util.List;

/**
 * @author QFY
 * @Description
 * @create 2021-06-03 10:46
 */
public interface BookDAO {
    void add(User user);

    void update(User user);

    void delete(Integer id);

    int queryCount();

    User queryForOne(Integer id);

    List<User> queryAll();

    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
