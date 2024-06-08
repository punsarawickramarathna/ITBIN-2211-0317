/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Nipuni punsara
 */
public class Issue {
    SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-YYYY");
    private String bookID;
    private String StudentID;
    private String issueDate;
    private String dueDate;
    private String returnBook="NO";

    public SimpleDateFormat getdFormat() {
        return dFormat;
    }

    public void setdFormat(SimpleDateFormat dFormat) {
        this.dFormat = dFormat;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(String returnBook) {
        this.returnBook = returnBook;
    }
            
            
       
}
