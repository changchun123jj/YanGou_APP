package com.example.demo.entity.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;


/**
 * 实体基类
 *
 * @author liaoc
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回对象JSON信息
     */
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
