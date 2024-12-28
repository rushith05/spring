package controller;

import dao.EmployeeSchema;
import dto.Employee;

public class Fetchall {
	public static void main(String[] args) throws Exception {
		EmployeeSchema employeeSchema =new EmployeeSchema();
		Employee employee =new Employee();
		employeeSchema.fetchAll(employee);
	}

}
