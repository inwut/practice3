package org.ukma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryStorage {

    private final static String PATH_TO_FILE = "C:\\Users\\Lenovo\\Desktop\\automation\\practice3\\library-storage\\src\\main\\resources\\storage.txt";

    public static void saveBooksToFile(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_TO_FILE))) {
            oos.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Book> getBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_TO_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                books = (List<Book>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
