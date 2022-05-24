package com.liujie.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();


        if ("/login".equals(path) || "/login.jsp".equals(path)) {
            return true;
        }else {
            if (request.getSession().getAttribute("user") != null) {
                return true;
            } else {
                response.sendRedirect("jsp/login.jsp");
            }
        }
//        System.out.println("intercetor is runing");

//        if (request.getSession().getAttribute("user") != null) {
//                return true;
//            } else {
//                response.sendRedirect("/login.jsp");
//            }

        return false ;
    }
}
