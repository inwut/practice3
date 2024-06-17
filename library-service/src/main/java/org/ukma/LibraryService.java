package org.ukma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        books = LibraryStorage.getBooksFromFile();
    }

    public void addBook(String title, String author, int numberOfPages) {
        Book book = new Book(title, author, numberOfPages);
        books.add(book);
    }

    public Optional<Book> getBook(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }

    public void markBookAsRead(String title) {
        getBook(title).ifPresent(Book::markAsRead);
    }

    public List<Book> getReadBooks() {
        List<Book> readBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isRead()) {
                readBooks.add(book);
            }
        }
        return readBooks;
    }

    public List<Book> getBooks() {
        return books;
    }
}
