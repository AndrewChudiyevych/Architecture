package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.OrderRequest;
import kniga.project.bookshop.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrderMapper {
    public Order fromRequest(OrderRequest request) {
        return Order.builder()
                .id(new Random().nextLong())
                .orderDate(request.getOrderDate())
                .status(request.getStatus())
                .build();
    }
}
