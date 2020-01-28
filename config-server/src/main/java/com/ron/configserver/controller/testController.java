package com.ron.configserver.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Api(tags="ron-api")
public class testController {
    @RequestMapping("/hi/{name}")
    public String index(@PathVariable String name) {
        return name+",hi!";
    }
}