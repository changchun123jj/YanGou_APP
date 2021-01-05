package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.primary.User;
import com.example.demo.entity.vo.BusResult;
import com.github.pagehelper.Page;

public interface UserService {

    /**
     * 插入用户信息
     */
    BusResult insertUser(User user);


    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findUsers();

    /**
     * 查询某个用户的信息
     */
   User findUserByUserName(String username);


   User findUserById(Integer id);

   BusResult getListPage(Page page, Map<String,Object> map);


}
