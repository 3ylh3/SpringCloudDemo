package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 限流filter
 *
 * @author yin_zhj
 * @date 2020/6/11
 */
@Component
@EnableScheduling
public class Filter extends ZuulFilter {

    private static final String FILTER_TYPE = "pre";
    @Value("${max-token-nums}")
    private int MAX_TOKEN_NUMS;
    private int tokenNums = MAX_TOKEN_NUMS;

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        synchronized (this) {
            if(tokenNums <= 0) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseBody("limit");
            } else {
                tokenNums--;
                ctx.setSendZuulResponse(true);
            }
        }
        return null;
    }

    @Scheduled(fixedRate = 1000)
    public synchronized void createToken() {
        if(tokenNums < MAX_TOKEN_NUMS) {
            tokenNums++;
        }
    }
}
