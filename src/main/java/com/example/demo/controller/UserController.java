package com.example.demo.controller;


import com.example.demo.util.UtilGeneration;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.primary.User;
import com.example.demo.entity.vo.BusResult;
import com.example.demo.entity.vo.ResponseResult;
import com.example.demo.service.UserService;
import com.example.demo.util.DateFormatUtil;
import com.example.demo.util.RetCode;
import com.example.demo.util.UtilLog;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(value = "/basic")
public class UserController {
    /**
     * 日志控件
     */
    protected UtilLog log = UtilLog.getInstance(this);

    @Resource
    private UserService userService;

    @PostMapping(value = "/AddUser")
    public ResponseResult<Void> AddUser(@RequestBody Map<String,Object> map) {
        ResponseResult<Void> rr = new ResponseResult<>(RetCode.FAIL, "添加失败");

        try {
            if (null != map) {
                User user = new User();
                user.setId(UtilGeneration.getGenId(User.class.getName()));
                user.setUsername(map.get("userName").toString());
                user.setPassword(map.get("passWord").toString());
                user.setEmail(map.get("email").toString());
                user.setTel(map.get("tel").toString());
                user.setCreatetime(new Date());

                BusResult result = this.userService.insertUser(user);
                if (null != result && result.getRetCode() == 200) {
                    rr = new ResponseResult<>(RetCode.SUCCESS, "添加成功");
                    log.info("用户信息添加成功");
                }

            }
        } catch (Exception e) {
            log.error("失败！", e);
        }

        return rr;
    }
    @PostMapping(value = "/findAll")
    public BusResult findUserByname(@RequestBody Map<String,Object> map){
        BusResult resurt = new BusResult(RetCode.FAIL, "失败");
        if(null!=map){
            Page page = new Page();
            page.setPageNum((int)map.get("pageNum"));
            page.setPageSize((int)map.get("pageSize"));
            resurt=this.userService.getListPage(page,map);

        }
        return resurt;


    }

    @GetMapping(value = "/selectById")
    public User findUserById(@RequestParam("ID") Integer id ){
        return this.userService.findUserById(id);

    }
}
