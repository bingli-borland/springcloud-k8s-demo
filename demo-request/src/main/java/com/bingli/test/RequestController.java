package com.bingli.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class RequestController {
    @Resource
    private DataServer dataServer;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("request")
    public ResponseVO data(@RequestParam("dataAddress") String address){
        if (address == null) {
            address = "demo-data-bes.myes";
        }
        return restTemplate.getForObject("http://" + address + ":12001/data", ResponseVO.class);
    }
}
