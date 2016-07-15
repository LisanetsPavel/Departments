package com.aimprosoft.handler;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by user on 05.07.16.
 */
@Controller
public interface Handler {

    void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
