package kniga.project.bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "reports")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reports {
    @Id
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "repots")
    private Book book;

    private String report;

    private int score;
}
