package pl.coderslab.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Category category, BindingResult result) {
        if (result.hasErrors()){
            return "category/add";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable long id) {
        model.addAttribute("category", categoryRepository.findById(id));
        return "category/update";
    }

    @PostMapping("/update/{id}")
    public String processUpdate(@Valid Category category, BindingResult result) {
        if (result.hasErrors()){
            return "category/update";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Category category){
        categoryRepository.delete(category);
        return "redirect:/category/list";
    }
}
