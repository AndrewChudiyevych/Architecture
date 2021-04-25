package kniga.project.bookshop.controller;

import kniga.project.bookshop.dto.GenreRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/genres")
public class GenreController {

    private final GenreService servise;

    @GetMapping("/")
    public Set<Genre> getAllGenres(@RequestParam(required = false, defaultValue = "10") Integer size,
                                   @RequestParam(required = false, defaultValue = "1") Integer page) {
        return servise.getAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable long id) {

        return servise.getById(id);
    }

    @PostMapping("/")
    public Genre createGenre(@RequestBody GenreRequest request) {
        return servise.create(request);
        //return servise.save(genre);
    }

    @PutMapping("/edit/{id}")
    public Genre updateGenre(@PathVariable long id, @RequestBody Genre genre) {

        return servise.update(id, genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(long id) {
        servise.delete(id);
    }

    @GetMapping("/{genre_id}/authors")
    public List<Author> getAuthorsByGenre(@PathVariable long genre_id) {
        return null;
    }

    @GetMapping("/{genre_id}/books")
    public List<Book> getBooksByGenre(@PathVariable long genre_id) {
        return null;
    }
}
