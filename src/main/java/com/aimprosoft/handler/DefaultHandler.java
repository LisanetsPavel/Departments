package com.aimprosoft.handler;

import com.aimprosoft.entity.Department;
import com.aimprosoft.service.implement.DepartmentServiceImpl;
import com.aimprosoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 05.07.16.
 */
@Controller("/")
public class DefaultHandler implements Handler {

    @Autowired
    private DepartmentService departmentService ;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departmentList = departmentService.getAllDepartments();
        request.getSession().setAttribute("allDeps", departmentList);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
