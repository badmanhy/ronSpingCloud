package com.ron.ssosever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableOAuth2Sso
@SpringBootApplication
@EnableDiscoveryClient
public class SsoSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoSeverApplication.class, args);
        System.out.println("zuul 第一个服务启动...");
    }

}
