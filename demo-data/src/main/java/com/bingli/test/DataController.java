package com.bingli.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

@RestController
public class DataController {
    @GetMapping("/data")
    public ResponseVO<HashMap> data(){
        HashMap<String, String> map = new HashMap<>();
        try {
            InetAddress address = InetAddress.getLocalHost();
            map.put("name",address.getHostName());
            map.put("address",address.getHostAddress());
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Host Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ResponseVOUtil.success(map);
    }
}
