package com.czxy.score.interceptor;

import com.czxy.score.domain.Log;
import com.czxy.score.domain.User;
import com.czxy.score.service.LogService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Resource
    private LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String requestURI = request.getRequestURI();
        if(requestURI.contains("index") || requestURI.contains("login") || requestURI.contains("js") || requestURI.contains("css") || requestURI.startsWith("/fonts/") || requestURI.startsWith("/images/")){
            return true;
        }
        User login = (User) request.getSession().getAttribute("login");
        if(login==null){
            response.sendRedirect("/index.html");
            return false;
        }else {
            Date date = new Date();
            Log log = new Log();
            log.setUid(login.getId());
            log.setUsername(login.getUsername());
            log.setTime(date);
            if(requestURI.contains("add")){
                log.setOperat("add");
            }

            if (requestURI.contains("update")){
                log.setOperat("update");
            }

            if (requestURI.contains("del")){
                log.setOperat("del");
            }

            logService.add(log);
            return true;
        }
    }
}
