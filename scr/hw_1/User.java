package hw_1;


import java.util.ArrayList;
import java.util.List;

public class User {
    private Order orders;
    public Book books;
    private String name;
    private String email;
    private List<Book> orderedBooks = new ArrayList<>();

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

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void addBookToOrder(Book book) {
        orderedBooks.add(book);

    }
    public String getAuthor(Book book){
        return book.getAuthor();
    }


    public void setOrders(Order orders) {
        this.orders = orders;
    }
    public Integer getOrderId(){
        return orders.getOrderId();
    }
}
