package org.ukma;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class Book implements Serializable {
    private String title;
    private String author;
    private int numberOfPages;
    private boolean isRead;

    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.isRead = false;
    }

    public void markAsRead() {
        this.isRead = true;
    }

}
