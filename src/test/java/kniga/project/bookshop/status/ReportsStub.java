package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.ReportsRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Reports;

import java.util.HashSet;
import java.util.Random;

public class ReportsStub {

    public static final Long ID = 1L;
    public static final String REPORT = "eaea";
    public static final int SCORE = 1;


    public static Reports getRandomReport() {
        return Reports.builder()
                .id(ID)
                .report(REPORT)
                .score(SCORE)
                .build();
    }

    public static ReportsRequest getReportsRequest() {
        ReportsRequest reportsRequest = new ReportsRequest();
        reportsRequest.setReport(REPORT);
        reportsRequest.setScore(SCORE);
        return reportsRequest;
    }
}
