package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeSchema;
import dto.Employee;

public class Insertvalues {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner =new Scanner(System.in);
		System.out.println("enter employee id:");
		 int id =scanner.nextInt();
		 
		 System.out.println("enter employee name:");
		 String name= scanner.next();
		 
		 System.out.println("enter employee sector:");
		 String sector= scanner.next();
		 
		 System.out.println("enter employee gender:");
		 String gender= scanner.next();
		 
		 System.out.println("enter employee salary:");
		 double salary =scanner.nextDouble();
		 
		 Employee employee =new Employee();
		 employee.setEmployeeID(id);
		 employee.setEmployeeName(name);
		 employee.setEmplyeeSector(sector);
		 employee.setEmployeeGender(gender);
		 employee.setEmployeeSalary(salary);
		 
		 EmployeeSchema employeeSchema =new EmployeeSchema();
		 employeeSchema.insertValues(employee);
	}
	

}
