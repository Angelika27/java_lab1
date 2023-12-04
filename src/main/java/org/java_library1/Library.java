package org.java_library1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Назва: " + book.getTitle() +
                    ", Автор: " + book.getAuthor() +
                    ", ISBN: " + book.getIsbn() +
                    ", Рік: " + book.getYear());
        }
    }


    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Книга з таким ISBN " + isbn + " видалена.");
        } else {
            System.out.println("Книга з таким ISBN " + isbn + " не знайдена.");
        }
    }

    public boolean isLibraryEmpty(){
        return books.size() == 0;
    }
}
