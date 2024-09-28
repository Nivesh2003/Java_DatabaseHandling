package java_jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // JDBC connection URL
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java?user=root&password=nivesh@2003";

        // SQL query for updating all fields (NAME, AGE, and ID) for a given ID
        String updateSQL = "UPDATE MGMT_SYSTEM SET NAME = ?, AGE = ?, ID = ? WHERE ID = ?";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL);

            // Prepare the SQL statement
            PreparedStatement pS = connection.prepareStatement(updateSQL);

            while (true) {
                // Input for the ID of the record to update
                System.out.println("Enter the current ID of the record to update: ");
                String currentID = sc.nextLine();

                // Input for the new values to update
                System.out.println("Enter new NAME: ");
                String newName = sc.nextLine();

                System.out.println("Enter new AGE: ");
                int newAge = sc.nextInt(); 
                sc.nextLine();  // Consume the newline

                System.out.println("Enter new ID: ");
                String newID = sc.nextLine();

                // Set values for the prepared statement
                pS.setString(1, newName);  // First ? for NAME
                pS.setInt(2, newAge);      // Second ? for AGE
                pS.setString(3, newID);    // Third ? for new ID
                pS.setString(4, currentID);  // Fourth ? for current ID to identify the record

                // Execute the update
                int rowsUpdated = pS.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println(rowsUpdated + " row(s) updated successfully.");
                } else {
                    System.out.println("No rows updated. Record with ID " + currentID + " not found.");
                }

                // Ask if the user wants to update more records
                System.out.println("Wish to update more records (y/n)? ");
                String inp = sc.nextLine();
                if (inp.equalsIgnoreCase("n")) {
                    break;
                }
            }

           
            pS.close();
            connection.close();
            sc.close();

        } catch (SQLException e) {
	        System.out.println("Error connecting to the database: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println("JDBC Driver not found: " + e.getMessage());
	    }
}
    }

