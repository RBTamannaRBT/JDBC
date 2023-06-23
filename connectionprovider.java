// insert large image
//package JDBC;

import java.sql.*;

class connectionprovider
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
                }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con;
    }
}