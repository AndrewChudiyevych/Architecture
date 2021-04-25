package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.CategoryRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.CategoryMapper;
import kniga.project.bookshop.repos.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    public Category save(Category category) {
        return repository.save(category);
    }


    public Category getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Category> getAll() {
        List<Category> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Category update(Long id,Category category) {
        Category category1 = repository.findById(id).orElseThrow(null);
        category1 = category;
        return repository.save(category1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Category create(CategoryRequest request) {
        var category = mapper.fromRequest(request);

        return repository.save(category);
    }
}
