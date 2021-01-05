package com.example.demo.util;

/**
 * 业务异常类
 *
 * @author liaoc
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    private UtilLog log = UtilLog.getInstance(this.getClass());

    /**
     * 错误码
     */
    private int retCode;
    /**
     * 错误信息
     */
    private String retMsg;

    /**
     * 构造
     */
    public ServiceException(int retCode, String retMsg) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public ServiceException(Exception ex) {
        super(ex);
    }

    public ServiceException(int retCode, String retMsg, Exception ex) {
        super(ex);
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    /**
     * 重写
     */
    public void printStackTrace() {
        log.info("异常信息：" + this.retMsg);
        super.printStackTrace();
    }

    public int getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }
}
