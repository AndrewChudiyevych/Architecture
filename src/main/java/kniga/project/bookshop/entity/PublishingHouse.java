package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "publishing_house")
public class PublishingHouse {
    @Id
    private Long id;

    private String name;

    private String language;

    private String description;

    @OneToMany//(mappedBy = "publishing_house")
    private Set<Book> books;
}
