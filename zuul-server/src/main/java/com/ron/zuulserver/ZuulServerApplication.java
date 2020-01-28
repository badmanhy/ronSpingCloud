package com.ron.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@Configuration
@EnableDiscoveryClient
//@EnableOAuth2Sso
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
        System.out.println("zuul 服务启动...");
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}
