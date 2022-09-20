package com.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.project.Model.Employee;


@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer>{
	
}
