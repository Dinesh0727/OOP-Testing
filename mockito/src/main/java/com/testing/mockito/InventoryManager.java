package com.testing.mockito;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Book> booksInStock;

    public InventoryManager() {
        this.booksInStock = new ArrayList<>();
    }

    // Methods to add, remove, and update books in inventory
    public void addBook(Book book) {
        booksInStock.add(book);
    }

    public void removeBook(Book book) {
        booksInStock.remove(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = booksInStock.indexOf(oldBook);
        if (index != -1) {
            booksInStock.set(index, newBook);
        }
    }

    public boolean checkAvailability(Book book) {
        return booksInStock.contains(book);
    }
}
