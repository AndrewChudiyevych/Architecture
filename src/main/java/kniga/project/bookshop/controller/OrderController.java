package kniga.project.bookshop.controller;


import kniga.project.bookshop.dto.OrderRequest;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService servise;

    @GetMapping("/")
    public Set<Order> getAllOrders(@RequestParam(required = false, defaultValue = "10") Integer size,
                                   @RequestParam(required = false, defaultValue = "1") Integer page) {
        return servise.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {
        return servise.getById(id);
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody OrderRequest request) {
        return servise.create(request);
        //return servise.save(order);
    }

    @PutMapping("/edit/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody Order order) {

        return servise.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(long id) {
        servise.delete(id);
    }

    @GetMapping("/{order_id}/books")
    public List<Book> getBooksByOrder(@PathVariable long order_id) {
        return null;
    }
}
