package com.backend.embackend.service;

import java.util.List;
import java.util.Map;

import com.backend.embackend.model.Employee;
import com.backend.embackend.model.EmployeeInput;

public interface EmployeeService {

    public List<Employee> getAllEmployee();  

    Employee getEmployeeById(Long emp_id);
    
    String addEmployee(EmployeeInput employee);

    public Map<String, Object> editEmployee(Long emp_id, Employee body);

    String deleteEmployee(Long emp_id);

    String logicalDelete(Long emp_id);

}
