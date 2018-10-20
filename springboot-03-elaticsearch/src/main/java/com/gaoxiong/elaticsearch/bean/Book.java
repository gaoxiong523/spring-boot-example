package com.gaoxiong.elaticsearch.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author gaoxiong
 * @ClassName Book
 * @Description TODO
 * @date 2018/10/18 22:25
 */
@Document(indexName = "gaoxiong",type = "book",createIndex = true)
public class Book {
    private Integer id;
    private String bookName;
    private String author;

    @Override
    public String toString () {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

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
}
