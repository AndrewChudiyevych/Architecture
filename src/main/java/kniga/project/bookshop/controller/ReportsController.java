package kniga.project.bookshop.controller;


import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.services.impls.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reports")
public class ReportsController {

    private final ReportsService servise;

    @GetMapping("/")
    public Set<Reports> getAllReports(@RequestParam(required = false, defaultValue = "10") Integer size,
                                      @RequestParam(required = false, defaultValue = "1") Integer page) {
        return servise.getAll();
    }

    @GetMapping("/{id}")
    public Reports getReportById(@PathVariable long id) {

        return servise.getById(id);
    }

    @PostMapping("/")
    public Reports createReport(@RequestBody Reports reports) {

        return servise.save(reports);
    }

    @PutMapping("/{id}")
    public Reports updateReport(@PathVariable long id, @RequestBody Reports reports) {

        return servise.edit(reports);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(long id) {
        servise.delete(id);
    }

    @GetMapping("/{report_id}/books")
    public List<Book> getBooksByReport(@PathVariable long report_id) {
        return null;
    }
}
