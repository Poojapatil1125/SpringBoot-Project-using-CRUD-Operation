package com.practice.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.project.Model.Employee;
import com.practice.project.service.EmpService;

@RestController
@RequestMapping(value="/employee")
public class EmpController {
	
	@Autowired
	public EmpService empService;
	
	@PostMapping(value="/addEmp")
	public Employee addEmp(@RequestBody Employee emp)
	{
		System.out.println(emp);
		return empService.addEmp(emp);
	}
	@GetMapping(value="/getAllEmp")
	public List<Employee> getAll()
	{
		List<Employee> allEmp=empService.getAllEmployee();
		System.out.println(allEmp);
		return allEmp;
	}
	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable("id") int id)
	{
		Employee emp=empService.getEmpById(id);
		System.out.println(emp);
		return emp;
	}
	@DeleteMapping("/deleteEmpById/{id}")
	public String deleteEmpById(@PathVariable("id") int id)
	{
	String deleteEmpById = empService.deleteById(id);
	return deleteEmpById;
	}
	@PutMapping("/updateEmployee/{empId}")
	public Employee modifyEmployee(@RequestBody Employee emp) {
		Employee modifyEmployee = empService.update(emp);
		return modifyEmployee; 
	}
}

