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
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nipuni punsara
 */
public class ReturnDao {

    private Connection con;

    public ReturnDao() {
        this.con = ConnectionProvider.getCon();
    }

    public ResultSet addreturn(Return ret) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select *from issue where bookID='" + ret.getBookID() + "' and studentID='" + ret.getStudentID() + "'");
        return rs;
    }
}
     
