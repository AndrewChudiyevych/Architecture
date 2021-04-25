package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.OrderRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Order;

import java.util.HashSet;
import java.util.Random;

public class OrderStub {

    public static final Long ID = 1L;
    public static final String DATE = "adad";
    public static final String STATUS = "adada";

    public static Order getRandomOrder() {
        return Order.builder()
                .id(ID)
                .orderDate(DATE)
                .status(STATUS)
                .build();
    }

    public static OrderRequest getOrderRequest() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderDate(DATE);
        orderRequest.setStatus(STATUS);
        return orderRequest;
    }
}
