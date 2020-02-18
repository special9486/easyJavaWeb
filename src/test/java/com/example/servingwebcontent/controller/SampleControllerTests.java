package com.example.servingwebcontent.controller;

import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
public class SampleControllerTests {
    private Logger log = LoggerFactory.getLogger("Test");

    @Test
    public void testSampleGet() throws Exception {
        final Request request = Request.Get("http://localhost:8080/sample/get");
        final String result = request.execute().returnContent().asString();
        System.out.println("result => " + result);
    }

    @Test
    public void testSampleGetException() throws Exception {
        final Request request = Request.Get("http://localhost:8080/sample/get/exception");
        final String result = request.execute().returnContent().asString();
        System.out.println("result => " + result);
    }
}
