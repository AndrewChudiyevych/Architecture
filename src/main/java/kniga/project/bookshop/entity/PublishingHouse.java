package kniga.project.bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "publishing_house")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublishingHouse {
    @Id
    private Long id;

    private String name;

    private String language;

    private String description;

    @OneToMany//(mappedBy = "publishing_house")
    private Set<Book> books;

}
