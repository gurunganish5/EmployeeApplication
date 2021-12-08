package com.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.entity.EmployeeEntity;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository repo;

	public List<EmployeeEntity> findAllEmployee(){
		return (List<EmployeeEntity>) repo.findAll();
		}
	
	public EmployeeEntity findEmployeeById(int eid) {
		return repo.findById(eid).get();
	}
	
	public EmployeeEntity createEmployee(EmployeeEntity emp) {
		return repo.save(emp);
	}
	
	public EmployeeEntity updatEmployee(int eid, EmployeeEntity emp) {
		EmployeeEntity emp1 = repo.findById(eid).get();
		if(emp1!=null) {
			emp1.setFname(emp.getFname());
			emp1.setLname(emp.getLname());
			emp1.setEmail(emp.getEmail());
			return repo.save(emp1);
			}else {
				return null;
			}
	}
	
	public void deleteEmployee(int eid) {
		repo.deleteById(eid);
	}
}
