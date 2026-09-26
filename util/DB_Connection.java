package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_system";
    // java database connectivity , we are connecting to mysql ,
    // MySql is running on my own computer , mysql port , the db we created
    private static final String USER = "root";

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL , USER , PASSWORD);

    }

    public static void main(String[] args) {

        try {
            Connection con = getConnection();

            System.out.println("Database connected successfully!");

            con.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}

