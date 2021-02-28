package kniga.project.bookshop.services.impls;

import kniga.project.bookshop.entity.Order;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.repos.OrderRepository;
import kniga.project.bookshop.repos.ReportsRepository;
import kniga.project.bookshop.services.interfaces.IReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReportsService implements IReportsService {
    private final ReportsRepository repository;

    @Override
    public Reports save(Reports reports) {
        return repository.save(reports);
    }

    @Override
    public Reports getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Set<Reports> getAll() {
        List<Reports> list = repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Reports edit(Reports reports) {
        return repository.save(reports);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
