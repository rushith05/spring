package controller;

import java.sql.SQLException;

import dao.EmployeeSchema;

public class SchemaCreation {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeSchema employeeSchema =new EmployeeSchema();
		employeeSchema.createSchema();
	}
	
	
	

}
