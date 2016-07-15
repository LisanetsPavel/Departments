package com.aimprosoft.dao;

import com.aimprosoft.entity.Employee;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 04.07.16.
 */
@Repository
public interface EmployeeDao {

    List<Employee> getAll();
    Employee getById(Integer id );
    void delete (Integer id);
    void saveOrUpdate (Employee employee);
}
