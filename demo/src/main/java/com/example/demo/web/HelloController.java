package com.example.demo.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/index")
    public String index() {
        ServiceInstance instance = discoveryClient.getInstances("demo-service").get(0);

        logger.info("/hello, host: " + instance.getHost() + ", service_id:" + instance.getServiceId());

        return "Hello world";
    }


}
