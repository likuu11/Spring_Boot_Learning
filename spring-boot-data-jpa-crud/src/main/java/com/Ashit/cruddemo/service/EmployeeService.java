package com.Ashit.cruddemo.service;

import java.util.List;

import com.Ashit.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public void save(Employee thEmployee);
	public Employee findEmployeeById(int id);
	public void deleteById(int id);
	/* public void deleteInBatch(Iterable<Employee> id); */
}
