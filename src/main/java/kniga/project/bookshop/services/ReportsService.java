package kniga.project.bookshop.services;

import kniga.project.bookshop.dto.ReportsRequest;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.ReportsMapper;
import kniga.project.bookshop.repos.ReportsRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReportsService {

    private final ReportsRepository repository;
    private final ReportsMapper mapper;


    public Reports save(Reports reports) {
        return repository.save(reports);
    }


    public Reports getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }


    public Set<Reports> getAll() {
        List<Reports> list = repository.findAll();
        return new HashSet<>(list);
    }


    public Reports update(Long id, Reports reports) {
        Reports reports1 = repository.findById(id).orElseThrow(null);
        reports1 = reports;
        return repository.save(reports1);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Reports create(ReportsRequest request) {
        var reports = mapper.fromRequest(request);
        return repository.save(reports);
    }

}
