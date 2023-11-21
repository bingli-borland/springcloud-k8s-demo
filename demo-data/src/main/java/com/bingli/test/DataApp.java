package com.bingli.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DataApp {

    public static void main(String[] args) {
        SpringApplication.run(DataApp.class, args);
    }

}
