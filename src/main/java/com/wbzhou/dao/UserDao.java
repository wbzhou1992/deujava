package com.wbzhou.dao;
import com.wbzhou.model.User;

public interface UserDao {
    void insert(User user);
    User getUserById(String username);
}
