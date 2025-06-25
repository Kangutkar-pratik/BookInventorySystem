import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n--- Book Inventory Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Book book = new Book(title, author, category, price, quantity);
                    dao.addBook(book);
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    System.out.println("\n--- Book List ---");
                    for (Book b : books) {
                        System.out.println("ID: " + b.getId() +
                                " | Title: " + b.getTitle() +
                                " | Author: " + b.getAuthor() +
                                " | Category: " + b.getCategory() +
                                " | Price: ₹" + b.getPrice() +
                                " | Qty: " + b.getQuantity());
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteBookById(id);
                    break;

                case 4:
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

