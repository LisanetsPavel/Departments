package com.aimprosoft.handler;


import com.aimprosoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by user on 05.07.16.
 */
@Controller("/deleteDep.do")
public class DeleteDepHandler implements Handler {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("dep_id");
        departmentService.deleteDepartment(Integer.parseInt(departmentId));
        response.sendRedirect("/");
    }
}
