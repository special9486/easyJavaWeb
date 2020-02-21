package com.example.servingwebcontent.service;

import com.example.servingwebcontent.commons.ResultData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleServiceTests {

    private final SampleService sampleService;

    @Autowired
    public SampleServiceTests(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Test
    public void testAddData() {
        final ResultData resultData = sampleService.addData("dd", "ee");
        System.out.println("result data => " + resultData.toString());
    }

    @Test
    public void testUpdateData() throws Exception {
        final ResultData resultData = sampleService.updateData(3L, "ssdfsd");
        System.out.println("result data => " + resultData.toString());
    }

    @Test
    public void testAddSampleDetail() throws Exception {
        final ResultData resultData = sampleService.addSampleDetail(3L, "11", 11);
        System.out.println("result data => " + resultData.toString());
    }
}
