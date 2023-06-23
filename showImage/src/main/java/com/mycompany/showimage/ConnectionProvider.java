/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.showimage;

/**
 *
 * @author rbtamanna
 */
import java.sql.*;

class ConnectionProvider
{

    private static Connection con;
    
    public static Connection getConnection() 
    {
        try
        {
            if(con==null)
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/firstdb";
                    String username = "root";
                    String password = "rbt";
                    con = DriverManager.getConnection(url, username, password);
                    //
                    Statement statement = con.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT VERSION()");

                        if (resultSet.next()) {
                            String mysqlVersion = resultSet.getString(1);
                            System.out.println("MySQL Version: " + mysqlVersion);
                        }//

                }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con;
    }
}
