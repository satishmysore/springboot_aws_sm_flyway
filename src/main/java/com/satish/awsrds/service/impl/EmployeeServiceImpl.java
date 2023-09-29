package com.satish.awsrds.service.impl;

import com.satish.awsrds.dao.EmployeeDao;
import com.satish.awsrds.dao.model.EmployeeEntity;
import com.satish.awsrds.service.EmployeeService;
import com.satish.awsrds.vo.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/*
 * @author - Satish R
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Employee> getAllEmployees(){
        List<EmployeeEntity> allEmployeesDao = employeeDao.getAllEmployees();

        return allEmployeesDao.stream().map(employeeEntity -> this.modelMapper.map(employeeEntity, Employee.class)).collect(Collectors.toList());
    }


}
