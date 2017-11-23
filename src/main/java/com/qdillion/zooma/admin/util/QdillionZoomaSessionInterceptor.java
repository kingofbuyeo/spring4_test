package com.qdillion.zooma.admin.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 20.
 */

@Slf4j
public class QdillionZoomaSessionInterceptor implements HandlerInterceptor{
    private List<String> unCheckedUrl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session         = request.getSession();
        log.debug("Request URL : " + request.getRequestURL());
        log.debug("Context Path : " + request.getRequestURI());
        log.debug("Is Find : " + unCheckedUrl.stream().filter(i->Pattern.compile(i).matcher(request.getRequestURI()).find()).count());
        if(unCheckedUrl.stream().filter(i->Pattern.compile(i).matcher(request.getRequestURI()).find()).count() < 1){
            log.debug("Is Passed url");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void setUnCheckedUrl(String url){
        if(unCheckedUrl == null || unCheckedUrl.size() < 1){
            unCheckedUrl        = new ArrayList<>();
        }
        unCheckedUrl.add(url);
    }


}
