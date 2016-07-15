package com.aimprosoft.handler;

import com.aimprosoft.entity.Employee;
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
@Controller("/showEmpls.do")
public class ShowEmplsHandler implements Handler {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("dep_id");
        List<Employee> employeeList = employeeService.getEmployeeByDep(Integer.parseInt(departmentId));
        request.setAttribute("dep_id", departmentId);
        request.setAttribute("empls", employeeList);
        request.getRequestDispatcher("/WEB-INF/views/showEmpls.jsp").forward(request, response);
    }
}
