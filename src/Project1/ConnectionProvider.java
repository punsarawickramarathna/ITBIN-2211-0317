/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Nipuni punsara
 */
public class ConnectionProvider {
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/LibraryManagementSystem","root","N199910@p");
            return con;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
