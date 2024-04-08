package com.testing.mockito;
import java.util.List;

public class Order {
    private int orderId;
    private List<Book> orderedBooks;

    public Order(int orderId, List<Book> orderedBooks) {
        this.orderId = orderId;
        this.orderedBooks = orderedBooks;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<Book> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }
}
