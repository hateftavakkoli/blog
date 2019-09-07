package ir.arcademy.blog.modules.posts.controller;

import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.posts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String categories() {
        return "categories/categories";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "categories/registerCategories";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Category category) {
        categoryService.registerCategory(category);
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
