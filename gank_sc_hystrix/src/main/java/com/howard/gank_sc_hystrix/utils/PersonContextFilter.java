package com.howard.gank_sc_hystrix.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class PersonContextFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(PersonContextFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        PersonContextHolder.getContext().setUserId(httpServletRequest.getHeader("Host"));
        filterChain.doFilter(httpServletRequest,servletResponse);
    }
}
