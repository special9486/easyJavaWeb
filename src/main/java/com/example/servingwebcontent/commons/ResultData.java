package com.example.servingwebcontent.commons;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
public class ResultData {

    private String code;

    private String message;

    private Object data;

    public ResultData() {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getDpMsg();
    }

    public ResultData(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
    }

    public ResultData(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
        this.data = data;
    }

    public ResultData(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getDpMsg();
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
