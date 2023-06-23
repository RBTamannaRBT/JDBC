// insert image

import java.sql.*;
import java.io.*;

class insertimage
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

            String q="insert into images(pic) values(?)";
            
            PreparedStatement pstmt=connection.prepareStatement(q);

            FileInputStream tf=new FileInputStream("tomatoo.jpeg");
            
            pstmt.setBinaryStream(1, tf, tf.available());
            

            pstmt.executeUpdate();

            System.out.println("image inserted...yayy");

            connection.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}