package com.example.servingwebcontent.commons;

import lombok.Data;
import org.slf4j.MDC;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
@Data
public class ResultData {

    private String code;

    private String message;

    private String logKey;

    private Object data;

    public ResultData() {
        this.logKey = MDC.get("logKey");
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getDpMsg();
    }

    public ResultData(ResultCode resultCode) {
        this.logKey = MDC.get("logKey");
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
    }

    public ResultData(ResultCode resultCode, Object data) {
        this.logKey = MDC.get("logKey");
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
        this.data = data;
    }

    public ResultData(Object data) {
        this.logKey = MDC.get("logKey");
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getDpMsg();
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.logKey = MDC.get("logKey");
        this.code = resultCode.getCode();
        this.message = resultCode.getDpMsg();
    }
}
