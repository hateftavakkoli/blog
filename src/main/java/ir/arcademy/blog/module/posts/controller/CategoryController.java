package ir.arcademy.blog.module.posts.controller;

import ir.arcademy.blog.module.posts.model.Category;
import ir.arcademy.blog.module.posts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping("/getCategories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping("/newCategory")
    public Category newCategory(@RequestBody Category category) {
        return categoryService.registerCategory(category);
    }

}
