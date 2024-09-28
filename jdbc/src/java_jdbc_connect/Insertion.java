package java_jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java?user=root&password=nivesh@2003"; //Replace with your URL
		 String insertSQL = "INSERT INTO MGMT_SYSTEM (NAME, AGE, ID) VALUES (?, ?, ?)";
		  try {
	            // Load MySQL JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establish the connection to the database
	            Connection connection = DriverManager.getConnection(jdbcURL);
	            
	            //Prepared statement
	            PreparedStatement pS = connection.prepareStatement(insertSQL);
	            
	            while(true) {
	            	System.out.println("Enter Name: ");
	                String name = sc.nextLine();
	                
	                System.out.println("Enter Age: ");
	                int age = sc.nextInt();
	                
	                sc.nextLine(); //Clears newline
	                
	                System.out.println("Enter ID: ");
	                String id = sc.nextLine();
	                
	                
	                pS.setString(1, name);  // For the NAME column
	                pS.setInt(2, age);      // For the AGE column
	                pS.setString(3, id);    // For the ID column
	                
	                int rowsInserted =  pS.executeUpdate();
	                if(rowsInserted>0) {
	                	System.out.println("Rows updated ="+rowsInserted);
	                }
	                System.out.println("Do you wish to enter more record?(y/n");
	                String choice = sc.nextLine();
	                if(choice.equalsIgnoreCase("n")) 
	                	break;
	                
	                
	            }
	            
	            
	            
	}catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
    } catch (ClassNotFoundException e) {
        System.out.println("JDBC Driver not found: " + e.getMessage());
    }

}
}
