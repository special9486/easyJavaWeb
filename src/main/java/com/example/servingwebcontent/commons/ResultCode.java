package com.example.servingwebcontent.commons;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
public enum ResultCode {

    SUCCESS("0", "Success", "Success"),

    ETC_ERROR("E01", "ETC Error", "일시적인 서비스 장애가 발생하였습니다."),

    NOT_FOUND("S01", "Data not found...", "데이터가 없습니다.");

    private String code;

    private String logMsg;

    private String dpMsg;

    ResultCode(String code, String logMsg, String dpMsg) {
        this.code = code;
        this.logMsg = logMsg;
        this.dpMsg = dpMsg;
    }

    public String getCode() {
        return code;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public String getDpMsg() {
        return dpMsg;
    }
}
