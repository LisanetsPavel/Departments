package com.aimprosoft.handler;

import com.aimprosoft.entity.Employee;
import com.aimprosoft.exception.ValidationException;
import com.aimprosoft.service.implement.EmployeeServiceImpl;
import com.aimprosoft.service.EmployeeService;
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
@Controller("/addEmpl.do")
public class AddEmplHandler implements Handler {
    @Autowired
    private EmployeeService employeeServiceImpl;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = employeeServiceImpl.buildEmployee(request);
        try {
            employeeServiceImpl.addOrUpdateEmployee(employee);
            response.sendRedirect("/showEmpls.do?dep_id=" + request.getParameter("dep_id"));
        } catch (ValidationException e) {
            request.setAttribute("errors", e.getErrorMap());
            request.getRequestDispatcher("/addEmplForm.do").forward(request, response);
        }
    }
}


