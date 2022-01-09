package pl.coderslab.transaction;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.budget.Budget;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;
    @Min(0)
    private double amount;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Budget budget;

}