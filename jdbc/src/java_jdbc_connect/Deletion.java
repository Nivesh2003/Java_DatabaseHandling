package java_jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deletion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java?user=root&password=nivesh@2003";
		 String deleteSQL = "DELETE FROM MGMT_SYSTEM WHERE ID = ?";
		  try {
	            // Load MySQL JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish the connection to the database
	            Connection connection = DriverManager.getConnection(jdbcURL);
	            
	            PreparedStatement pS = connection.prepareStatement(deleteSQL);
	            
	            while(true) {
	            	 System.out.println("Enter ID to delete record: ");
	                 String id = sc.nextLine();
	                 
	                 pS.setString(1, id);
	                 
	                 int rowsDeleted = pS.executeUpdate();
	                 if(rowsDeleted>0) {
	                	 System.out.println(rowsDeleted+" rows deleted");
	                 } else {
	                	 System.out.println("No rows deleted");
	                 }
	                 
	                 System.out.println("Wish to delete more (y/n) ?");
	                 String inp = sc.nextLine();
	                 if(inp.equalsIgnoreCase("n")){
	                 break;
	                 }
	                 
	            }
	            
	            sc.close();
	            
	            
		  }catch (SQLException e) {
		        System.out.println("Error connecting to the database: " + e.getMessage());
		    } catch (ClassNotFoundException e) {
		        System.out.println("JDBC Driver not found: " + e.getMessage());
		    }
	}

};
