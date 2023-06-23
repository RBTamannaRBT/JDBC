// 1st jdbc program
import java.sql.*;
class insertjdbc
{
    public static void main(String args[])
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "rbt";
            Connection connection = null;
            
            connection = DriverManager.getConnection(url, username, password);

            //create query
            String q="create table table1(tid int(20) primary key auto_increment, tname varchar(200) not null, tcity varchar(400))";
            
            //create a statement
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(q);
            
            System.out.println("table created in database... yayy...");
            connection.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}