package com.example.SpringThymeleafCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringThymeleafCRUD.DAO.EmployeeRepository;
import com.example.SpringThymeleafCRUD.Entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository er;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository er) {
		super();
		this.er = er;
	}

	@Override
	public List<Employee> findAll() {
		return er.findAllByOrderByIdAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> op = er.findById(id);
		Employee e = op.get();
		return e;
	}

	@Override
	public void save(Employee emp) {
		er.save(emp);

	}

	@Override
	public void delete(int id) {
		er.deleteById(id);
	}

}
