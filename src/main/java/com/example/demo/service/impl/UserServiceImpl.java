package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import com.example.demo.mapper.primary.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.primary.User;
import com.example.demo.entity.vo.BusResult;
import com.example.demo.service.UserService;
import com.example.demo.util.RetCode;
import com.example.demo.util.UtilLog;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    /**
     * 日志控件
     */
    protected UtilLog log = UtilLog.getInstance(this);

    @Resource
    private UserMapper userMapper;

    @Override
    public BusResult insertUser(User user) {
        BusResult resurt = new BusResult(RetCode.FAIL, "失败");
        int rel = 0;
        if (null != user) {
            //判断该用户是否已存在
            String userName = user.getUsername();
            User user1 = this.userMapper.selectUserByUserName(userName);
            if (null == user1) {
                //将新用户插入
                rel = this.userMapper.insert(user);
                if (rel > 0) {
                    resurt = new BusResult(RetCode.SUCCESS, "用户信息插入成功！");
                } else {
                    resurt = new BusResult(RetCode.FAIL, "插入失败！！");
                }

            } else {
                resurt = new BusResult(RetCode.FAIL, "该用户已存在！");
            }
        } else {
            resurt = new BusResult(RetCode.FAIL, "用户信息不能为空！");
        }


        return resurt;
    }

    @Override
    public List<User> findUsers() {
        return null;
    }

    @Override
    public User findUserByUserName(String username) {
        return this.userMapper.selectUserByUserName(username);
    }

    @Override
    public User findUserById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public BusResult getListPage(Page page, Map<String,Object> map){
        BusResult resurt = new BusResult(RetCode.FAIL, "失败");
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> userList=this.userMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<User> pageList = new PageInfo<User>(userList);
        if(null!=pageList){
            resurt = new BusResult(RetCode.SUCCESS,"成功",pageList);
        }
        return resurt;
    }


}
