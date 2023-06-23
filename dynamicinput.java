// dynamic input

import java.sql.*;
import java.io.*;

class dynamicinput
{
    public static void main(String args[])
    {
        try 
        {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "rbt";
            Connection connection = null;
            
            //connection
            connection = DriverManager.getConnection(url, username, password);

            String q="insert into table1(tname, tcity) values(?,?)";
            
            PreparedStatement pstmt=connection.prepareStatement(q);

            BufferedReader rb=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Nam bolen : ");
            String name=rb.readLine();

            System.out.println("Kothay thhaken : ");
            String city=rb.readLine();
            
            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();

            System.out.println("inserted...");

            connection.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}