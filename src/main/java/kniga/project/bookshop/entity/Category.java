package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "category")
public class Category {
    @Id
    private Long id;

    private String name;

    @OneToMany//(mappedBy = "category")
    private Set<Genre> genre;

    private String description;

    @OneToMany//(mappedBy = "category")
    private Set<Book> books;
}
