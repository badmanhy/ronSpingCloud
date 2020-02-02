package com.ron.configserver.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config-base")
@Api(tags="ron-config-base")
public class baseController {
    @RequestMapping("/gitConfig/{userName}")
    public String gitConfig(@PathVariable String userName,String pwd) {
        return userName;
    }
    @RequestMapping("/tfsConfig/{url}")
    public String tfsConfig(@PathVariable String url){
        return url;
    }
}

