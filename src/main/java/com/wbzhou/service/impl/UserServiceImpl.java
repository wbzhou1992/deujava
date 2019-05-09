package com.wbzhou.service.impl;


import com.wbzhou.dao.UserDao;
import com.wbzhou.model.User;
import com.wbzhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user){
        Long currentTimeMillis = System.currentTimeMillis();
        user.setCreatedAt(currentTimeMillis);
        user.setUpdatedAt(currentTimeMillis);
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        user.setName("wbzhou");
        user.setVersion(0);
        userDao.insert(user);
    }

    @Override
    public User getUserById(String username){
        return userDao.getUserById(username);
    }
}
