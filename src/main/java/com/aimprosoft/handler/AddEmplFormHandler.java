package com.aimprosoft.handler;

import com.aimprosoft.entity.Employee;
import com.aimprosoft.service.implement.EmployeeServiceImpl;
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
@Controller("/addEmplForm.do")
public class AddEmplFormHandler implements Handler {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("emp_id");
        if (!StringUtils.isEmpty(empId)) {
            Employee employee = employeeServiceImpl.getEmployeeById(Integer.parseInt(empId));
            request.setAttribute("emp", employee);
        }
        request.setAttribute("dep_id", request.getParameter("dep_id"));
        request.setAttribute("emp_id", empId);
        request.getRequestDispatcher("/WEB-INF/views/addEmpl.jsp").forward(request, response);
    }
}
