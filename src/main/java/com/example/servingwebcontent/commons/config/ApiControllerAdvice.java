package com.example.servingwebcontent.commons.config;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
@Order(1)
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler(AppException.class)
    public ResultData appException(final AppException e) {
        log.error("App Exception: {}", e.getExceptionMessage(), e);
        return e.getResultData();
    }

    @ExceptionHandler(Exception.class)
    public ResultData exception(final Exception e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResultData(ResultCode.ETC_ERROR);
    }
}
