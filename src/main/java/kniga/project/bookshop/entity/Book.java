package kniga.project.bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

@Data
@Entity(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Long id;

    @OneToMany//(mappedBy = "book")
    //@JoinColumn(name = "order_id")
    private Set<Order> orders;

    private String bookName;

    @ManyToOne
    //@JoinColumn(name = "category_id")
    private Category category;

    @OneToMany//(mappedBy = "book")
    //@JoinColumn(name = "genre_id")
    private Set<Genre> genre;

    private String language;

    @ManyToOne
    //@JoinColumn(name = "publishHouse_id")
    private PublishingHouse publishingHouse;

    private double price;

    private String dateOfAiring;

    private int pages;

    @ManyToOne
    //@JoinColumn(name = "author_id")
    private Author author;

    private boolean inStock;

    @OneToMany//(mappedBy = "book")
    //@JoinColumn(name = "report_id")
    private Set<Reports> reports;

}
