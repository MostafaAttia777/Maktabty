package com.Maktaba.MyBooks;

public class Requests {

    String book_name;
    String book_authoer;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_authoer() {
        return book_authoer;
    }

    public void setBook_authoer(String book_authoer) {
        this.book_authoer = book_authoer;
    }

    public String getBook_link() {
        return book_link;
    }

    public void setBook_link(String book_link) {
        this.book_link = book_link;
    }

    public Requests(String book_name, String book_authoer, String book_link) {
        this.book_name = book_name;
        this.book_authoer = book_authoer;
        this.book_link = book_link;
    }

    String book_link;
}
