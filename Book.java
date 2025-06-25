public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private double price;
    private int quantity;

    // Constructor without ID (for inserting)
    public Book(String title, String author, String category, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor with ID (for displaying)
    public Book(int id, String title, String author, String category, double price, int quantity) {
        this(title, author, category, price, quantity);
        this.id = id;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
