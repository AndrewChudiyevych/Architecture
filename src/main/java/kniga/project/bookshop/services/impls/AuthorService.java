package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.services.interfaces.IAuthorService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository repository;

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }


    @Override
    public Author getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Author> getAll() {
        List<Author> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Author edit(Author author) {
        return repository.save(author);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /*public Author create(Author author) {
        var _author = Author.builder()
                .id(new Random().nextLong())
                .name(author.getName())
                .surname(author.getSurname())
                .genre(new HashSet<>())
                .description(author.getDescription())
                .books(new HashSet<>()).build();
        return repository.save(_author);
    }*/

}
