package com.example.demo.mapper.primary;

import com.example.demo.entity.primary.User;
import org.springframework.beans.factory.annotation.Qualifier;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
@RegisterMapper
@Qualifier("primaryDataSource")
public interface UserMapper extends Mapper<User>{
    /**
     * 根据用户名查询用户信息
     */
    User selectUserByUserName(String userName);
}