package com.example.servingwebcontent.commons;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
public class AppException extends Exception {

    private ResultData resultData;

    private String exceptionMessage;

    public AppException() {
        this.resultData = new ResultData(ResultCode.ETC_ERROR);
        this.exceptionMessage = ResultCode.ETC_ERROR.getLogMsg();
    }

    public AppException(ResultCode resultCode) {
        this.resultData = new ResultData(resultCode);
        this.exceptionMessage = resultCode.getLogMsg();
    }

    public AppException(ResultCode resultCode, Object data) {
        this.resultData = new ResultData(resultCode, data);
        this.exceptionMessage = resultCode.getLogMsg();
    }

    public ResultData getResultData() {
        return resultData;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
