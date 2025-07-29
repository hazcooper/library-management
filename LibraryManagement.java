import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A simple library management system demonstrating basic object‑oriented
 * programming in Java.  It allows users to add books, remove books by
 * ISBN and list all books in the library.  This program does not
 * implement persistence; the library resets when the program exits.
 */
public class LibraryManagement {

    /**
     * Represents a book with a title, an author and a unique ISBN.
     */
    private static class Book {
        private final String title;
        private final String author;
        private final String isbn;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        String getTitle() {
            return title;
        }

        String getAuthor() {
            return author;
        }

        String getIsbn() {
            return isbn;
        }

        @Override
        public String toString() {
            return String.format("%s by %s (ISBN: %s)", title, author, isbn);
        }
    }

    /**
     * A library that stores a collection of books and provides methods to
     * add, remove and list them.
     */
    private static class Library {
        private final List<Book> books = new ArrayList<>();

        /**
         * Add a book to the library.  Duplicate ISBNs are not allowed.
         *
         * @param book book to add
         * @return true if the book was added, false if a book with the same
         *     ISBN already exists
         */
        boolean addBook(Book book) {
            for (Book b : books) {
                if (b.getIsbn().equals(book.getIsbn())) {
                    return false;
                }
            }
            books.add(book);
            return true;
        }

        /**
         * Remove a book from the library by its ISBN.
         *
         * @param isbn ISBN of the book to remove
         * @return true if a book was removed; false otherwise
         */
        boolean removeBook(String isbn) {
            return books.removeIf(b -> b.getIsbn().equals(isbn));
        }

        /**
         * Get a snapshot of all books in the library.
         *
         * @return list of books
         */
        List<Book> listBooks() {
            return new ArrayList<>(books);
        }
    }

    /**
     * Entry point.  Presents a menu and performs actions based on user
     * selection.
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Library Management System");
        while (running) {
            System.out.println();
            System.out.println("Please choose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. List books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine().trim();
                    System.out.print("Enter the ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    Book newBook = new Book(title, author, isbn);
                    if (library.addBook(newBook)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("A book with that ISBN already exists.");
                    }
                    break;
                case "2":
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine().trim();
                    if (library.removeBook(isbnToRemove)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("No book with that ISBN found.");
                    }
                    break;
                case "3":
                    List<Book> books = library.listBooks();
                    if (books.isEmpty()) {
                        System.out.println("The library is empty.");
                    } else {
                        System.out.println("Books in the library:");
                        for (Book b : books) {
                            System.out.println("  " + b);
                        }
                    }
                    break;
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3 or 4.");
                    break;
            }
        }
        scanner.close();
    }
}
