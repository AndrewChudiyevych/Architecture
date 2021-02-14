package kniga.project.bookshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "reports")
public class Reports {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn//(name = "repots")
    private Book book;

    private String report;

    private int score;
}
