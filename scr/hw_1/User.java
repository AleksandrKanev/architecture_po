package hw_1;


import java.util.ArrayList;
import java.util.List;

public class User {
    private Order orders;
    public Book books;
    private String name;
    private String email;
    private List<Order> orderedBooks;

    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.orderedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderedBooks() {
        return orderedBooks;
    }

    public void addBookToOrder(Order orders) {
        orderedBooks.add(orders);

    }

}
