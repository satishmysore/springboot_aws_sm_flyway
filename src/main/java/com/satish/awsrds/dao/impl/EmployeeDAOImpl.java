package com.satish.awsrds.dao.impl;

import com.satish.awsrds.dao.EmployeeDao;
import com.satish.awsrds.dao.model.EmployeeEntity;
import com.satish.awsrds.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @author - Satish R
 */

@Component
public class EmployeeDAOImpl implements EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
