package com.backend.empbackend.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.empbackend.dao.EmployeeDao;
import com.backend.empbackend.model.Employee;
import com.backend.empbackend.model.EmployeeInput;
import com.backend.empbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    public EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long emp_id)
    {
        return employeeDao.getEmployeeById(emp_id);
    }
        
    @Override
    public String addEmployee(EmployeeInput employee){
        try {
            employeeDao.addEmployee(employee);
            return "Employee has been added successfully.";
        } catch (Exception e) {
            return "Error occurred while adding the employee.";
        }
    }

    @Override
    public Map<String, Object> editEmployee(Long emp_id, Employee body) {
        Map<String, Object> response = new HashMap<String, Object>();

        if(body.getUsername() != null && body.getPass() != null && body.getRole() != null)
        {
            body.setEmp_id(emp_id);
            employeeDao.editEmployee(body);
        }
        else {
            response.put("message", "Invalid inputs and Empty body");
            return response;
        }
        
        response.put("message", body);
        return response;
    }

    @Override
    public String deleteEmployee(Long emp_id) 
    {
        Employee userFromDb = employeeDao.getEmployeeById(emp_id);
        employeeDao.deleteEmployee(emp_id);
        return userFromDb.getUsername() + "is successfullly deleted" ;
    }

    @Override
    public String logicalDelete(Long emp_id) {
        try {
            employeeDao.logicalDelete(emp_id);
            return "Employee with ID " + emp_id + " has been logically deleted.";
        } catch (Exception e) {
            // Log the exception or handle it in a way appropriate for your application
            e.printStackTrace();
            return "Error occurred during logical delete.";
        }
    }

}
