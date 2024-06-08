/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nipuni punsara
 */
public class StatisticsDao {

    private Connection con;

    public StatisticsDao() {
        this.con = ConnectionProvider.getCon();
    }

    public ResultSet getissuedetails() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='NO'");
        return rs;
    }
     public ResultSet getreturndetails() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs1 = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='Yes'");
        return rs1;
    
}
}
