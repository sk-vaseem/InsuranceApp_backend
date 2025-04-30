package employeeinsurence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeinsurence.model.Employee;
import employeeinsurence.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	public Employee findEmployeeById(int employeeId) {
	    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
	    if (optionalEmployee.isPresent()) {
	        return optionalEmployee.get();
	    } else {
	        throw new RuntimeException("Employee not found with ID: " + employeeId);
	    }
	}

}
