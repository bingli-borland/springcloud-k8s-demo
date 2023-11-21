package com.bingli.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

//@FeignClient(name = "demo-data", url = "http://localhost:12001")
@FeignClient(name = "demo-data", url = "http://demo-data.myes:12001")
public interface DataServer {
    @GetMapping("data")
    public ResponseVO<HashMap> data();
}
