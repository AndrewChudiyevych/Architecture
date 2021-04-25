package kniga.project.bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "genre")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    //@JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Category category;
}
