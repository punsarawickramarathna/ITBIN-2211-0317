/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.Login;
import view.home;

/**
 *
 * @author Nipuni punsara
 */
public class LoginController {

    public LoginController() {
        Login login = new Login();
        login.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCloseClick(evt);
            }
        });

        login.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, login.getjTextField1(), login.getjPasswordField1(), login);

            }
        });

        login.setVisible(true);

    }

    private void onCloseClick(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, JTextField username, JPasswordField password, Login login) {
        // TODO add your handling code here:
//        System.out.println(username);
//        System.out.println(password);
        if (username.getText().equals("admin") && password.getText().equals("2222")) {
            login.setVisible(false);
            new HomeController();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
    }

}
