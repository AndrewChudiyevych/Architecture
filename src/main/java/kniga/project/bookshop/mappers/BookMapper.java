package kniga.project.bookshop.mappers;

import kniga.project.bookshop.dto.BookRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.PublishingHouse;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;

@Component
public class BookMapper {
    public Book fromRequest(BookRequest request) {
        return Book.builder()
                .id(new Random().nextLong())
                .orders(new HashSet<>())
                .bookName(request.getBookName())
                .category(new Category())
                .genre(new HashSet<>())
                .language(request.getLanguage())
                .publishingHouse(new PublishingHouse())
                .price(request.getPrice())
                .dateOfAiring(request.getDateOfAiring())
                .pages(request.getPages())
                .author(new Author())
                .inStock(request.isInStock())
                .reports(new HashSet<>())
                .build();
    }
}
