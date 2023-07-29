package hw_1;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order{
    private static int count = 1;
    private Integer orderId;
    private Date orderData;
    private  List<Book> orderedBooks;

    public Order(){
        this.orderId = count;
        count++;
        this.orderData = new Date();
        this.orderedBooks = new ArrayList<Book>();
    }



    public Integer getOrderId() {
        return orderId;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void addBookToOrder(Book books) {
        orderedBooks.add(books);
    }

    public Date getOrderData() {
        return orderData;
    }
}
