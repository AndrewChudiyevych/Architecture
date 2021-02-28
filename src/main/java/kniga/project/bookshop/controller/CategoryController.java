package kniga.project.bookshop.controller;

import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.services.impls.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService servise;

    @GetMapping("/")
    public Set<Category> getAllCategories(@RequestParam(required = false, defaultValue = "10") Integer size,
                                          @RequestParam(required = false, defaultValue = "1") Integer page) {
        return servise.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id) {

        return servise.getById(id);
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) {

        return servise.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable long id, @RequestBody Category category) {

        return servise.edit(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(long id) {
        servise.delete(id);
    }

    @GetMapping("/{category_id}/genres")
    public List<Genre> getGenresByCategory(@PathVariable long category_id) {
        return null;
    }

    @GetMapping("/{category_id}/books")
    public List<Book> getBooksByCategory(@PathVariable long category_id) {
        return null;
    }
}
