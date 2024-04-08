package com.testing.mockito;

import java.util.Iterator;
import java.util.List;

import com.testing.mockito.*;

public class OrderProcessor {
    private InventoryManager inventoryManager;

    public OrderProcessor(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    // Method to process orders
    public void processOrder(Order order) {
        List<Book> books = order.getOrderedBooks();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (inventoryManager.checkAvailability(book)) {
                inventoryManager.removeBook(book);
                iterator.remove(); 
                System.out.println("Processing order for book: " + book.getTitle());
            } else {
                System.out.println("Book " + book.getTitle() + " is not available.");
            }
        }
        order.setOrderedBooks(books);
    }
}
