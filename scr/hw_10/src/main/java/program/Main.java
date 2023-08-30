package program;

/**Этот класс Main является точкой входа в программу.
 * Он создает объекты различных классов
 * (OrderRepository, OrderService, Product, Order, OrderItem)
 * и демонстрирует, как они взаимодействуют в рамках паттерна
 * "Агрегатор". Создается заказ, добавляется в него товар,
 * сохраняется с использованием сервиса заказов,
 * а затем выводится последний сохраненный заказ с помощью репозитория.*/

import program.agregator.*;
import program.cache.Cache;
import program.repository.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        String connectionString = "jdbc:sqlite:products.db";
//        ProductRepository productRepository = new SQLiteProductRepository(connectionString);
//
//// Создаем таблицу "products" при запуске
//        productRepository.createTable();
//
//// Создаем продукт
//        Product newProduct = new Product(1, "Новый продукт", 19.99);
//
//// Добавляем продукт в базу данных
//        productRepository.add(newProduct);
//
//// Получаем продукт по ID
//        Product retrievedProduct = productRepository.getById(1);
//        if (retrievedProduct != null) {
//            System.out.println("Получен продукт: " + retrievedProduct.getName());
//        }
//
//// Получаем все продукты
//        List<Product> allProducts = productRepository.getAll();
//        for (Product product : allProducts) {
//            System.out.println("Продукт: " + product.getName());
//        }
//    }
//}
public class Main {

    public static void main(String[] args) {
        try {
            // Инициализация репозитория и базы данных.
            OrderRepository repo = new OrderRepositoryImpl("jdbc:sqlite:orders.db");
            repo.createTable();

            Cache cache = new Cache();
            // Создание и инициализация продукта.
            Product book = new Product(1, "Книга", 10.0);
            Product book2 = new Product(2, "Книга", 15.0);
            Product book3 = new Product(3, "Книга", 16.0);

            // Создание нового заказа.
            Order order = new Order();
            Order order2 = new Order();

            // Добавление продукта в заказ.
            OrderItem orderItem = new OrderItem(book, 2);
            OrderItem orderItem2 = new OrderItem(book2, 1);
            OrderItem orderItem3 = new OrderItem(book3, 3);
            order.addItem(orderItem);
            order.addItem(orderItem2);
            order.addItem(orderItem3);
            order2.addItem(orderItem2);

            repo.add(order);
            repo.add(order2);



            Order order1 = cache.getOrder(1, repo);
            System.out.println(order1.toString());
            System.out.println(cache.getOrder(2,repo).toString());

        } catch (SQLException e) {
            // Обработка исключений, связанных с работой базы данных.
            e.printStackTrace();
        }
    }
}