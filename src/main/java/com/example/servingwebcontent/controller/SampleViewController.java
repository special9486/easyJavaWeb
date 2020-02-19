package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK11
 */
@RequestMapping("/view/sample")
@Controller
@Slf4j
public class SampleViewController {

    @GetMapping("/main")
    public String sampleMainPage() {
        log.info("in sampleMainPage...");
        return "main";
    }

    @GetMapping("/error/exception")
    public String sampleExceptionErrorPage() throws Exception {
        log.info("in sampleExceptionErrorPage...");
        throw new Exception("test");
    }

    @GetMapping("/error/appException")
    public String sampleAppExceptionErrorPage() throws Exception {
        log.info("in sampleAppExceptionErrorPage...");
        throw new AppException(ResultCode.ETC_ERROR);
    }
}
