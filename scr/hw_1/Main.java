package hw_1;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("123", "13");
        Book b2 = new Book("122", "3");
        Book b3 = new Book("11", "1");
        
        User us = new User("ds", "dfs");
        Order order = new Order();
        Order order1 = new Order();
        order.addBookToOrder(b1);
        order.addBookToOrder(b3);
        order1.addBookToOrder(b2);
        us.addBookToOrder(order);
        us.addBookToOrder(order1);
        for (Order o: us.getOrderedBooks()) {
            for (Book b: o.getOrderedBooks()) {
                System.out.println(b.getAuthor());
                System.out.println(o.getOrderId());
            }

        }

    }
}
