/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Book;
import Project1.ConnectionProvider;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import view.newBook;

/**
 *
 * @author Nipuni punsara
 */
public class NewBookController {

    private newBook book;
    private BookDao bookDao;

    public NewBookController() {
        this.book = new newBook();
        this.bookDao = new BookDao();
        book.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, book.getjTextField1(), book.getjTextField2(), book.getjTextField3(), book.getjTextField4(), book.getjTextField5(), book);
            }
        });

        book.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        book.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        book.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        showRecord();
        book.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, newBook book) {
        // TODO add your handling code here:
//        String bookID = jTextField1.getText();
//        String name = jTextField2.getText();
//        String publisher = jTextField3.getText();
//        String price = jTextField4.getText();
//        String publisherYear = jTextField5.getText();

        Book bk = new Book();
        bk.setBookID(jTextField1.getText());
        bk.setName(jTextField2.getText());
        bk.setPublisher(jTextField3.getText());
        bk.setPrice(jTextField4.getText());
        bk.setPublisherYear(jTextField5.getText());

        try {
            bookDao.addBook(bk);
            showRecord();
//            setVisible(false);
//            new newBook().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Book ID already exist");
            book.setVisible(false);
            new newBook().setVisible(true);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
//        String bookID = book.getjTextField1().getText();
//        String name = book.getjTextField2().getText();
//        String publisher = book.getjTextField3().getText();
//        String price = book.getjTextField4().getText();
//        String publisherYear = book.getjTextField5().getText();

        Book bk = new Book();
        bk.setBookID(book.getjTextField1().getText());
        bk.setName(book.getjTextField2().getText());
        bk.setPublisher(book.getjTextField3().getText());
        bk.setPrice(book.getjTextField4().getText());
        bk.setPublisherYear(book.getjTextField5().getText());

        try {
            bookDao.updateBook(bk);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        showRecord();
    }

    public void showRecord() {
        try {
//            Connection con = ConnectionProvider.getCon();
//            Statement stmt = con.createStatement();
//            String sql = "SELECT * FROM BOOK";
//            ResultSet res = stmt.executeQuery(sql);
//            book.getjTable1().setModel(DbUtils.resultSetToTableModel(res));

            ResultSet res = bookDao.getBooks();
            book.getjTable1().setModel(DbUtils.resultSetToTableModel(res));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletebook(int bookID) {
        try {
//            Connection con = ConnectionProvider.getCon();
//            String sql = "DELETE FROM BOOK WHERE bookID=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, bookID);
//
//            ps.execute();
            bookDao.deleteBook(bookID);
            JOptionPane.showMessageDialog(null, "Successfully Deleted");

            
        } catch (Exception ex) {
            Logger.getLogger(newBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        showRecord();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int ID = Integer.parseInt(book.getjTextField1().getText());
        deletebook(ID);
        showRecord();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        book.setVisible(false);
    }

}
