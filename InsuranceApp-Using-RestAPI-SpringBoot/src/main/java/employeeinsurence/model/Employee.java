package employeeinsurence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee1")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "designation")
	private String designation;

	@Column(name = "salary")
	private float salary;

	@Column(name = "insurencescheme")
	private String insurencescheme;

	public Employee() {

	}

	public Employee(String name, String designation, float salary, String insurencescheme) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.insurencescheme = insurencescheme;
	}

	public Employee(int id, String name, String designation, float salary, String insurencescheme) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.insurencescheme = insurencescheme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getInsurencescheme() {
		return insurencescheme;
	}

	public void setInsurencescheme(String insurencescheme) {
		this.insurencescheme = insurencescheme;
	}

}
