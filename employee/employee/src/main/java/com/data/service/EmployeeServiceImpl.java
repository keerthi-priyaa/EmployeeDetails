package com.data.service;

import com.data.entity.Employee;
import com.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee saveEmployee(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}
	@Override
	public void deleteById(Integer theId) {
		employeeRepository.deleteById(theId);

	}

}





