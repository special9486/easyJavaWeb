package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK11
 */
@RequestMapping("/sample/api")
@RestController()
@Slf4j
public class SampleRestController {

    @GetMapping("/get")
    public ResultData sampleGet() {
        log.info("in sampleGet...");
        return new ResultData("test data");
    }

    @GetMapping("/get/exception")
    public String sampleGetException() throws Exception {
        log.info("in sampleGetException...");
        throw new Exception("test");
    }

    @GetMapping("/get/appException")
    public String sampleGetAppException() throws Exception {
        log.info("in sampleGetAppException...");
        throw new AppException(ResultCode.ETC_ERROR);
    }
}
