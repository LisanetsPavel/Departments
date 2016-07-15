package com.aimprosoft.util;


import com.aimprosoft.dao.DepartmentDao;
import com.aimprosoft.dao.EmployeeDao;
import com.aimprosoft.dao.implement.DepartmentDaoImpl;
import com.aimprosoft.dao.implement.EmployeeDaoImpl;
import com.aimprosoft.entity.Department;
import com.aimprosoft.entity.Employee;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 08.07.16.
 */

@Component
public class UniqueCheck implements CheckWithCheck.SimpleCheck {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean isSatisfied(Object o, Object o1) {

        if (o instanceof Department) {
            Department department = (Department) o;
            for (Department dep : departmentDao.getAll()) {
                if (department.getName().equalsIgnoreCase(dep.getName())) {
                    if (department.getId() != null && department.equals(dep)) {
                         return true;
                    }
                    return false;
                }
            }
        } else if (o instanceof Employee) {
            Employee employee = (Employee) o;
            for (Employee emp : employeeDao.getAll()) {
                if (employee.getEmail().equalsIgnoreCase(emp.getEmail())) {
                    if (employee.getId() != null && employee.equals(emp)) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}