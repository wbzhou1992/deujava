package com.wbzhou.service;

import com.wbzhou.model.User;

public interface UserService {
    void addUser(User user);
    User getUserById(String username);
}
