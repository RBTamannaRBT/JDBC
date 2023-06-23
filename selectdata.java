// select data from databse

import java.sql.*;
import java.io.*;


class selectdata
{
    public static void main(String args[])
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "rbt";
            Connection c = null;
            
            //connection
            c = DriverManager.getConnection(url, username, password);
            System.out.println("connected...yayy");

            String q="select * from table1";

            Statement stmt=c.createStatement();
            ResultSet set=stmt.executeQuery(q);

            while(set.next())
            {
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(name+" : "+id+" : "+city);
            }

            c.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}