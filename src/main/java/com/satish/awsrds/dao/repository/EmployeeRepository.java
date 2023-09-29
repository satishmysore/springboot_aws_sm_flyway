package com.satish.awsrds.dao.repository;

import com.satish.awsrds.dao.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * @author - Satish R
 */


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
