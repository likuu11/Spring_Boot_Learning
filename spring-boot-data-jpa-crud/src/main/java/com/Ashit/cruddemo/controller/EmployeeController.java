package com.Ashit.cruddemo.controller;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashit.cruddemo.entity.Employee;
import com.Ashit.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	/*
	 * public EmployeeController() { // TODO Auto-generated constructor stub }
	 */
	@GetMapping("/employees")
	public List<Employee> findEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees/{id}")
	public Employee save(@RequestBody Employee thEmployee) {
		thEmployee.setId(0);
		employeeService.save(thEmployee);
		return thEmployee;
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		Employee thEmployee=employeeService.findEmployeeById(id);
		if(thEmployee==null) {
			throw new RuntimeException("Employee not foound :" + id);
		}
		return thEmployee;
	}
	
	@PutMapping("/employees")
	public Employee Update(@RequestBody Employee thEmployee)
	{
		employeeService.save(thEmployee);
		return thEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
			Employee thEmployee=employeeService.findEmployeeById(employeeId);
			if(thEmployee==null) {
				throw new RuntimeException("Employee not foound :" + employeeId);
			}
			employeeService.deleteById(employeeId);
			return "Deleteed id " + employeeId;
	}
	
	
}
