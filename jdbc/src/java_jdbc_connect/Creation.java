package java_jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creation {
    public static void main(String[] args) {
        // Connection URL 
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java?user=root&password=nivesh@2003";
        String createTableSQL = "CREATE TABLE MGMT_System ("
                + "NAME CHAR(40) , "
                + "AGE INT, "
                + "ID VARCHAR(50))";

        
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL);
            
            // If connection is successful
            System.out.println("Connected to the database...");
            
            //Statement for query execution
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
            
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }
}
