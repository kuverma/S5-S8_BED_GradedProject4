package com.greatlearning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.entity.Roles;
import com.greatlearning.employee.entity.Users;
import com.greatlearning.employee.service.EmployeeService;
import com.greatlearning.employee.service.RoleService;
import com.greatlearning.employee.service.UserService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@PostMapping("/addrole")
	public Roles addRole(@RequestBody Roles role) {
		return roleService.addRole(role);
	}

	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}

	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> allEmployeeList() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployees(@PathVariable String employeeId) {
		return employeeService.getEmployeeById(Integer.parseInt(employeeId));
	}

	@PutMapping("/employees")
	public Employee updateEmployees(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployees(@PathVariable String employeeId) {
		employeeService.deleteEmployees(Integer.parseInt(employeeId));
		return "Deleted employee id - " + employeeId;
	}

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> getEmployeesByName(@PathVariable String firstName) {
		return employeeService.getEmployeesByName(firstName);
	}

	@GetMapping("employees/sort")
	public List<Employee> sortEmployees(@RequestParam(value = "order") String order) {
		order = order.replaceAll("”", "");
		if (order.equalsIgnoreCase("asc"))
			return employeeService.getEmployeesInSortedOrder(Direction.ASC);
		else
			return employeeService.getEmployeesInSortedOrder(Direction.DESC);
	}
}
