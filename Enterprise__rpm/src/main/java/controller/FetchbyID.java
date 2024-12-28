package controller;

import java.util.Scanner;

import dao.EmployeeSchema;
import dto.Employee;

public class FetchbyID {
	public static void main(String[] args) throws Exception {
		Scanner scanner =new Scanner(System.in);
		System.out.println("enter employee id");
		int id = scanner.nextInt();
		Employee employee =new Employee();
		employee.setEmployeeID(id);
		EmployeeSchema employeeSchema =new EmployeeSchema();
		employeeSchema.fetchById(employee);
	}
}
