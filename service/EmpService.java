package com.practice.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.project.Model.Employee;
import com.practice.project.repository.EmpRepository;

@Service
public class EmpService  {
	
@Autowired
public EmpRepository empRepo;

public Employee addEmp(@RequestBody Employee emp)
{
	Employee employee=new Employee();
	try {
		employee=empRepo.save(emp);
	}
	catch(Exception e)
	{
		System.out.println("Exception while adding employee");
	}
return employee;
}
public List<Employee> getAllEmployee()
{
	List<Employee> allEmp=new ArrayList<>();
	try {
		allEmp = empRepo.findAll();
	} catch (Exception e) {
		System.out.println("Exception while getting list of Employee");
	}
	return allEmp;
}
public Employee getEmpById(int empid)
{
	Employee emp = new Employee();
	try {
		emp = convertToEmployee(empRepo.findById(empid));
	} catch (Exception e) {
		System.out.println("exception while getting employee");
	}
	return emp;
}
private Employee convertToEmployee(Optional<Employee> emp) {
	Employee employee = new Employee();
	if (emp != null) {
		employee.setEmpid(emp.get().getEmpid());
		employee.setName(emp.get().getName());
	}
	return employee;
}
public String deleteById(int empid)
{
	Employee employee = new Employee();
	boolean flag = false;
	try {
		employee = getEmployee(empid);
		if (employee != null) {
			empRepo.deleteById(empid);
			flag = true;
		}
	} catch (Exception e) {
		System.out.println("Exception while removing Employee");
	}
	if (flag) {
		return "employee deleted Successfully with id= " + empid;
	} else {
		return "id " + empid + " does not exist";
	}
}
public Employee getEmployee(int empid) {
	Employee emp = new Employee();
	try {
		emp = convertToEmployee(empRepo.findById(empid));
	} catch (Exception e) {
		System.out.println("exception while getting employee");
	}
	return emp;
}
public Employee update(Employee emp)
{
	Employee employee = new Employee();
	try {
		employee = getEmployee(emp.getEmpid());

		if (employee != null) {
			employee.setName(emp.getName());
		}
	} catch (Exception e) {
		System.out.println("Exception while modifing Employee");
	}
	return employee;
}
}

