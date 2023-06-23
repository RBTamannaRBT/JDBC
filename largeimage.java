// insert large image
//package JDBC;

import java.sql.*;
import java.io.*;
import javax.swing.*;

class largeimage
{
    public static void main(String args[])
    {
        try 
        {
            //Connection c=connectionprovider.getConnection();
            //load driver
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "rbt";
            Connection c = null;
            
            //connection
            c = DriverManager.getConnection(url, username, password);
            System.out.println("connected...yayy");

            String q="insert into image(pic) values(?)";
            
            PreparedStatement pstmt=c.prepareStatement(q);

            JFileChooser jfc=new JFileChooser();

            jfc.showOpenDialog(null);

            File file=jfc.getSelectedFile();

            FileInputStream tf=new FileInputStream(file);
            
            pstmt.setBinaryStream(1, tf, tf.available());
            

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