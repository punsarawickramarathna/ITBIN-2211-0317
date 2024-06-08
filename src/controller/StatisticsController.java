/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import view.Statistics;

/**
 *
 * @author Nipuni punsara
 */
public class StatisticsController {

    private Statistics stc;
    private StatisticsDao statisticsDao;

    public StatisticsController() {
        this.stc = new Statistics();
        this.statisticsDao = new StatisticsDao();
        stc.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        stc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        stc.setVisible(true);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        stc.setVisible(false);
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        // TODO add your handling code here:
        try {
//            Connection con = ConnectionProvider.getCon();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='NO'");
            ResultSet rs = statisticsDao.getissuedetails();
            stc.getjTable1().setModel(DbUtils.resultSetToTableModel(rs));
//            ResultSet rs1 = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='YES'");
             ResultSet rs1 = statisticsDao.getreturndetails();
             stc.getjTable2().setModel(DbUtils.resultSetToTableModel(rs1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error");
        }
    }

//    private void formComponentShown(java.awt.event.ComponentEvent evt) {
//        // TODO add your handling code here:
//        try {
//            Connection con = ConnectionProvider.getCon();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='NO'");
//            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//            ResultSet rs1 = st.executeQuery("select issue.bookID,book.name,issue.StudentID,student.name,issue.issueDate,issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.StudentID=issue.StudentID and issue.returnBook='YES'");
//            jTable2.setModel(DbUtils.resultSetToTableModel(rs1));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Connection error");
//        }
//    }
}
