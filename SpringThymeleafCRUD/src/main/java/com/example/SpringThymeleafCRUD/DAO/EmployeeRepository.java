package com.example.SpringThymeleafCRUD.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringThymeleafCRUD.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findAllByOrderByIdAsc();
}
