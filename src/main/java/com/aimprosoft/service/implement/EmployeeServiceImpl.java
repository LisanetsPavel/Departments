package com.aimprosoft.service.implement;

import com.aimprosoft.dao.DepartmentDao;
import com.aimprosoft.dao.EmployeeDao;
import com.aimprosoft.dao.implement.DepartmentDaoImpl;
import com.aimprosoft.dao.implement.EmployeeDaoImpl;
import com.aimprosoft.entity.Employee;
import com.aimprosoft.exception.ValidationException;
import com.aimprosoft.service.EmployeeService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by user on 05.07.16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private CustomValidator customValidator;

    public List<Employee> getEmployeeByDep(Integer depId) {
        return departmentDao.getById(depId).getEmployeeList();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeDao.getById(id);
    }

    public void addOrUpdateEmployee(Employee employee) throws ValidationException {
        customValidator.validate(employee);
        employeeDao.saveOrUpdate(employee);
    }

    public void deleteEmployee(Integer empId) {
        employeeDao.delete(empId);
    }

    public Employee buildEmployee(HttpServletRequest request) throws ServletException, IOException {
        Employee employee = new Employee();

        String emplIdStr = request.getParameter("emp_id");

        if (emplIdStr != null && emplIdStr != "") {
            employee.setId(Integer.parseInt(emplIdStr));
            employee.setDepartment(departmentDao.getById(Integer.parseInt(request.getParameter("selected_dep_id"))));

        } else {
            employee.setDepartment(departmentDao.getById(Integer.parseInt(request.getParameter("dep_id"))));
        }
        try {
            employee.setBirthday(formatter.parse(request.getParameter("birthday")));

        } catch (ParseException e) {
            employee.setBirthday(null);
        }
        try {
            employee.setSalary(Integer.parseInt(request.getParameter("salary")));
        } catch (NumberFormatException e) {
            employee.setSalary(null);
        }

        employee.setLastName(request.getParameter("lastName"));
        employee.setFirstName(request.getParameter("firstName"));
        employee.setEmail(request.getParameter("email"));
        return employee;
    }


}
