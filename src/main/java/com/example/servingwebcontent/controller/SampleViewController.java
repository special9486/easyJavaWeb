package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.utils.EasyMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/pageWithVue")
    public String pageWithVue(final Model model) throws Exception {
        log.info("in pageWithVue...");
        final Map<String, Object> sampleData = Maps.newHashMap();
        final List<Map<String, Object>> sampleList = Lists.newArrayList();
        sampleData.put("sampleList", sampleList);

        // sample data 1
        Map<String, Object> data = Maps.newHashMap();
        data.put("name", "choi");
        data.put("age", 10);
        sampleList.add(data);

        // sample data 2
        data = Maps.newHashMap();
        data.put("name", "sung");
        data.put("age", 20);
        sampleList.add(data);

        // sample data 3
        data = Maps.newHashMap();
        data.put("name", "hun");
        data.put("age", 30);
        sampleList.add(data);

        // set model
        model.addAllAttributes(sampleData);

        return "sample/pageWithVue";
    }
}
