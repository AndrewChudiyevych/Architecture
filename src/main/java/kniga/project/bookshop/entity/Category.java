package kniga.project.bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "category")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
