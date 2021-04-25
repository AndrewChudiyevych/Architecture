package kniga.project.bookshop.repos;

import kniga.project.bookshop.entity.Author;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AuthorRepositoryTest {
    private static final String NAME ="adad";
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        System.out.println("BEFORE EACH");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AFTEREACH");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AFTER ALL");
    }

    @Test
    void testFindAuthorByName () {
        Author expectedAuthor = Author.builder()
        .id(1L)
        .name(NAME)
        .surname("adadad")
        .genre(new HashSet<>())
        .description("aadad")
        .books(new HashSet<>())
        .build();

        entityManager.persist(expectedAuthor);
        entityManager.flush();

        Optional<Author> actualAuthor = authorRepository.findAuthorByName(NAME);
        Assertions.assertThat(actualAuthor.get()).isEqualTo(expectedAuthor);
    }

    @Test
    void testFindAuthorByNameNotSuccess() {
        Author expectedAuthor = Author.builder()
                .id(1L)
                .name(NAME)
                .surname("adadad")
                .genre(new HashSet<>())
                .description("aadad")
                .books(new HashSet<>())
                .build();
        entityManager.persist(expectedAuthor);
        entityManager.flush();

        Optional<Author> actualAuthor = authorRepository
                .findAuthorByName(NAME+"s");

        Assertions.assertThat(actualAuthor.isPresent()).isEqualTo(false);
    }
}