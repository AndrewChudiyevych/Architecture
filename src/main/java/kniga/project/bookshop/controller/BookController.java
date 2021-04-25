package kniga.project.bookshop.controller;


import kniga.project.bookshop.dto.BookRequest;
import kniga.project.bookshop.entity.*;
import kniga.project.bookshop.services.BookServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

    private final BookServise service;

    @GetMapping("/")
    public Set<Book> getAllBooks(@RequestParam(required = false, defaultValue = "10") Integer size,
                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {

        return service.getById(id);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody BookRequest request) {
        return service.create(request);
        //return service.save(book);
    }

    @PutMapping("/edit/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book) {

        return service.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(long id) {
        service.delete(id);
    }

    @GetMapping("/{book_id}/orders")
    public List<Order> getOrdersByBook(@PathVariable long book_id) {
        return null;
    }

    @GetMapping("/{book_id}/categories")
    public List<Category> getCategoriesByBook(@PathVariable long book_id) {
        return null;
    }

    @GetMapping("/{book_id}/genres")
    public List<Genre> getGenresByBook(@PathVariable long book_id) {
        return null;
    }

    @GetMapping("/{book_id}/publishingHouses")
    public List<PublishingHouse> getPublishingHousesByBook(@PathVariable long book_id) {
        return null;
    }

    @GetMapping("/{book_id}/authors")
    public List<Author> getAuthorsByBook(@PathVariable long book_id) {
        return null;
    }

    @GetMapping("/{book_id}/reports")
    public List<Reports> getReportsByBook(@PathVariable long book_id) {
        return null;
    }
}
