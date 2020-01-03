package com.Ashit.cruddemo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Ashit.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer > {

	/*
	 * @Modifying
	 * 
	 * @Query("delete from Employee e where e.first_name LIKE 'l%'")
	 * 
	 * @Transactional int deleteInBatchById(Iterable<Employee> id);
	 */
}
