package com.aimprosoft.dao;

import com.aimprosoft.entity.Department;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 04.07.16.
 */
@Repository

public interface DepartmentDao {

    List<Department> getAll();
    void saveOrUpdate(Department department) ;
    void delete (Integer id );
    Department getById(Integer id );

}
