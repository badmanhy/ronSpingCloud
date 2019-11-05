package com.ron.feignclient.controller;

import com.ron.feignclient.FeignRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignRemoteService feignRemoteService;

    @GetMapping(value = "/getHello")
    public String getHello(@RequestParam String name) {
        return feignRemoteService.hello(name);
    }

}