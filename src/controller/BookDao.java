/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Book;
import Project1.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Nipuni punsara
 */
public class BookDao {

    private Connection con;

    public BookDao() {
        this.con = ConnectionProvider.getCon();
    }

    public void addBook(Book book) throws Exception {
        Statement st = con.createStatement();
        st.executeUpdate("insert into book values('" + book.getBookID() + "','" + book.getName() + "','" + book.getPublisher() + "','" + book.getPrice() + "','" + book.getPublisherYear() + "')");
        JOptionPane.showMessageDialog(null, "Successfully Saved");
    }

    public void updateBook(Book book) throws Exception {
        System.out.println();
        Statement st = con.createStatement();
        String sql = "update book SET bookID='" + book.getBookID() + "',name='" + book.getName() + "',publisher='" + book.getPublisher() + "',price='" + book.getPrice() + "',publisherYear='" + book.getPublisherYear() + "' WHERE bookID = '" + book.getBookID() + "'";
        PreparedStatement ptst = con.prepareStatement(sql);
        ptst.execute();

        JOptionPane.showMessageDialog(null, "Updated Successfully!");
    }

    public void deleteBook(int bookID) throws Exception {
        Statement st = con.createStatement();
        String sql = "DELETE FROM BOOK WHERE bookID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bookID);

        ps.execute();
    }

    public ResultSet getBooks() throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM BOOK";
        ResultSet res = stmt.executeQuery(sql);
        return res;
    }
}
