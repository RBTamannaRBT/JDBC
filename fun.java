// dynamic query/PreparedStatment

import java.sql.*;
class fun
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
            
            pstmt.setString(1, "rbt rbt");
            pstmt.setString(2, "mirpur");

            pstmt.executeUpdate();

            System.out.println("inserted...");

            connection.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}