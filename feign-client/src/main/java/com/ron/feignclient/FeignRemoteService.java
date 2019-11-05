package com.ron.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface FeignRemoteService {

    @RequestMapping(value = "/hello/{name}")
    public String hello(@RequestParam(value = "name") String name);

}