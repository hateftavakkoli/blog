package ir.arcademy.blog.modules.posts.controller;

import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.posts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String categories(Model model) {
        model.addAttribute("categories",categoryService.findAllCategories());
        return "categories/categories";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("category", new Category());
        return "categories/registerCategories";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "categories/registerCategories";

        categoryService.registerCategory(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(Model model ,@PathVariable("id") Long id) {
        model.addAttribute("category", categoryService.findById(id));
        return "categories/registerCategories";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/rest/getCategories", method = RequestMethod.GET)
    public @ResponseBody
    List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @RequestMapping(value = "/rest/register", method = RequestMethod.POST)
    public @ResponseBody
    Category registerCategory(@RequestBody Category category) {
        return categoryService.registerCategory(category);
    }


}
