package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.AuthorRequest;
import kniga.project.bookshop.dto.PublishingHouseRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.PublishingHouse;

import java.util.Random;

public class PublishingHouseStub {
    public static final Long ID = 1L;
    private static final String NAME = "fafa";
    public static final String LANGUAGE = "sdadae";
    public static final String DESCRIPTION = "description";


    public static PublishingHouse getRandomPublishingHouse() {
        return PublishingHouse.builder()
                .id(ID)
                .name(NAME)
                .language(LANGUAGE)
                .description(DESCRIPTION)
                .build();
    }

    public static PublishingHouseRequest getPublishingHouseRequest() {
        PublishingHouseRequest publishingHouseRequest = new PublishingHouseRequest();
        publishingHouseRequest.setName(NAME);
        publishingHouseRequest.setLanguage(LANGUAGE);
        publishingHouseRequest.setDescription(DESCRIPTION);
        return publishingHouseRequest;
    }
}
