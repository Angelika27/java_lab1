package org.java_library1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize a new Library instance before each test
        library = new Library();
        book = new Book("Test Book", "Test Author", "1234567890", 2023);
    }
    @Test
    void addBook() {
        library.addBook(book);
        assertNotNull(library.findBookByTitle("Test Book"));
    }

    @Test
    void displayBooks() {

    }

    @Test
    void findBookByTitle() {

    }

    @Test
    void removeBookByIsbn() {
        library.addBook(book);
        library.removeBookByIsbn("1234567890");
        assertNull(library.findBookByTitle("Test Book"));
    }

    @Test
    void isLibraryEmpty() {
    }
}