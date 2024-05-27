package Task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }


    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Library {
    private List<Book> books;
    private List<String> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(String user) {
        users.add(user);
    }

    public List<Book> searchBooks(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean issueBook(String title, String user) {
        if (!users.contains(user)) {
            System.out.println("User not found!");
            return false;
        }
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued to " + user);
                return true;
            }
        }
        System.out.println("Book not available!");
        return false;
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Task4{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Search Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case "2":
                    System.out.print("Enter user name: ");
                    String user = scanner.nextLine();
                    library.addUser(user);
                    break;
                case "3":
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    List<Book> foundBooks = library.searchBooks(title);
                    for (Book book : foundBooks) {
                        System.out.println(book);
                    }
                    break;
                case "4":
                    System.out.print("Enter book title to issue: ");
                    title = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    user = scanner.nextLine();
                    library.issueBook(title, user);
                    break;
                case "5":
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case "6":
                    library.displayBooks();
                    break;
                case "7":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

