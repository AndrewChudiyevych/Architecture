package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.entity.Reports;

import java.util.Set;

public interface IOrderService {
    Order save(Order order);
    Order getById(Long id);
    Set<Order> getAll();
    Order edit(Order order);
    void delete(Long id);
}
