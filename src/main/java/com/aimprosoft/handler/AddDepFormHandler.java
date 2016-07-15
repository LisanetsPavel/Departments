package com.aimprosoft.handler;

import com.aimprosoft.entity.Department;
import com.aimprosoft.service.implement.DepartmentServiceImpl;
import com.aimprosoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 05.07.16.
 */

@Controller("/addDepForm.do")
public class AddDepFormHandler implements Handler {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!StringUtils.isEmpty("dep_id")) {
            Department department = departmentService.getDepartmentById(Integer.parseInt(request.getParameter("dep_id")));
            request.setAttribute("dep", department);
        }
        request.getRequestDispatcher("/WEB-INF/views/addDep.jsp").forward(request, response);
    }
}
