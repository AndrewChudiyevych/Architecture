package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.Genre;

import java.util.Set;

public interface ICategoryService {
    Category save(Category category);
    Category getById(Long id);
    Set<Category> getAll();
    Category edit(Category category);
    void delete(Long id);
}
