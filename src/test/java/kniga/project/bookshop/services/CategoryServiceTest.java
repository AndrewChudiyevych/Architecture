package kniga.project.bookshop.services;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.CategoryMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.CategoryRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.CategoryStub;
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
import static kniga.project.bookshop.status.CategoryStub.getCategoryRequest;
import static kniga.project.bookshop.status.CategoryStub.getRandomCategory;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CategoryServiceTest {
    private CategoryService service;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;

    @BeforeEach
    void setup() {
        service = new CategoryService(categoryRepository, categoryMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Category category = getRandomCategory();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));

        Category result = service.getById(CategoryStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), category.getId()),
                () -> assertEquals(result.getName(), category.getName()),
                () -> assertEquals(result.getGenre().size(), category.getGenre().size()),
                () -> assertEquals(result.getDescription(), category.getDescription()),
                () -> assertEquals(result.getBooks().size(), category.getBooks().size()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(CategoryStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Category> captor = ArgumentCaptor.forClass(Category.class);
        Category category = getRandomCategory();
        when(categoryMapper.fromRequest(any())).thenReturn(getRandomCategory());
        when(categoryRepository.save(any())).thenReturn(category);
        Category result = service.create(getCategoryRequest());
        Mockito.verify(categoryRepository, atLeast(1)).save(captor.capture());
        assertEquals(category, captor.getValue());
        assertEquals(category.getName(), result.getName());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(CategoryStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(categoryRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(CategoryStub.ID, captor.getValue());
    }
}
