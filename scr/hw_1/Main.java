package hw_1;



public class Main {
    public static void main(String[] args) {
        User us = new User();
        us.setName("123");
        Book book = new Book();
        book.setAuthor("12300");
        Order order = new Order();
        order.setOrderId(120);
        us.setOrders(order);
        order.setUsers(us);
        order.addBookToOrder(book);
        us.addBookToOrder(book);
        book.setUsers(us);
        System.out.println(order.getUsers());
        System.out.println(us.getOrderId());
        for (Book b: order.getOrderedBooks()) {
            System.out.println(b.users.getName());
        }


        System.out.println(book.getName());

    }
}
