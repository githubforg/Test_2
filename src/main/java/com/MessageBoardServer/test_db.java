package com.MessageBoardServer;
import java.sql.*;
import org.postgresql.*;

/**
 * Created by DELL on 14-3-12.
 */
public class test_db {
    public static void main(String[] argv) {



                System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

             connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/mydb", "deepfuture",
                    "123123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        //检测数据库连接

        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from cities;";
            String insert1="insert into cities values"+"('Sichuan',"+"'(100.,21)');";
            System.out.println(sql);
            System.out.println(insert1);
            stmt.executeUpdate(insert1);
            stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
