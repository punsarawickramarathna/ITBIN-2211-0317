/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Issue;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import view.issueBook;

/**
 *
 * @author Nipuni punsara
 */
public class IssueController {
    
    private issueBook issue;
    private IssueDao issueDao;
    
     public IssueController() {
        this.issue = new issueBook();
         this.issueDao = new IssueDao();
        issue.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        issue.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
    issue.setVisible(true);
}
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-YYYY");
//        String bookID=issue.getjTextField1().getText();
//        String StudentID=issue.getjTextField2().getText();
//        String issueDate=dFormat.format(issue.getjDateChooser1().getDate());
//        String dueDate=dFormat.format(issue.getjDateChooser2().getDate());
//        String returnBook="NO";
        
        Issue iss = new Issue();
        iss.setdFormat(new SimpleDateFormat("dd-MM-YYYY"));
        iss.setBookID(issue.getjTextField1().getText());
        iss.setStudentID(issue.getjTextField2().getText());
        iss.setIssueDate(dFormat.format(issue.getjDateChooser1().getDate()));
        iss.setDueDate(dFormat.format(issue.getjDateChooser2().getDate()));
        iss.setReturnBook("NO");
        
        
        try
        {
            
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select *from book where bookID='"+bookID+"'");
//            if(rs.next())
//            {
//              ResultSet rs1=st.executeQuery("select *from student where StudentID='"+StudentID+"'");
//              if(rs1.next())
//              {
//                  st.executeUpdate("insert into issue values('"+bookID+"','"+StudentID+"','"+issueDate+"','"+dueDate+"','"+returnBook+"')");
//                  JOptionPane.showConfirmDialog(null, "Book Successfully Issued");
//                  issue.setVisible(false);
//                  new IssueController();
//              }
//              else 
//                   JOptionPane.showConfirmDialog(null, "Incorrect StudentID");
//            }
//            else 
//                JOptionPane.showConfirmDialog(null, "Incorrect BookID");
            issueDao.addissues(iss);
            
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, "Connection Error");
        }
    }                                        
     
     
      private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        issue.setVisible(false);
    }   
}