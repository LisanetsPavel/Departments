package com.aimprosoft.handler;

import com.aimprosoft.entity.Department;
import com.aimprosoft.exception.ValidationException;
import com.aimprosoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by user on 05.07.16.
 */
@Controller("/addDep.do")
public class AddDepHandler implements Handler {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();

        if (!StringUtils.isEmpty("dep_id")) {
            department.setId(Integer.parseInt(request.getParameter("dep_id")));
        }
        department.setName(request.getParameter("name"));
        try {
            departmentService.addOrUpdateDepartment(department);
            response.sendRedirect("/");
        } catch (ValidationException e) {
            request.setAttribute("errors", e.getErrorMap());
            request.getRequestDispatcher("/WEB-INF/views/addDep.jsp").forward(request, response);
        }
    }
}
