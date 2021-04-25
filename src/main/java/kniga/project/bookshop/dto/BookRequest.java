package kniga.project.bookshop.dto;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class BookRequest {
    private String bookName;

    private String language;

    private double price;

    private String dateOfAiring;

    private int pages;

    private boolean inStock;
}
