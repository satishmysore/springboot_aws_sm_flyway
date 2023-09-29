package com.satish.awsrds.dao;

import com.satish.awsrds.dao.model.EmployeeEntity;

import java.util.List;

/*
 * @author - Satish R
 */

public interface EmployeeDao {
    List<EmployeeEntity> getAllEmployees();
}
