package program.cache;

import program.agregator.Order;
import program.repository.OrderRepository;
import program.repository.OrderRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Integer, Order> cache = new HashMap<>();

    /**
     * Получить продукт из кэша или основного списка.
     *
     * @param id ID продукта.
     * @param repo база данных.
     * @return Продукт из кэша или null, если продукт не найден.
     */
    public Order getOrder(int id, OrderRepository repo) throws SQLException {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            if (repo.getById(id)!= null) {
                Order order = repo.getById(id);
                cache.put(id,order);
                return order;
            }

            return null;
        }
    }

}
