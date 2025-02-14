import java.util.ArrayList;
import java.util.Scanner;

public class viva2Q3 {
    private static ArrayList<Book> books = new ArrayList<>(); // List to store books
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display menu
            System.out.println("\nBook Management System");
            System.out.println("1. Add a book");
            System.out.println("2. View a book's details");
            System.out.println("3. View all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBookDetails();
                    break;
                case 3:
                    viewAllBooks();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a new book
    private static void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Method to view details of a specific book
    private static void viewBookDetails() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Method to view all books
    private static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nList of all books:");
        for (Book book : books) {
            book.displayDetails();
            System.out.println("-------------------");
        }
    }
}

class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
