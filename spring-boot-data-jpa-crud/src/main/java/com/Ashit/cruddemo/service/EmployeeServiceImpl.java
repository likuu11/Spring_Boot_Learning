package com.Ashit.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Ashit.cruddemo.dao.EmployeeRepository;
import com.Ashit.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepo) {
	employeeRepo=theemployeeRepo;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public void save(Employee thEmployee) {
		 employeeRepo.save(thEmployee);
	}

	@Override
	public Employee findEmployeeById(int id) {
		//JPA repository makes use of Optional to check if data exists or not
		Optional<Employee> result = employeeRepo.findById(id);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else
		{
	throw new RuntimeException("Did not finf the employee :" + id);
		}
		return theEmployee;
	}

	@Override
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}

	/*
	 * @Override public void deleteInBatch(Iterable<Employee> id) {
	 * employeeRepo.deleteInBatchById(id); }
	 */
}
