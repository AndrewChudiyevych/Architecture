package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.BookRequest;
import kniga.project.bookshop.entity.*;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.BookMapper;
import kniga.project.bookshop.repos.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServise {

    private final BookRepository repository;
    private final BookMapper mapper;


    public Book save(Book book) {
        return repository.save(book);
    }


    public Book getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Book> getAll() {
        List<Book> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Book update(Long id, Book book) {
        Book book1 = repository.findById(id).orElseThrow(null);
        book1 = book;
        return repository.save(book1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Book create(BookRequest request) {
        var book = mapper.fromRequest(request);
        return repository.save(book);
    }

}
