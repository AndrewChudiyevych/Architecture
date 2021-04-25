package kniga.project.bookshop.services;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.OrderMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.OrderRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.OrderStub;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kniga.project.bookshop.status.AuthorStub.getAuthorRequest;
import static kniga.project.bookshop.status.AuthorStub.getRandomAuthor;
import static kniga.project.bookshop.status.OrderStub.getOrderRequest;
import static kniga.project.bookshop.status.OrderStub.getRandomOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class OrderServiceTest {

    private  OrderService service;

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderMapper orderMapper;

    @BeforeEach
    void setup() {
        service = new OrderService(orderRepository, orderMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Order order = getRandomOrder();
        when(orderRepository.findById(any())).thenReturn(Optional.of(order));

        Order result = service.getById(OrderStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), order.getId()),
                () -> assertEquals(result.getOrderDate(), order.getOrderDate()),
                () -> assertEquals(result.getStatus(), order.getStatus()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(orderRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(OrderStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);
        Order order = getRandomOrder();
        when(orderMapper.fromRequest(any())).thenReturn(getRandomOrder());
        when(orderRepository.save(any())).thenReturn(order);
        Order result = service.create(getOrderRequest());
        Mockito.verify(orderRepository, atLeast(1)).save(captor.capture());
        assertEquals(order, captor.getValue());
        assertEquals(order.getStatus(), result.getStatus());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(OrderStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(orderRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(AuthorStub.ID, captor.getValue());
    }
}
