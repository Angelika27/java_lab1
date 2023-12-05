package org.java_library1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.BooleanSupplier;

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
        library.addBook(book);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));


        library.displayBooks();


        System.setOut(originalOut);

        assertTrue(outContent.toString().contains(book.getTitle()));
        assertTrue(outContent.toString().contains(book.getAuthor()));
        assertTrue(outContent.toString().contains(book.getIsbn()));
        assertTrue(outContent.toString().contains(String.valueOf(book.getYear())));
    }


    @Test
    void findBookByTitle() {
        library.addBook(book);
        assertEquals(book, library.findBookByTitle("Test Book"));
        assertNull(library.findBookByTitle("Non-existing Book"));
    }

    @Test
    void removeBookByIsbn() {
        library.addBook(book);
        library.removeBookByIsbn("1234567890");
        assertNull(library.findBookByTitle("Test Book"));
    }

    @Test
    void isLibraryEmpty() {

        assertTrue(library.isLibraryEmpty());
        library.addBook(book);
        assertFalse(library.isLibraryEmpty());
    }
}