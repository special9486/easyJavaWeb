package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.commons.AppException;
import com.example.servingwebcontent.commons.ResultCode;
import com.example.servingwebcontent.commons.ResultData;
import com.example.servingwebcontent.service.SampleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final SampleService sampleService;

    public SampleRestController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

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
    public ResultData samplePostWitHeader() {
        log.info("in samplePostWitHeader...");
        return new ResultData("use header api...");
    }

    @GetMapping("/get/getDbData")
    @ApiOperation(value = "getDbData", notes = "Get Database sample data")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userNo", value = "사용자 번호", dataType = "number", paramType = "query")
    })
    public ResultData getDbData(final Long userNo) throws Exception {
        log.info("getDbData params => userNo[{}]", userNo);
        return sampleService.getData(userNo);
    }

    @GetMapping("/get/waitingOneSecond")
    @ApiOperation(value = "waitingOneSecond", notes = "Waiting one second for stress test")
    public ResultData waitingOneSecond() throws Exception {
        log.info("in waitingOneSecond...");
        Thread.sleep(1000);
        return new ResultData(ResultCode.SUCCESS);
    }

    @GetMapping("/get/waitingTwoSecond")
    @ApiOperation(value = "waitingTwoSecond", notes = "Waiting two second for stress test")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "count", value = "호출 번호", dataType = "integer", paramType = "query")
    })
    public ResultData waitingTwoSecond(final Integer count) throws Exception {
        log.info("in waitingTwoSecond: count[{}]", count);
        Thread.sleep(2000);
        return new ResultData(ResultCode.SUCCESS, count);
    }
}
