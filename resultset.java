// dynamic query/PreparedStatment

import java.sql.*;
class resultset
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

            String q="select * from table1";
            Statement stmt = connection.createStatement();
            ResultSet set=stmt.executeQuery(q);
            
            System.out.println(set);
            System.out.println("done...");

            connection.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}