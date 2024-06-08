/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Return;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.returnBook;

/**
 *
 * @author Nipuni punsara
 */
public class ReturnBookController {
    
    private returnBook ret;
     private ReturnDao returnDao;
    
    public ReturnBookController() {
        this. ret = new returnBook();
        this.returnDao = new ReturnDao();
        ret.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        ret.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        
        ret.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        ret.setVisible(true);
}
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String bookID=ret.getjTextField1().getText();
//        String StudentID=ret.getjTextField2().getText();
        
        Return retu = new Return();
        retu.setBookID(ret.getjTextField1().getText());
        retu.setStudentID(ret.getjTextField2().getText());
        
        try
        {
            
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select *from issue where bookID='"+bookID+"' and studentID='"+StudentID+"'");
            ResultSet rs = returnDao.addreturn(retu);
            if(rs.next())
            {
               ret.getjTextField3().setText(rs.getString(3));
               ret.getjTextField4().setText(rs.getString(4));
               ret.getjTextField1().setEditable(false);
               ret.getjTextField2().setEditable(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"Book is not issued to this student");
                ret.setVisible(false);
                 new ReturnBookController();
                new returnBook().setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection Error");
        }
    }   
    
     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        String bookID=ret.getjTextField1().getText();
        String StudentID=ret.getjTextField2().getText();
        
       
        try
        {
         Connection con=ConnectionProvider.getCon();
         Statement st=con.createStatement();  
         st.executeUpdate("Update issue set returnBook='YES' where StudentID='"+StudentID+"' and bookID='"+bookID+"'");
         JOptionPane.showMessageDialog(null,"Book Successfully Returned");
            ret.setVisible(false);
            new ReturnBookController();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection Error");
        }
    }          
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        ret.setVisible(false);
    }  
    
}

