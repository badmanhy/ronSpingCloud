package com.ron.eurekaclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable String name) {
        return name+",Hello World!";
    }
}
