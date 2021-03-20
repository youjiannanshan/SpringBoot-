package com.fanyi.mapper;

import com.fanyi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    //查询全部用户
    List<User> queryUserList();

    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
    int addUser(User user);

    User queryUserById(int id);



    int updateUser(User user);

    int deleteUser(int id);
}
