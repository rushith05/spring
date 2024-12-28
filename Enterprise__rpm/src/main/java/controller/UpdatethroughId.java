package controller;

import java.util.Scanner;

import dao.EmployeeSchema;
import dto.Employee;

public class UpdatethroughId {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter employee name to be updated"
				+ "");
		String name = scanner.next();
		
		System.out.println("enter employee id");
		int id = scanner.nextInt();
		
		Employee employee =new Employee();
		
		employee.setEmployeeName(name);
		
		employee.setEmployeeID(id);
		EmployeeSchema employeeSchema =new EmployeeSchema();
		employeeSchema.updateDetails(employee);
		

	}

}
