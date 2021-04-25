package kniga.project.bookshop.services;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.BookMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.BookRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.BookStub;
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
import static kniga.project.bookshop.status.BookStub.getBookRequest;
import static kniga.project.bookshop.status.BookStub.getRandomBook;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class BookServiceTest {
    private  BookServise service;

    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper bookMapper;

    @BeforeEach
    void setup() {
        service = new BookServise(bookRepository, bookMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Book book = getRandomBook();
        when(bookRepository.findById(any())).thenReturn(Optional.of(book));

        Book result = service.getById(BookStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), book.getId()),
                () -> assertEquals(result.getOrders().size(), book.getOrders().size()),
                () -> assertEquals(result.getBookName(), book.getBookName()),
                () -> assertEquals(result.getCategory(), book.getCategory()),
                () -> assertEquals(result.getGenre().size(), book.getGenre().size()),
                () -> assertEquals(result.getLanguage(), book.getLanguage()),
                () -> assertEquals(result.getPublishingHouse(), book.getPublishingHouse()),
                () -> assertEquals(result.getPrice(), book.getPrice()),
                () -> assertEquals(result.getDateOfAiring(), book.getDateOfAiring()),
                () -> assertEquals(result.getPages(), book.getPages()),
                () -> assertEquals(result.getAuthor(), book.getAuthor()),
                () -> assertEquals(result.getReports().size(), book.getReports().size()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(bookRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(BookStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Book> captor = ArgumentCaptor.forClass(Book.class);
        Book book = getRandomBook();
        when(bookMapper.fromRequest(any())).thenReturn(getRandomBook());
        when(bookRepository.save(any())).thenReturn(book);
        Book result = service.create(getBookRequest());
        Mockito.verify(bookRepository, atLeast(1)).save(captor.capture());
        assertEquals(book, captor.getValue());
        assertEquals(book.getBookName(), result.getBookName());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(BookStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(bookRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(AuthorStub.ID, captor.getValue());
    }
}
