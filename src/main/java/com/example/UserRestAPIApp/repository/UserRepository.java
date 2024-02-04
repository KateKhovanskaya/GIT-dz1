package com.example.UserRestAPIApp.repository;

import com.example.UserRestAPIApp.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
//    private List<User> users = new ArrayList<>();
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public List<User> getUsers(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i)->{
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }
    public User save(User user){
        String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return user;
    }
}
