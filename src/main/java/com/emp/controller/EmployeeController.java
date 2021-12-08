package com.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.EmployeeEntity;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/home")
	public String welcome() {
		return "Welcome to my Employee Application";
	}
	
	@GetMapping(value = "/findAll")
	public List<EmployeeEntity> findAllEmployee(HttpServletRequest req){
	return service.findAllEmployee();	
	}
	
	@GetMapping(value = "/findById/{eid}")
	public EmployeeEntity findEmployeeByID(@PathVariable("eid")int eid, HttpServletRequest req) {
		return service.findEmployeeById(eid);
		}
	
	@PutMapping(value = "/createEmployee")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity emp, HttpServletRequest req) {
		return service.createEmployee(emp);
	}
	
	@PostMapping(value = "/updateEmployee/{eid}")
	public EmployeeEntity updateEmployee(@PathVariable("eid")int eid, @RequestBody EmployeeEntity emp, HttpServletRequest req) {
		return service.updatEmployee(eid, emp);
	}
	
	@DeleteMapping(value="/deleteEmployee/{eid}")
	public void deleteEmployee(@PathVariable("eid")int eid, HttpServletRequest req) {
		service.deleteEmployee(eid);
	}


}
