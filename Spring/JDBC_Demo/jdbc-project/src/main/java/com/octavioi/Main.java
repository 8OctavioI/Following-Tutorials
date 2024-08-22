package com.octavioi;

import java.sql.*;


public class Main {
    private static String host = "jdbc:mysql://localhost:3306/appdb";
    private static String usr = "root";
    private static String pass = "0000";
    public static void main(String[] args) throws SQLException{
        Connection connection = DriverManager.getConnection(host, usr, pass);

        System.out.println("Connection Established!");

        Statement statement = connection.createStatement();

        // String addRow = "INSERT INTO Students values(4, 'Smithy', 9)";
        // statement.execute(addRow);

        String addColumn = "ALTER TABLE Students\n" +
                            "ADD Grade varchar(1);";
        
        statement.execute(addColumn);

        String grade = "UPDATE Students\n" +
                        "SET Grade = 'P'\n"+
                        "WHERE Marks >= 4.6;\n";
        statement.execute(grade);
        
        grade = "UPDATE Students\n" +
                        "SET Grade = 'F'\n"+
                        "WHERE Marks < 4.6;\n";
        statement.execute(grade);


        String sqlQuery = "Select * from Students";
        ResultSet set = statement.executeQuery(sqlQuery);

        
    
        while(set.next()) {
            String id = set.getString("StudentID");
            String name = set.getString("StudentName");
            String mark = set.getString("Marks");
            String grades = set.getString("Grade");
            System.out.println(String.format("%s[%s] has scored %s with a grade of: %s", name, id, mark, grades));
            
        }

        


        connection.close();
        System.out.println("Connection closed!");
    }
}   