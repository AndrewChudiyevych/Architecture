package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.entity.Author;

import java.util.HashSet;

public final class AuthorStub {

    public static final Long ID = 1L;
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String DESCRIPTION = "description";
    public static Author getRandomAuthor() {
        return Author.builder().id(ID)
                .name(NAME)
                .surname(SURNAME)
                .genre(new HashSet<>())
                .description(DESCRIPTION)
                .books(new HashSet<>())
                .build();
    }

    public static AuthorRequest getAuthorRequest() {
        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setName(NAME);
        authorRequest.setSurname(SURNAME);
        authorRequest.setDescription(DESCRIPTION);
        return authorRequest;
    }
}
