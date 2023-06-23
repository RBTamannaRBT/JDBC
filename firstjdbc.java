// 1st jdbc program
import java.sql.*;
class firstjdbc
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

            if(connection.isClosed())
            {
                System.out.println("Connection is closed");
            }
            else
            {
                System.out.println("Connection created...yayy...");
            }        
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}