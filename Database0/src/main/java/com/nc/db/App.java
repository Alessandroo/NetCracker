package com.nc.db;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String URL = "jdbc:mysql://localhost:3306/laba1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main( String[] args )
    {


//        Connection connection;
//
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            Statement statement = connection.createStatement();
//
////            statement.execute("INSERT INTO users(name, age, email) VALUE ('Worst', 15, 'Grammafon@jon.com');");
//
//            ResultSet resultSet = statement.executeQuery("SELECT * from users");
//
//            while (resultSet.next()){
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                String email = resultSet.getString(3);
//                System.out.println("id= " + id + "\tname " + name + "\te-mail " + email);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Incorrect connection");
//        }
//        System.out.println( "Hello World!" );
    }
}
