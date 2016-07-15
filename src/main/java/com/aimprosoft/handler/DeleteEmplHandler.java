package com.aimprosoft.handler;

import com.aimprosoft.service.EmployeeService;
import com.aimprosoft.service.implement.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 06.07.16.
 */
@Controller("/deleteEmpl.do")
public class DeleteEmplHandler implements Handler {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer emplId = Integer.parseInt(request.getParameter("emp_id"));
        Integer departmentId = employeeServiceImpl.getEmployeeById(emplId).getDepartment().getId();
        employeeServiceImpl.deleteEmployee(emplId);
        response.sendRedirect("/showEmpls.do?dep_id=" + departmentId);
    }
}
