package com.med.dao;

import com.med.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        List<User> result = jdbcTemplate.query(
                "SELECT * FROM users ",
                (rs, rowNum) -> new User(rs.getString("user_name"), rs.getString("first_name"), rs.getString("last_name"))
        );

        return result;
    }

}


