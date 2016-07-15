package com.aimprosoft.controller;


import com.aimprosoft.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by user on 05.07.16.
 */

@Controller("MainServlet")
public class ServletController implements HttpRequestHandler {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String beanName = httpServletRequest.getRequestURI();
        Handler handler = (Handler) applicationContext.getBean(beanName);
        handler.action(httpServletRequest, httpServletResponse);
    }
}
