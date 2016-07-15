package com.aimprosoft.service;

import com.aimprosoft.entity.Department;
import com.aimprosoft.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 08.07.16.
 */
@Service
public interface DepartmentService {

    List<Department> getAllDepartments();
    void deleteDepartment(int depId);
    void addOrUpdateDepartment(Department department) throws ValidationException;
    Department getDepartmentById(int id);

}
