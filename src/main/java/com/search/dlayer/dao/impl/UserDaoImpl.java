package com.search.dlayer.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.search.dlayer.dao.UserDao;
import com.search.dlayer.entity.User;
import com.search.dlayer.entity.UserRowMapper;

/**
 * ユーザDao
 *
 * @author hitac
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> search(String id) {
        // sql文
        String sql = "select * from m_user where id= ?";
        return jdbcTemplate.query(sql, new Object[] {id}, new UserRowMapper());
    }

    @Override
    public int insert(User user) {
        // sql文
        String sql = "insert into m_user(id,name) values (?,?)";
        return jdbcTemplate.update(sql, new Object[] {user.getId(), user.getName()});
    }

    @Override
    public int update(User user) {
        // sql文
        String sql = "update m_user set name = ? where id = ?";
        return jdbcTemplate.update(sql, new Object[] {user.getName(),user.getId()});
    }

    @Override
    public int delete(User user) {
        // sql文
        String sql = "delete from m_user where id = ?";
        return jdbcTemplate.update(sql, new Object[] {user.getId()});
    }

}
