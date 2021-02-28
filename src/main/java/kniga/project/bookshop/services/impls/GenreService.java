package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.repos.GenreRepository;
import kniga.project.bookshop.services.interfaces.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService {
    private final GenreRepository repository;

    @Override
    public Genre save(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public Genre getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Genre> getAll() {
        List<Genre> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Genre edit(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
