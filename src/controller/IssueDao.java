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
import javax.swing.JOptionPane;

/**
 *
 * @author Nipuni punsara
 */
public class IssueDao {
    
     private Connection con;

    public IssueDao() {
        this.con = ConnectionProvider.getCon();
    }
    public void addissues( Issue issue) throws Exception{
    Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from book where bookID='"+issue.getBookID()+"'");
            if(rs.next())
            {
              ResultSet rs1=st.executeQuery("select *from student where StudentID='"+issue.getStudentID()+"'");
              if(rs1.next())
              {
                  st.executeUpdate("insert into issue values('"+issue.getBookID()+"','"+issue.getStudentID()+"','"+issue.getIssueDate()+"','"+issue.getDueDate()+"','"+issue.getReturnBook()+"')");
                  JOptionPane.showConfirmDialog(null, "Book Successfully Issued");
                 
              }
              else 
                   JOptionPane.showConfirmDialog(null, "Incorrect StudentID");
            }
            else 
                JOptionPane.showConfirmDialog(null, "Incorrect BookID");
            
        }
    
}
