package pl.coderslab.transaction;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.budget.Budget;
import pl.coderslab.category.Category;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private int amount;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Budget budget;

}
