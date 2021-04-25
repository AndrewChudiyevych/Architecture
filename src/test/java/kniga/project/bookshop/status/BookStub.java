package kniga.project.bookshop.status;

import kniga.project.bookshop.dto.BookRequest;
import kniga.project.bookshop.entity.Author;
import kniga.project.bookshop.entity.Book;
import kniga.project.bookshop.entity.Category;
import kniga.project.bookshop.entity.PublishingHouse;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;

public class BookStub {

    public static final Long ID = 1L;
    public static final String BOOKNAME = "dadada";
    public static final String LANGUAGE = "adadada";
    private static final double PRICE = -1.34;
    private static final String DATE = "23131";
    private static final int PAGES = 1;
    private static final boolean INSTOCK = true;

    public static Book getRandomBook() {
        return Book.builder()
                .id(ID)
                .orders(new HashSet<>())
                .bookName(BOOKNAME)
                .category(new Category())
                .genre(new HashSet<>())
                .language(LANGUAGE)
                .publishingHouse(new PublishingHouse())
                .price(PRICE)
                .dateOfAiring(DATE)
                .pages(PAGES)
                .author(new Author())
                .inStock(INSTOCK)
                .reports(new HashSet<>())
                .build();
    }

    public static BookRequest getBookRequest() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookName(BOOKNAME);
        bookRequest.setPrice(PRICE);
        bookRequest.setPages(PAGES);
        bookRequest.setLanguage(LANGUAGE);
        bookRequest.setDateOfAiring(DATE);
        bookRequest.setInStock(INSTOCK);
        return bookRequest;

    }
}
