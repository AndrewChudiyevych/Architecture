package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Category;

import java.util.Set;

public interface IBookService {
    Book save(Book book);
    Book getById(Long id);
    Set<Book> getAll();
    Book edit(Book book);
    void delete(Long id);
}
