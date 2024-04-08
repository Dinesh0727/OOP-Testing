package com.testing.mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("Test OrderProcessor class")
class OrderProcessorTest {

    OrderProcessor orderProcessor;
    
    InventoryManager inventoryManager2;
    
    @Mock
    InventoryManager inventoryManager;
    
    // Difference between Mock and normal Objects - Behavior Control, Isolation, Verification, etc.

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderProcessor = new OrderProcessor(inventoryManager);
//        orderProcessor = new OrderProcessor(inventoryManager2);
    }

    @Test
    @DisplayName("Test processOrder method with available books")
    void testProcessOrderWithAvailableBooks() {
        // Arrange
        List<Book> orderedBooks = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", "ISBN1", 20.0);
        Book book2 = new Book("Book2", "Author2", "ISBN2", 25.0);
        orderedBooks.add(book1);
        orderedBooks.add(book2);
        
        System.out.println("OrderedBooks size : " + orderedBooks.size());
        Order order = new Order(1, orderedBooks);

        // Stubbing with Matchers
        when(inventoryManager.checkAvailability(any(Book.class))).thenReturn(true);
        
        // Act
       orderProcessor.processOrder(order);
        
        // Assert
        // Verify that inventory manager methods are called
        verify(inventoryManager, times(2)).checkAvailability(any(Book.class));
        assertTrue(order.getOrderedBooks().isEmpty(), "Ordered books should be removed from the order after processing");
    }

    @Test
    @DisplayName("Test processOrder method with unavailable books")
    void testProcessOrderWithUnavailableBooks() {
        // Arrange
        List<Book> orderedBooks = new ArrayList<>();
        Book book1 = new Book("Book1", "Author1", "ISBN1", 20.0);
        Book book2 = new Book("Book2", "Author2", "ISBN2", 25.0);
        orderedBooks.add(book1);
        orderedBooks.add(book2);
        Order order = new Order(1, orderedBooks);

        // Spy
        InventoryManager spyInventoryManager = spy(new InventoryManager());
        doReturn(false).when(spyInventoryManager).checkAvailability(eq(book2));

        // Act
        OrderProcessor spyOrderProcessor = spy(new OrderProcessor(spyInventoryManager));
        spyOrderProcessor.processOrder(order);

        // Assert
        // Verify that inventory manager methods are called
        verify(spyInventoryManager, times(2)).checkAvailability(any(Book.class));
        assertFalse(order.getOrderedBooks().isEmpty(), "Ordered books should remain in the order if they are unavailable");
    }
}