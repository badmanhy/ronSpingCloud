package com.ron.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FeignController {
    @Value("${configword}")
    String configword;

    @GetMapping(value = "/testconfig")
    public String testconfig(@RequestParam String name) {
        return name + ",git配置值：" + configword;
    }
}
