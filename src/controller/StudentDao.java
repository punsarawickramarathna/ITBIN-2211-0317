/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Book;
import Model.Student;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nipuni punsara
 */
public class StudentDao {
    private Connection con;

    public StudentDao() {
        this.con = ConnectionProvider.getCon();
    }
    
    public void addstudent(Student student) throws Exception{
        
        Statement st = con.createStatement();
            st.executeUpdate("insert into student values('" + student.getStudentID()+ "','" + student.getName() + "','" + student.getEmail() + "','" + student.getCourseName() + "','" + student.getBranchName() + "')");
    }
    
     public void updatestudent(Student student) throws Exception {
         Statement st = con.createStatement();
         String sql = "update student SET StudentID='" + student.getStudentID() + "',Name='" + student.getName() + "',email='" + student.getEmail() + "',CourseName='" + student.getCourseName() + "',BranchName='" + student.getBranchName() + "' WHERE StudentID = '" + student.getStudentID() + "'";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.execute();
     }    
     
      public void deletestudent(int studentID) throws SQLException {
          Statement st = con.createStatement();
          String sql = "DELETE FROM STUDENT WHERE studentID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentID);

            ps.execute();
      }
      public ResultSet getStudents() throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM STUDENT";
        ResultSet res = stmt.executeQuery(sql);
        return res;
    }
}

