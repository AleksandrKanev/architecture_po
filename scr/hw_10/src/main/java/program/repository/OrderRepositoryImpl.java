package program.repository;

import program.agregator.Order;
import program.agregator.OrderItem;
import program.agregator.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private Connection connection;

    public OrderRepositoryImpl(String connectionString) {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM orders");
            ResultSet rs = statement.executeQuery();
            rs.toString();
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                    return true;
                }

            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order getById(int id) throws SQLException {
        if (getId(id)) {
            List<OrderItem> orderItems = new ArrayList<>();
            Order order = new Order();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_items WHERE orderId=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = null;
                Product product = null;
                int quantity = rs.getInt("quantity");

                PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE id=?");
                statement.setInt(1, rs.getInt("productId"));
                ResultSet productRs = statement.executeQuery();
                while (productRs.next()) {
                    product = new Product(productRs.getInt("id"),productRs.getString("name"),
                            productRs.getDouble("price"));
//                    product.setId(productRs.getInt("id"));
//                    product.setName(productRs.getString("name"));
//                    product.setPrice(productRs.getDouble("price"));
                }
                orderItem = new OrderItem(product,quantity);
                orderItems.add(orderItem);

            }
            connection.commit();
            connection.setAutoCommit(true);
            order.setItems(orderItems);
            return order;

        }

        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public void add(Order order) throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement orderStmt = connection.prepareStatement("INSERT INTO orders(totalAmount) VALUES (?)");
        orderStmt.setDouble(1, order.getTotalPrice());
        orderStmt.executeUpdate();
        ResultSet generatedKeys = orderStmt.getGeneratedKeys();
        int orderId = generatedKeys.getInt(1);
        generatedKeys.close();
        orderStmt.close();

        // Вставка данных о элементах заказа в таблицу элементов заказа
        PreparedStatement itemStmt = connection.prepareStatement("INSERT INTO order_items(orderId, productId, quantity) VALUES (?, ?, ?)");
        for (OrderItem item : order.getItems()) {
            itemStmt.setInt(1, orderId);
            itemStmt.setInt(2, item.getProduct().getId());
            itemStmt.setInt(3, item.getQuantity());
            itemStmt.executeUpdate();
        }
        itemStmt.close();

        PreparedStatement productStmt = connection.prepareStatement("INSERT INTO products(id, name, price) VALUES (?, ?, ?)");
        for (OrderItem item : order.getItems()) {
            productStmt.setInt(1, item.getProduct().getId());
            productStmt.setString(2, item.getProduct().getName());
            productStmt.setDouble(3, item.getProduct().getPrice());
            productStmt.executeUpdate();
        }
        productStmt.close();


        connection.commit();
        connection.setAutoCommit(true);

    }

    @Override
    public void update(Order order) {


    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, price REAL)");
            // Создание таблицы заказов, если она еще не создана
            statement.execute("CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT, totalAmount REAL)");
            // Создание таблицы элементов заказа, если она еще не создана
            statement.execute("CREATE TABLE IF NOT EXISTS order_items (orderId INTEGER, productId INTEGER, quantity INTEGER)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
