package com.example.servingwebcontent.commons.config;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(AppException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResultData appException(final AppException e) {
        log.error("App Exception: {}", e.getExceptionMessage());
        return e.getResultData();
    }

    @ExceptionHandler(Exception.class)
    public ResultData exception(final Exception e, final HttpServletResponse response) {
        log.error("Exception: " + e.getMessage(), e);
        response.setStatus(200);
        return new ResultData(ResultCode.ETC_ERROR);
    }
}
