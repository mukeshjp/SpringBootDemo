package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@RestController
public class EmpController {
	@Autowired
	EmployeeRepository er;
    @PostMapping("/saveemp")
	public Employee saveEmp(@RequestBody Employee e)
	{
    	er.save(e);
		return e;
		
	}
    
    @GetMapping("/getempdata")
    public Employee getEmpData(@RequestParam int id)
    {
    	Optional<Employee> em=er.findById(id);
    	return em.get();
    }
    @GetMapping("/getalldata")
    public List<Employee> getAllEmployee()
    {
    List<Employee> em = er.findAll();
    	return em;
    }
    @DeleteMapping("/deletempdata")
    public String deletEmpData(@RequestParam int id)
    {
    	er.deleteById(id);
    	return "deleted data successfully";
    }
    @PutMapping("/updateempdata")
    public Employee updateEmpData(@RequestBody Employee e)
    
    {
    	er.save(e);
    
    	return e;
    			
    			
    }
    
}
