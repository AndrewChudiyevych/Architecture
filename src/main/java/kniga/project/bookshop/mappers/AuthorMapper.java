package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.entity.Author;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;

@Component
public class AuthorMapper {
    public Author fromRequest(AuthorRequest request) {
        return Author.builder()
                //.id(new Random().nextLong())
                .name(request.getName())
                .surname(request.getSurname())
                .genre(new HashSet<>())
                .description(request.getDescription())
                .books(new HashSet<>())
                .build();
    }
}
