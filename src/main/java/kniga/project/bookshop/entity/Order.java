package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    private Book kode;

    private String orderDate;

    private String status;
}
