package pl.coderslab.budget;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetRepository budgetRepository;

    public BudgetController(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("budget", budgetRepository.findAll());
        return "budget/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Budget budget, BindingResult result) {
        if (result.hasErrors()){
            return "budget/add";
        }
        budgetRepository.save(budget);
        return "redirect:/budget/list";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable long id) {
        model.addAttribute("budget", budgetRepository.findById(id));
        return "budget/update";
    }

    @PostMapping("/update/{id}")
    public String processUpdate(@Valid Budget budget, BindingResult result) {
        if (result.hasErrors()){
            return "budget/update";
        }
        budgetRepository.save(budget);
        return "redirect:/budget/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Budget budget){
        budgetRepository.delete(budget);
        return "redirect:/budget/list";
    }
}
