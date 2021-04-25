package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthorService extends NoSuchElementException {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;


    public Author save(Author author) {
        return repository.save(author);
    }



    public Author getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Author> getAll() {
        List<Author> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Author update(Long id, AuthorRequest request) {
        var author = Author.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .genre(new HashSet<>())
                .description(request.getDescription())
                .books(new HashSet<>())
                .build();
        return repository.save(author);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Author create(AuthorRequest request) {
        var author = mapper.fromRequest(request);
        return repository.save(author);

    }



}
