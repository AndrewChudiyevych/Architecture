package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.GenreRequest;
import kniga.project.bookshop.entity.Genre;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.GenreMapper;
import kniga.project.bookshop.repos.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository repository;
    private final GenreMapper mapper;

    public Genre save(Genre genre) {
        return repository.save(genre);
    }


    public Genre getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Genre> getAll() {
        List<Genre> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Genre update(Long id,Genre genre) {
        Genre genre1 = repository.findById(id).orElseThrow(null);
        genre1 = genre;
        return repository.save(genre1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Genre create(GenreRequest request) {
        var genre = mapper.fromRequest(request);
        return repository.save(genre);
    }
}
