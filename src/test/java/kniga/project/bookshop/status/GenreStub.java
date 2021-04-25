package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.GenreRequest;
import kniga.project.bookshop.entity.Genre;

import javax.print.attribute.standard.MediaSize;
import java.util.Random;

public class GenreStub {

    public static final Long ID = 1L;
    public static final String NAME = "adada";

    public static Genre getRandomGenre() {
        return Genre.builder()
                .id(ID)
                .name(NAME)
                .build();
    }

    public static GenreRequest getGenreRequest() {
        GenreRequest genreRequest = new GenreRequest();
        genreRequest.setName(NAME);
        return genreRequest;
    }
}
