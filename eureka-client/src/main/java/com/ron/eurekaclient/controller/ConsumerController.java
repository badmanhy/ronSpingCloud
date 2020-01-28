package com.ron.eurekaclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
@Api(tags="ron-api",description = "测试源服务API接口")
public class ConsumerController {

    @RequestMapping("/hi/{name}")
    public String index(@PathVariable String name) {
        return name+",hi!";
    }
    @ApiOperation(value = "加法", notes = "加法")
    @GetMapping("/add")
    public Integer add(Integer a, Integer b){
        return a + b;
    }
    @ApiOperation(value = "减法", notes = "减法")
    @GetMapping("/sub")
    public Integer sub(Integer a, Integer b){
        return a - b;
    }
}
