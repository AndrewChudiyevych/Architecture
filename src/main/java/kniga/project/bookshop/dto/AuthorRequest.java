package kniga.project.bookshop.dto;

import lombok.Data;

@Data
public class AuthorRequest {
    private String name;

    private String surname;

    private String description;
}
