import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, category, price, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setDouble(4, book.getPrice());
            stmt.setInt(5, book.getQuantity());

            stmt.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding book.");
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                );
                books.add(book);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving books.");
            e.printStackTrace();
        }

        return books;
    }

    public void deleteBookById(int id) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting book.");
            e.printStackTrace();
        }
    }
}
