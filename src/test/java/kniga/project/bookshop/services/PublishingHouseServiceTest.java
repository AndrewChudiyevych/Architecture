package kniga.project.bookshop.services;

import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.PublishingHouse;
import kniga.project.bookshop.mappers.AuthorMapper;
import kniga.project.bookshop.mappers.PublishingHouseMapper;
import kniga.project.bookshop.repos.AuthorRepository;
import kniga.project.bookshop.repos.PublishingHouseRepository;
import kniga.project.bookshop.status.AuthorStub;
import kniga.project.bookshop.status.PublishingHouseStub;
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
import static kniga.project.bookshop.status.PublishingHouseStub.getPublishingHouseRequest;
import static kniga.project.bookshop.status.PublishingHouseStub.getRandomPublishingHouse;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})

public class PublishingHouseServiceTest {

    private  PublishingHouseService service;

    @Mock
    private PublishingHouseRepository publishingHouseRepository;
    @Mock
    private PublishingHouseMapper publishingHouseMapper;

    @BeforeEach
    void setup() {
        service = new PublishingHouseService(publishingHouseRepository, publishingHouseMapper);
    }

    @Test
    void testSuccessfulGetById() {
        PublishingHouse publishingHouse = getRandomPublishingHouse();
        when(publishingHouseRepository.findById(any())).thenReturn(Optional.of(publishingHouse));

        PublishingHouse result = service.getById(PublishingHouseStub.ID);

        assertAll(
                () -> assertEquals(result.getId(), publishingHouse.getId()),
                () -> assertEquals(result.getName(), publishingHouse.getName()),
                () -> assertEquals(result.getDescription(), publishingHouse.getDescription()),
                () -> assertEquals(result.getLanguage(), publishingHouse.getLanguage()));
    }

    @Test
    void testNotSuccessfulGetByID() {
        when(publishingHouseRepository.findById(any())).thenReturn(Optional.empty());
        NullPointerException e = assertThrows(NullPointerException.class, ()->service.getById(PublishingHouseStub.ID));
        assertEquals(e.getMessage(), null);
    }

    @Test
    void testSuccessfulSave() {
        ArgumentCaptor<PublishingHouse> captor = ArgumentCaptor.forClass(PublishingHouse.class);
        PublishingHouse publishingHouse = getRandomPublishingHouse();
        when(publishingHouseMapper.fromRequest(any())).thenReturn(getRandomPublishingHouse());
        when(publishingHouseRepository.save(any())).thenReturn(publishingHouse);
        PublishingHouse result = service.create(getPublishingHouseRequest());
        Mockito.verify(publishingHouseRepository, atLeast(1)).save(captor.capture());
        assertEquals(publishingHouse, captor.getValue());
        assertEquals(publishingHouse.getName(), result.getName());
    }

    @Test
    void testSccessfulDelete() {
        service.delete(PublishingHouseStub.ID);
        ArgumentCaptor<Long> captor = forClass(Long.class);
        Mockito.verify(publishingHouseRepository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(PublishingHouseStub.ID, captor.getValue());
    }
}
