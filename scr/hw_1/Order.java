package hw_1;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Order{
    private User users;
    private Integer orderId;
    private Data orderData;
    private final List<Book> orderedBooks = new ArrayList<>();

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Data getOrderData() {
        return orderData;
    }

    public void setOrderData(Data orderData) {
        this.orderData = orderData;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void addBookToOrder(Book books) {
        orderedBooks.add(books);
    }


    public String getUsers() {
        return users.getName();
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
