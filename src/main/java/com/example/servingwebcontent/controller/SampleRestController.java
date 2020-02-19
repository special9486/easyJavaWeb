package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK11
 */
@RequestMapping("/api/example")
@RestController()
@Slf4j
@Api(tags = {"예제용 API 목록"})
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

    @GetMapping("/get/withParameter")
    @ApiOperation(value = "sampleGetWithParameter", notes = "파라미터가 포함된 Get API")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "테스트 이름")
    })
    public ResultData sampleGetWithParameter(final String name) {
        log.info("in sampleGetWithParameter: name({})", name);
        return new ResultData("name is " + name);
    }

    @PostMapping("/post/parameters")
    @ApiOperation(value = "samplePostWithParam", notes = "Post API With Parameters.")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "이름", dataType = "string"),
        @ApiImplicitParam(name = "age", value = "나이", dataType = "integer")
    })
    public ResultData samplePostWithParam(final String name, final Integer age) {
        log.info("in samplePostWithParam: name({}), age({})", name, age);
        return new ResultData("name is " + name + ", age is " + age);
    }

    @PostMapping("/post/body")
    @ApiOperation(value = "samplePostWithBody", notes = "Post API With Body.")
    public ResultData samplePostWithBody(@RequestBody final String body) {
        log.info("in samplePostWithBody => {}}", body);
        return new ResultData("body is " + body);
    }

    @PostMapping("/post/header")
    @ApiOperation(value = "samplePostWitHeader", notes = "Post API With Header.")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "apiToken", value = "인증 토큰", dataType = "string", paramType = "header")
    })
    public ResultData samplePostWitHeader() {
        log.info("in samplePostWitHeader...");
        return new ResultData("use header api...");
    }
}
