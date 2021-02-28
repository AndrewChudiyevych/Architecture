package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.repos.CategoryRepository;
import kniga.project.bookshop.repos.OrderRepository;
import kniga.project.bookshop.services.interfaces.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Order> getAll() {
        List<Order> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Order edit(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
