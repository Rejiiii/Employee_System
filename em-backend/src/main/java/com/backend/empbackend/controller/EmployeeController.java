package com.backend.empbackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.backend.empbackend.model.Employee;
import com.backend.empbackend.model.EmployeeInput;
import com.backend.empbackend.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    // Select all data in database
    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    // Selected data in database
    @GetMapping("/{emp_id}")
    public Employee getEmployee(@PathVariable Long emp_id) {
        return employeeService.getEmployeeById(emp_id);
    }

    // Add data in database
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeInput employee) {
    String result = employeeService.addEmployee(employee);

    return ResponseEntity.ok(result);
    }

    // Edit data in database
    @PutMapping("/edit/{emp_id}")
    public Map<String, Object> editEmployee(@PathVariable Long emp_id, @RequestBody Employee body) {
        return employeeService.editEmployee(emp_id, body);
    }

    // Delete data in Database
    @DeleteMapping("/delete/{emp_id}")
    public String deleteEmployee(@PathVariable Long emp_id){
        return employeeService.deleteEmployee(emp_id);
    }

    // Logical Delete of data in database
    @PutMapping("logicalDelete/{emp_id}")
    public String logicalDelete(@PathVariable Long emp_id) {
        String result = employeeService.logicalDelete(emp_id);
        return result;
    }

}
