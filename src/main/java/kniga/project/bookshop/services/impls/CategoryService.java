package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.repos.CategoryRepository;
import kniga.project.bookshop.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository repository;

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Category> getAll() {
        List<Category> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Category edit(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
