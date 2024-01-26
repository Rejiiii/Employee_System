package com.backend.embackend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.backend.embackend.model.Employee;
import com.backend.embackend.model.EmployeeInput;

@Mapper
public interface EmployeeDao {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long emp_id);

    void addEmployee(EmployeeInput employee);

    void editEmployee(Employee body);

    void deleteEmployee(Long emp_id);

    void logicalDelete(Long emp_id);
}
