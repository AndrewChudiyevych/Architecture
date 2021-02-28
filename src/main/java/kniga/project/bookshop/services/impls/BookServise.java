package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.repos.BookRepository;
import kniga.project.bookshop.services.interfaces.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServise implements IBookService {
    private final BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Book> getAll() {
        List<Book> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Book edit(Book book) {
        return repository.save(book);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
