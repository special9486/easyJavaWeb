package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.ResultData;
import com.example.servingwebcontent.commons.utils.EasyMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK11
 */
@RequestMapping("/sample")
@Controller
@Slf4j
public class SampleController {

    @GetMapping("/get")
    @ResponseBody
    public ResultData sampleGet() {
        log.info("in sampleGet...");
        final EasyMap easyMap = EasyMap.createInstance();
        easyMap.put("sample", "2234234");

        return new ResultData(easyMap.toMap());
    }

    @GetMapping("/get/exception")
    @ResponseBody
    public ResultData sampleGetException() throws Exception {
        log.info("in sapleGetException...");
        throw new Exception("test");
    }
}
