package kniga.project.bookshop.services.interfaces;

import kniga.project.bookshop.entity.Reports;

import java.util.Set;

public interface IReportsService {
    Reports save(Reports reports);
    Reports getById(Long id);
    Set<Reports> getAll();
    Reports edit(Reports reports);
    void delete(Long id);
}
