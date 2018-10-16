package com.gaoxiong.springboot02amqp.bean;

import java.io.Serializable;

/**
 * @author gaoxiong
 * @ClassName Book
 * @Description TODO
 * @date 2018/10/16 23:18
 */

public class Book implements Serializable {
    private static final long serialVersionUID = -7138275601924204266L;
    private String bookName;
    private String author;

    public String getBookName () {
        return bookName;
    }

    public void setBookName ( String bookName ) {
        this.bookName = bookName;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor ( String author ) {
        this.author = author;
    }

    @Override
    public String toString () {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book ( String bookName, String author ) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book () {
    }
}
