package com.example.demo.controller;

import com.example.demo.util.UtilLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.RedisConfig;
import com.example.demo.entity.vo.BusResult;
import com.example.demo.util.RedisUtil;
import com.example.demo.util.RetCode;


import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/Redis")
public class RedisController {
    /**
     * 日志控件
     */
    protected UtilLog log = UtilLog.getInstance(this);
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisConfig redisConfig;

    @PostMapping(value = "/get")
    public BusResult getVall() {
        BusResult result = new BusResult(RetCode.FAIL, "失败");
        redisUtil.set("20200523", "这是一条测试数据", redisConfig.getDatabase());
        Long resExpire = redisUtil.expire("20200523", 60, redisConfig.getDatabase());//设置key过期时间
        log.info("resExpire=" + resExpire);
        String res = redisUtil.get("20200523", redisConfig.getDatabase());
        if (null != res) {
            result = new BusResult(RetCode.SUCCESS, "成功！", res);
        }
        return result;
    }
}
