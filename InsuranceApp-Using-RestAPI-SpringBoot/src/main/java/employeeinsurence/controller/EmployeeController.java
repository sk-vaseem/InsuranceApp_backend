package employeeinsurence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employeeinsurence.model.Employee;
import employeeinsurence.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		if (employee == null) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
		String insuranceScheme = employee.getSalary() > 5000 ? "Scheme A" : "Scheme B";
		Employee newEmployee = new Employee(employee.getName(), employee.getDesignation(), employee.getSalary(),
				insuranceScheme);
		employeeService.addEmployee(newEmployee);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		if (employee == null) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
		String insuranceScheme = employee.getSalary() > 5000 ? "Scheme A" : "Scheme B";
		employee.setInsurencescheme(insuranceScheme);
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

}
