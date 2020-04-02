package com.example.myfirebaseproject1;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Book {
    private String bid,bookName;
    private int price;

    public Book() {
    }

    public Book(String bid, String bookName, int price) {
        this.bid = bid;
        this.bookName = bookName;
        this.price = price;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
