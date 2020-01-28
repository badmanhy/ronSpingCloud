package com.ron.ssoserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("test")
@RestController
@Api(tags="ron-api",description = "测试源服务API接口")
public class ConsumerController {

    @ApiOperation(value = "乘法", notes = "乘法")
    @GetMapping("/mul")
    public Integer mul(Integer a, Integer b){
        return a * b;
    }
    @ApiOperation(value = "除法", notes = "除法")
    @GetMapping("/div")
    public Integer div(Integer a, Integer b){
        return a / b;
    }
    /**
     * 登录业务
     * @param loginCode
     * @param password
     * @return
     */
    @ApiOperation(value="demo示例",notes="demo示例")
    @ApiImplicitParam(name="name",value="名称",example="ron")
    @PostMapping("/login")
    public String login(String loginCode,
                        String password,
                        @RequestParam(required = false) String url,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes) {

        //登录成功
        if (loginCode != null) {

            String token = "";
            //将token放入缓存
            //String result = redisService.put(token, loginCode, 60 * 60 * 24);
            //如果redisService没有熔断，也就是返回ok,才能执行
            //if (result != null && result.equals("ok")) {
            // CookieUtil.setCookie(response, "token", token, 60 * 60 * 24);
            //if (url != null && !url.trim().equals(""))
            //return "redirect:" + url;
            //redirectAttributes.addFlashAttribute("message", "服务器异常1");
            //}
            //熔断后返回错误提示
            //else {
            redirectAttributes.addFlashAttribute("message", "服务器异常1");
            //}

        }
        //登录失败
        else {
            redirectAttributes.addFlashAttribute("message", "用户名密码错误");
        }
        return "redirect:/login";
    }
}
