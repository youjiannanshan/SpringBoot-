package com.fanyi.service;

import com.fanyi.mapper.UserMapper;
import com.fanyi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getByName(String username){
        return userMapper.findByUsername(username);
    }

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    public User get(String username, String password){
        return userMapper.getByUsernameAndPassword(username, password);
    }
    public void add(User user){
        userMapper.addUser(user);
    }
}
