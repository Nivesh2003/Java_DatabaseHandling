package java_jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read {

    public static void main(String[] args) {
        // JDBC connection URL
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java?user=root&password=nivesh@2003";
        
        // SQL query to retrieve data from the MGMT table
        String sqlQuery = "SELECT * FROM MGMT_SYSTEM"; 
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL);

            
            Statement statement = connection.createStatement();

            // Execute the query and obtain the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Print table headers
            System.out.println("Name\t\tAge\t\tID");

            
            while (resultSet.next()) {
                
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String id = resultSet.getString("ID");

                
                System.out.println(name + "\t\t" + age + "\t\t" + id);
            }

            
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
