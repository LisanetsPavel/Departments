package com.aimprosoft.service.implement;

import com.aimprosoft.dao.DepartmentDao;
import com.aimprosoft.entity.Department;
import com.aimprosoft.exception.ValidationException;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 05.07.16.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private CustomValidator customValidator;

    public List<Department> getAllDepartments() {
        return departmentDao.getAll();
    }

    public void deleteDepartment(int depId) {
        departmentDao.delete(depId);
    }

    public void addOrUpdateDepartment(Department department) throws ValidationException {
        customValidator.validate(department);
        departmentDao.saveOrUpdate(department);
    }

  public Department getDepartmentById(int id) {
        return departmentDao.getById(id);
    }

}
