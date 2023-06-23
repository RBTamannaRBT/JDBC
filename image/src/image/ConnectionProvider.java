/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package image;

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
                }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con;
    }
}

