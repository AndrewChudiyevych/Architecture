package kniga.project.bookshop.services;

import com.sun.xml.bind.v2.model.core.ID;
import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.status.AuthorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import static kniga.project.bookshop.status.AuthorStub.getAuthorRequest;
import static kniga.project.bookshop.status.AuthorStub.getRandomAuthor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class AuthorServiceTest {

    private  AuthorService service;

    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private AuthorMapper authorMapper;

    @BeforeEach
    void setup() {
        service = new AuthorService(authorRepository, authorMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Author author = AuthorStub.getRandomAuthor();
        when(authorRepository.findById(any())).thenReturn(Optional.of(author));

        Author result = service.getById(AuthorStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), author.getId()),
                () -> assertEquals(result.getName(), author.getName()),
                () -> assertEquals(result.getSurname(), author.getSurname()),
                () -> assertEquals(result.getGenre().size(), author.getGenre().size()),
                () -> assertEquals(result.getDescription(), author.getDescription()),
                () -> assertEquals(result.getBooks().size(), author.getBooks().size()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(authorRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(AuthorStub.ID));
        assertEquals(e.getMessage(), null);
    }


    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Author> captor = ArgumentCaptor.forClass(Author.class);
        Author author = getRandomAuthor();
        when(authorMapper.fromRequest(any())).thenReturn(getRandomAuthor());
        when(authorRepository.save(any())).thenReturn(author);
        Author result = service.create(getAuthorRequest());
        Mockito.verify(authorRepository, atLeast(1)).save(captor.capture());
        assertEquals(author, captor.getValue());
        assertEquals(author.getName(), result.getName());
    }


    @Test
    void testSccessfulDelete() {
        service.delete(AuthorStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(authorRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(AuthorStub.ID, captor.getValue());
    }
}