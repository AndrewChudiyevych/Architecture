package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;

import java.util.Set;

public interface IAuthorService {
    Author save(Author author);
    Author getById(Long id);
    Set<Author> getAll();
    Author edit(Author author);
    void delete(Long id);
}
