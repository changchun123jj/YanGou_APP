package com.example.demo.entity.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;


/**
 * 接口返回对象
 *
 * @author liaoc
 */
public class BusResult implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回码
     */
    private int retCode;
    /**
     * 返回信息
     */
    private String retMsg;
    /**
     * 返回数据
     */
    private Object retData;

    public BusResult() {
        super();
    }

    public BusResult(int retCode) {
        super();
        this.retCode = retCode;
    }

    public BusResult(int retCode, String retMsg) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public BusResult(int retCode, String retMsg, Object retData) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }

    /**
     * @return the 返回码
     */
    public int getRetCode() {
        return retCode;
    }

    /**
     * @param 返回码 the retCode to set
     */
    public BusResult setRetCode(int retCode) {
        this.retCode = retCode;
        return this;
    }

    /**
     * @return the 返回信息
     */
    public String getRetMsg() {
        return retMsg;
    }

    /**
     * @param 返回信息 the retMsg to set
     */
    public BusResult setRetMsg(String retMsg) {
        this.retMsg = retMsg;
        return this;
    }

    /**
     * @return the 返回数据
     */
    public Object getRetData() {
        return retData;
    }

    /**
     * @param 返回数据 the retData to set
     */
    public BusResult setRetData(Object retData) {
        this.retData = retData;
        return this;
    }

    /**
     * 数据字符串化
     *
     * @return
     */
    public String getRetDataStr() {
        String result = null;
        if (null == retData) {
            result = null;
        } else {
            String dataClassType = this.retData.getClass().getName();
            if (dataClassType.toLowerCase().indexOf("string") >= 0) {
                // - 字符串
                result = (String) retData;
            } else {
                result = JSONObject.toJSONString(this.retData);
            }
        }
        return result;
    }
}
