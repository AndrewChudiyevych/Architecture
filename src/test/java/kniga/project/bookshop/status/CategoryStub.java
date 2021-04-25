package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.BookRequest;
import kniga.project.bookshop.dto.CategoryRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Category;

import java.util.HashSet;

public class CategoryStub {

    public static final Long ID = 1L;
    public static final String NAME = "adad";
    public static final String DESCRIPTION = "adad";

    public static Category getRandomCategory() {
        return Category.builder()
                .id(ID)
                .name(NAME)
                .genre(new HashSet<>())
                .description(DESCRIPTION)
                .books(new HashSet<>())
                .build();
    }

    public static CategoryRequest getCategoryRequest() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setName(NAME);
        categoryRequest.setDescription(DESCRIPTION);
        return categoryRequest;
    }
}
