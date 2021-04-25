package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.CategoryRequest;
import kniga.project.bookshop.entity.Category;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;

@Component
public class CategoryMapper {
    public Category fromRequest(CategoryRequest request) {
        return Category.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .genre(new HashSet<>())
                .description(request.getDescription())
                .books(new HashSet<>())
                .build();
    }
}
