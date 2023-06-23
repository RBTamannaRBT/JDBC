/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.showimage;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author rbtamanna
 */
public class helper 
{
    public static ImageIcon getImageIconById(int id, Connection c)
    {
        ImageIcon icon=null;
        try
        {
            String q="select pic from image where id=?";
            PreparedStatement pstmt=c.prepareStatement(q);
            pstmt.setInt(1, id);
            ResultSet set=pstmt.executeQuery(q);
            if(set.next())
            {
                Blob b=set.getBlob("pic");
                InputStream is=b.getBinaryStream();
                Image image=ImageIO.read(is);
                icon=new ImageIcon(image);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        return icon;
    }
    
}
