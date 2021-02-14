package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "genre")
public class Genre {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn//(name = "author_id")
    private Author author;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Category category;
}
