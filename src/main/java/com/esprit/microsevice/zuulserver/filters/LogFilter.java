package com.esprit.microsevice.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class LogFilter extends ZuulFilter {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.info("Request Method : " + ctx.getRequest().getMethod() + " Request URL : " + ctx.getRequest().getRequestURL().toString());
        return null;
    }

}
