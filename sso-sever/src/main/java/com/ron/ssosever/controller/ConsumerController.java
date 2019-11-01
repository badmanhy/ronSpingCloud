package com.ron.ssosever.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @RequestMapping("/hi")
    public String index(@PathVariable String name) {
        return name+",hi!";
    }
}
