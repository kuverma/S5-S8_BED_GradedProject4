package com.greatlearning.employee.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public void addEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployees(int id);

	public List<Employee> getEmployeesByName(String firstName);

	public List<Employee> getEmployeesInSortedOrder(Direction direction);

}
