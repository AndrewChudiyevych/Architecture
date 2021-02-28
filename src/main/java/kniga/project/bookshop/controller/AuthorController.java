package kniga.project.bookshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.services.impls.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/authors")
@Api(value = "Author controller")
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/")
    public Set<Author> getAllAuthors(@RequestParam(required = false, defaultValue = "10") Integer size,
                                     @RequestParam(required = false, defaultValue = "1") Integer page) {
        return service.getAll();
    }

    @ApiOperation(value = "Get by Id", notes = "This method is Get by Id")
    @GetMapping("/{id}")
    @ApiResponse(code = 200, message = "Successful get by id")
    public Author getAuthorById(@ApiParam(
            name = "id",
            value = "id of needed author",
            required = true
    ) @PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Author createAuthor(@RequestBody Author author) {

        return service.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author author) {

        return service.edit(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(long id) {
        service.delete(id);
    }

    @GetMapping("/{author_id}/genres")
    public List<Genre> getGenresByAuthor(@PathVariable long author_id) {
        return null;
    }

    @GetMapping("/{author_id}/books")
    public List<Book> getBooksByAuthor(@PathVariable long author_id) {
        return null;
    }
}
