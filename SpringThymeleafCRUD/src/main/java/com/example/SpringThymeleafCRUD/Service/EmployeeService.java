package com.example.SpringThymeleafCRUD.Service;

import java.util.List;

import com.example.SpringThymeleafCRUD.Entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee emp);

	public void delete(int id);
}
