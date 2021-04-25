package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.ReportsRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Reports;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ReportsMapper {

    public Reports fromRequest(ReportsRequest request) {
        return Reports.builder()
                .id(new Random().nextLong())
                .report(request.getReport())
                .score(request.getScore())
                .build();
    }
}
