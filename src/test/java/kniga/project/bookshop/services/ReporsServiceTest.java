package kniga.project.bookshop.services;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Reports;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.ReportsMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.ReportsRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.ReportsStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kniga.project.bookshop.status.AuthorStub.getAuthorRequest;
import static kniga.project.bookshop.status.AuthorStub.getRandomAuthor;
import static kniga.project.bookshop.status.ReportsStub.getRandomReport;
import static kniga.project.bookshop.status.ReportsStub.getReportsRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ReporsServiceTest {
    private  ReportsService service;

    @Mock
    private ReportsRepository reportsRepository;
    @Mock
    private ReportsMapper reportsMapper;

    @BeforeEach
    void setup() {
        service = new ReportsService(reportsRepository, reportsMapper);
    }

    @Test
    void testSuccessfulGetById() {
        Reports reports = getRandomReport();
        when(reportsRepository.findById(any())).thenReturn(Optional.of(reports));

        Reports result = service.getById(ReportsStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), reports.getId()),
                () -> assertEquals(result.getReport(), reports.getReport()),
                () -> assertEquals(result.getScore(), reports.getScore()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(reportsRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(ReportsStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<Reports> captor = ArgumentCaptor.forClass(Reports.class);
        Reports reports = getRandomReport();
        when(reportsMapper.fromRequest(any())).thenReturn(getRandomReport());
        when(reportsRepository.save(any())).thenReturn(reports);
        Reports result = service.create(getReportsRequest());
        Mockito.verify(reportsRepository, atLeast(1)).save(captor.capture());
        assertEquals(reports, captor.getValue());
        assertEquals(reports.getScore(), result.getScore());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(ReportsStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(reportsRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(ReportsStub.ID, captor.getValue());
    }
}
