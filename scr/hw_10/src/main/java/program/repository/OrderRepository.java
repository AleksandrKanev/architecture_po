package program.repository;
import program.agregator.*;

import java.sql.SQLException;
import java.util.List;



public interface OrderRepository {
    Order getById(int id) throws SQLException;
    List<Order> getAll() throws SQLException;
    boolean getId(int id);
    void add(Order order) throws SQLException;
    void update(Order order);
    void delete(int id);
    void createTable();
}
