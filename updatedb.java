// update databse

import java.sql.*;
import java.io.*;
import javax.swing.*;

class updatedb
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

            String q="update table1 set tname=?, tcity=? where tid=?";

            BufferedReader rb=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("notun nam bolen : ");
            String name=rb.readLine();
            
            System.out.println("notun address bolen : ");
            String city=rb.readLine();

            System.out.println("apnr id bolen : ");
            int id=Integer.parseInt(rb.readLine());

            PreparedStatement pstmt=c.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);
            
            pstmt.executeUpdate();

            //System.out.println("image inserted...yayy");
            JOptionPane.showMessageDialog(null,"success...yayyy");

            c.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}