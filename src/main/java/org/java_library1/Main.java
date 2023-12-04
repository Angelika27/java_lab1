package org.java_library1;

import java.io.Console;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        while (true) {
             Scanner scanner = new Scanner(System.in);

                System.out.println("1-Показати всі книжки в бібліотеці\n2-Додати нову книгу\n3-Пошук книги\n4-Видалити книгу\n0-Вийти з програми");
                int value = scanner.nextInt();

                switch (value) {
                    case 0:
                        System.out.println("Програма завершилась:");
                        return;
                    case 1:
                        if (library.isLibraryEmpty()) {
                            System.out.println("В бібліотеці пусто:");
                        } else {
                            System.out.println("Всі книги в бібліотеці:");
                            library.displayBooks();
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Введіть назву книги:");
                        String title = scanner.nextLine();


                        System.out.println("Введіть автора книги:");
                        String author = scanner.nextLine();


                        System.out.println("Введіть ISBN книги:");
                        String isbn = scanner.next();

                        System.out.println("Введіть рік книги:");
                        int year = scanner.nextInt();

                        Book newBook = new Book(title, author, isbn, year);
                        library.addBook(newBook);
                        System.out.println("Книга додана до бібліотеки.");
                        break;
                    case 3:
                        System.out.println("Введіть назву книги, яку хочете знайти:");
                        scanner.nextLine(); // Очищення буфера після попереднього введення
                        String searchTitle = scanner.nextLine();
                        Book foundBook = library.findBookByTitle(searchTitle);
                        if (foundBook != null) {
                            System.out.println("Знайдена книга - Назва: " + foundBook.getTitle() +
                                    ", Автор: " + foundBook.getAuthor() +
                                    ", ISBN: " + foundBook.getIsbn() +
                                    ", Рік: " + foundBook.getYear());
                        } else {
                            System.out.println("Книгу з назвою '" + searchTitle + "' не знайдено.");
                        }
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Введіть ISBN книги, яку хочете видалити:");
                        String isbnToDelete = scanner.next();
                        library.removeBookByIsbn(isbnToDelete);
                        break;

                }

            }
        }

    }

