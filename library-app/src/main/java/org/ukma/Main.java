package org.ukma;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        libraryService.addBook("The Little Prince", "Antoine de Saint-Exupéry", 128);

        libraryService.markBookAsRead("1984");

        System.out.println("All books:");
        for (Book book : libraryService.getBooks()) {
            System.out.println(book);
        }

        List<Book> readBooks = libraryService.getReadBooks();
        System.out.println("Read books:");
        for (Book book : readBooks) {
            System.out.println(book);
        }
    }
}