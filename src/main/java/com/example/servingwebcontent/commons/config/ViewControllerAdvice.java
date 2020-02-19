package com.example.servingwebcontent.commons.config;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
@Order(2)
@ControllerAdvice
@Slf4j
public class ViewControllerAdvice {

    @ExceptionHandler(AppException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public String appException(final AppException e, final Model model) {
        log.error("App Exception: {}", e.getExceptionMessage(), e);
        model.addAttribute("code", e.getResultData().getCode());
        model.addAttribute("message", e.getResultData().getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String exception(final Exception e, final Model model) {
        log.error("Exception: " + e.getMessage(), e);
        model.addAttribute("code", ResultCode.ETC_ERROR.getCode());
        model.addAttribute("message", ResultCode.ETC_ERROR.getDpMsg());
        return "error";
    }
}
