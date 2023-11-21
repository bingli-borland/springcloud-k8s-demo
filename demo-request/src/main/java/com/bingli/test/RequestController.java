package com.bingli.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RequestController {
    @Resource
    private DataServer dataServer;

    @GetMapping("request")
    public ResponseVO data(){

        return dataServer.data();
    }
}
