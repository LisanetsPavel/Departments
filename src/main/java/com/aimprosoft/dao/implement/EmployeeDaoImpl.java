package com.aimprosoft.dao.implement;

import com.aimprosoft.dao.EmployeeDao;
import com.aimprosoft.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created on 11.07.16.
 */
@Repository
public class EmployeeDaoImpl extends GenericDao implements EmployeeDao {

    @Transactional
    public void saveOrUpdate(Employee employee){
        super.saveOrUpdate(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll(){
        return super.getAll(Employee.class);
    }
    @Transactional(readOnly = true)
    public Employee getById(Integer id){
        return (Employee) super.getById(Employee.class, id);
    }
    @Transactional
    public void delete(Integer id){
        super.delete(id, Employee.class);
    }

}
