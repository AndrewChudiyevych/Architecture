package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.GenreRequest;
import kniga.project.bookshop.entity.Genre;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenreMapper {
    public Genre fromRequest(GenreRequest request) {
        return Genre.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .build();
    }
}
