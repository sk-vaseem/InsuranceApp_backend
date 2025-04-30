package employeeinsurence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeinsurence.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
