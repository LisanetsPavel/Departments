package com.aimprosoft.dao.implement;


import com.aimprosoft.dao.DepartmentDao;
import com.aimprosoft.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 11.07.16.
 */
@Repository
public class DepartmentDaoImpl extends GenericDao implements DepartmentDao {

    @Transactional
    public void saveOrUpdate(Department department){
        super.saveOrUpdate(department);
    }
    @Transactional(readOnly = true)
    public List<Department> getAll(){
        return super.getAll(Department.class);
    }
    @Transactional(readOnly = true)
    public Department getById(Integer id){
        return (Department) super.getById(Department.class, id);
    }
    @Transactional
    public void delete(Integer id){
        super.delete(id, Department.class);
    }

}
