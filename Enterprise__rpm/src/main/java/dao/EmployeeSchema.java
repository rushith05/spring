package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import dto.Employee;

public class EmployeeSchema {
	public void createSchema() throws ClassNotFoundException, SQLException {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "rushith@123");
		// create statement
		Statement statement = connection.createStatement();
		// execute Statement
		statement.execute("create schema employeedb ");
		connection.close();
		System.out.println("schema created sucessfully");

	}

	public void createTable() throws SQLException, ClassNotFoundException {
//		private int employeeID;
//		private String employeeName;
//		private String emplyeeSector;
//		private String employeeGender;
//		private double employeeSalary;
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		// create statement
		Statement statement = connection.createStatement();
		// execute Statement
		statement.execute(
				"create table employeeinfo (employeeid INT PRIMARY KEY ,employeename VARCHAR(30),employeesector VARCHAR(30) ,employeegender VARCHAR(30),employeesalary INT )");
		statement.close();
		System.out.println("table created sucessfully");

	}

	public void insertValues(Employee employee) throws ClassNotFoundException, SQLException {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		// create statement
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into employeeinfo  values(?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getEmployeeID());
		preparedStatement.setString(2, employee.getEmployeeName());
		preparedStatement.setString(3, employee.getEmplyeeSector());
		preparedStatement.setString(4, employee.getEmployeeGender());
		preparedStatement.setDouble(5, employee.getEmployeeSalary());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
		System.out.println("values inserted sucessfully");

	}

	public void updateDetails(Employee employee) throws Exception {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		PreparedStatement preparedStatement = connection
				.prepareStatement("update employeeinfo set employeename=? where employeeid=?");
		preparedStatement.setString(1, employee.getEmployeeName());
		preparedStatement.setInt(2, employee.getEmployeeID());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
		System.out.println("values updated sucessfully");

	}

	public void deletDetails(Employee employee) throws Exception {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from employeeinfo where employeeid=? ");
		preparedStatement.setInt(1, employee.getEmployeeID());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
		System.out.println("the values deleted sucessuflly");

	}

	public void fetchAll(Employee employee) throws Exception {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		PreparedStatement preparedStatement = connection.prepareStatement("select *from employeeinfo");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("employee id:" + resultSet.getInt(1));
			System.out.println("employee name:" + resultSet.getString(2));
			System.out.println("employee sector:" + resultSet.getString(3));
			System.out.println("employee gender:" + resultSet.getString(4));
			System.out.println("employee salary:" + resultSet.getDouble(5));
			System.out.println("----------------------------------------------------------------------------------");

		}
		preparedStatement.executeQuery();
		preparedStatement.close();
		connection.close();
		System.out.println("the values fetched sucessfully");

	}

	public void fetchById(Employee employee) throws Exception {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root",
				"rushith@123");
		PreparedStatement preparedStatement = connection
				.prepareStatement("select *from employeeinfo where employeeid=?");
		preparedStatement.setInt(1, employee.getEmployeeID());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("employee id:" + resultSet.getInt(1));
			System.out.println("employee name:" + resultSet.getString(2));
			System.out.println("employee sector:" + resultSet.getString(3));
			System.out.println("employee gender:" + resultSet.getString(4));
			System.out.println("employee salary:" + resultSet.getDouble(5));
			System.out.println("----------------------------------------------------------------------------------");

		}

	}
}
