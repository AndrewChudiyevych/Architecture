package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "author")
public class Author {
    @Id
    private Long id;

    private String name;

    private String surname;

    @OneToMany//(mappedBy = "author")
    //@JoinColumn(name = "genre_id")
    private Set<Genre> genre;

    private String description;

    @OneToMany//(mappedBy = "author")
    private Set<Book> books;
}
