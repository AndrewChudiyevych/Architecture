package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.PublishingHouseRequest;
import kniga.project.bookshop.entity.PublishingHouse;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PublishingHouseMapper {
    public PublishingHouse fromRequest(PublishingHouseRequest request) {
        return PublishingHouse.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .language(request.getLanguage())
                .description(request.getDescription())
                .build();
    }
}
