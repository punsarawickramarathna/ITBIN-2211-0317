/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nipuni punsara
 */
public class Book {
    
    private String bookID;
    private String name;
    private String publisher;
    private String price;    
    private String publisherYear;        

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(String publisherYear) {
        this.publisherYear = publisherYear;
    }

    @Override
    public String toString() {
        return "Book{" + "bookID=" + bookID + ", name=" + name + ", publisher=" + publisher + ", price=" + price + ", publisherYear=" + publisherYear + '}';
    }
    
    
        
}
