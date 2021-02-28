package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.entity.Order;

import java.util.Set;

public interface IGenreService {
    Genre save(Genre genre);
    Genre getById(Long id);
    Set<Genre> getAll();
    Genre edit(Genre genre);
    void delete(Long id);
}
