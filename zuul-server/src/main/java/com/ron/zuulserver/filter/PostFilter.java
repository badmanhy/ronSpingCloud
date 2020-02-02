package com.ron.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * 常量类
 * 过滤器状态 FilterConstants
 * 请求状态 HttpStatus
 * 引用其中的属性值即可，无需自己写
 */
@Component
public class PostFilter extends ZuulFilter {
    /**
     * filter类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    /**
     * filter执行顺序，值越小优先级越高
     * 官方推荐使用x-1方式优先排序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("POST-UUID", UUID.randomUUID().toString());
        return null;
    }
}