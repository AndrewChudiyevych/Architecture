package kniga.project.bookshop.services;


import kniga.project.bookshop.dto.GenreRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.GenreMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.GenreRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.GenreStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kniga.project.bookshop.status.AuthorStub.getAuthorRequest;
import static kniga.project.bookshop.status.AuthorStub.getRandomAuthor;
import static kniga.project.bookshop.status.GenreStub.getGenreRequest;
import static kniga.project.bookshop.status.GenreStub.getRandomGenre;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class GenreServiceTest {
    private  GenreService service;

    @Mock
    private GenreRepository genreRepository;
    @Mock
    private GenreMapper genreMapper;

    @BeforeEach
    void setup() {
        service = new GenreService(genreRepository, genreMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Genre genre = getRandomGenre();
        when(genreRepository.findById(any())).thenReturn(Optional.of(genre));

        Genre result = service.getById(GenreStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), genre.getId()),
                () -> assertEquals(result.getName(), genre.getName()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(genreRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(GenreStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Genre> captor = ArgumentCaptor.forClass(Genre.class);
        Genre genre = getRandomGenre();
        when(genreMapper.fromRequest(any())).thenReturn(getRandomGenre());
        when(genreRepository.save(any())).thenReturn(genre);
        Genre result = service.create(getGenreRequest());
        Mockito.verify(genreRepository, atLeast(1)).save(captor.capture());
        assertEquals(genre, captor.getValue());
        assertEquals(genre.getName(), result.getName());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(GenreStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(genreRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(GenreStub.ID, captor.getValue());
    }
}
