/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Student;
import Project1.ConnectionProvider;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import view.newStudent;

/**
 *
 * @author Nipuni punsara
 */
public class NewStudentController {

    private newStudent std;
    private StudentDao studentDao;

    public NewStudentController() {
        this.std = new newStudent();
        this.studentDao = new StudentDao();
        std.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, std.getjTextField1(), std.getjTextField4(), std.getjTextField3(), std.getjComboBox1(), std.getjComboBox2(), std);
            }
        });

        std.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt, std.getjTextField1(), std.getjTextField4(), std.getjTextField3(), std.getjComboBox1(), std.getjComboBox2(), std);
            }
        });

        std.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        std.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        showRecord();
        std.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, JTextField jTextField1, JTextField jTextField4, JTextField jTextField3, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2, newStudent std) {
        // TODO add your handling code here:
//        System.out.println("Studentid");
//        System.out.println("Name");
//        System.out.println("email");
//        System.out.println("CourseName");
//        System.out.println("BranchName");
//        String StudentID = jTextField1.getText();
//        String Name = jTextField4.getText();
//        String email = jTextField3.getText();
//        String CourseName = (String) jComboBox1.getSelectedItem();
//        String BranchName = (String) jComboBox2.getSelectedItem();
        
        Student stu = new Student();
        stu.setStudentID(jTextField1.getText());
        stu.setName(jTextField4.getText());
        stu.setEmail(jTextField3.getText());
        stu.setCourseName((String) jComboBox1.getSelectedItem());
        stu.setBranchName((String) jComboBox2.getSelectedItem());
        try {
//            Connection con = ConnectionProvider.getCon();
//            Statement st = con.createStatement();
//            st.executeUpdate("insert into student values('" + StudentID + "','" + Name + "','" + email + "','" + CourseName + "','" + BranchName + "')");
            studentDao.addstudent(stu);
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            showRecord();
//            std.setVisible(false);
//            new newStudent().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Student ID allready exist");
            std.setVisible(false);
            new newStudent().setVisible(true);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt, JTextField jTextField1, JTextField jTextField4, JTextField jTextField3, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2, newStudent std) {
        // TODO add your handling code here:
//        String StudentID = jTextField1.getText();
//        String Name = jTextField4.getText();
//        String email = jTextField3.getText();
//        String CourseName = (String) jComboBox1.getSelectedItem();
//        String BranchName = (String) jComboBox2.getSelectedItem();

        Student stu = new Student();
        stu.setStudentID(jTextField1.getText());
        stu.setName(jTextField4.getText());
        stu.setEmail(jTextField3.getText());
        stu.setCourseName((String) jComboBox1.getSelectedItem());
        stu.setBranchName((String) jComboBox2.getSelectedItem());
        
        try {
            Connection conn = ConnectionProvider.getCon();

//            String sql = "update student SET StudentID='" + StudentID + "',Name='" + Name + "',email='" + email + "',CourseName='" + CourseName + "',BranchName='" + BranchName + "' WHERE StudentID = '" + StudentID + "'";
//            PreparedStatement ptst = conn.prepareStatement(sql);
//            ptst.execute();
            studentDao.updatestudent(stu);
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        showRecord();
    }

    public void showRecord() {
        try {
//            Connection con = ConnectionProvider.getCon();
//            Statement stmt = con.createStatement();
//            String sql = "SELECT * FROM STUDENT";
             ResultSet res = studentDao.getStudents();
            std.getjTable1().setModel(DbUtils.resultSetToTableModel(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletestudent(int studentID) {
        try {
//            Connection con = ConnectionProvider.getCon();
//            String sql = "DELETE FROM STUDENT WHERE studentID=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, studentID);
//
//            ps.execute();
        studentDao.deletestudent(studentID);
            JOptionPane.showMessageDialog(null, "Successfully Deleted");

           
        } catch (Exception ex) {
            Logger.getLogger(newStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        showRecord();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int ID = Integer.parseInt(std.getjTextField1().getText());
        deletestudent(ID);
        showRecord();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        std.setVisible(false);
    }

}
