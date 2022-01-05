package pl.coderslab.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.budget.BudgetRepository;
import pl.coderslab.category.CategoryRepository;


@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;

    public TransactionController(TransactionRepository transactionRepository, BudgetRepository budgetRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String transactionList(Model model) {
        model.addAttribute("transaction", transactionRepository.findAll());
        return "transaction/list";
    }

    @GetMapping("/add")
    public String addTransaction(Model model) {
        model.addAttribute("budget", budgetRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("transaction", new Transaction());
        return "transaction/add";
    }

    @PostMapping("/add")
    public String processAdd(Transaction transaction) {
        transactionRepository.save(transaction);
        return "redirect:/transaction/list";
    }

    @GetMapping("/update/{id}")
    public String updateTransaction(Model model, @PathVariable long id) {
        model.addAttribute("budget", budgetRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("transaction", transactionRepository.findById(id));
        return "transaction/update";
    }

    @PostMapping("/update/{id}")
        public String processUpdate(Transaction transaction) {
        transactionRepository.save(transaction);
        return "redirect:/transaction/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(Transaction transaction){
        transactionRepository.delete(transaction);
        return "redirect:/transaction/list";
    }


}