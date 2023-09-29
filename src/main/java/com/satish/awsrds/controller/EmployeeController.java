package com.satish.awsrds.controller;


import com.satish.awsrds.service.EmployeeService;
import com.satish.awsrds.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @author - Satish R
 */

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}
