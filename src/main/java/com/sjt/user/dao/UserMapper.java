package com.sjt.user.dao;

import com.sjt.user.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public User selectById(int id);

    @Select("select * from user")
    public List<User> selectAll();
}
