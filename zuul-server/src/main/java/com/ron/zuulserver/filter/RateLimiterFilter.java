package com.ron.zuulserver.filter;

import com.ron.zuulserver.exceptions.RateLimiterException;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    //create 每秒放入100个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    /**
     * filter类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * filter执行顺序，值越小优先级越高
     * 官方推荐使用x-1方式优先排序
     * 选择最高优先级SERVLET_DETECTION_FILTER_ORDER，并-1
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    /**
     * filter 开启关闭
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 实现filter逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //判断--获取通行令牌-->如果没有令牌不等于之前的没有权限401，可以抛出自定义异常或者其他处理
        if (!RATE_LIMITER.tryAcquire()) {
            throw new RateLimiterException();
        }

        return null;
    }
}

