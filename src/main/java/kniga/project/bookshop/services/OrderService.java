package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.OrderRequest;
import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.OrderMapper;
import kniga.project.bookshop.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;


    public Order save(Order order) {
        return repository.save(order);
    }


    public Order getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Order> getAll() {
        List<Order> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Order update(Long id, Order order) {
        Order order1 = repository.findById(id).orElseThrow(null);
        order1 = order;
        return repository.save(order1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Order create(OrderRequest request) {
        var order = mapper.fromRequest(request);
        return repository.save(order);
    }
}
