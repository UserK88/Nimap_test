package com.example.nimap.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nimap.Model.Category;
import com.example.nimap.Service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        List<Category> categories = categoryService.getAllCategories(page - 1, size);
        return categories;
    }

    @PostMapping
    public String addNewCategory(@RequestBody Category catergory){
        return categoryService.addNewCategory(catergory);
    }

    @GetMapping("/{di}")
    public String getCategoryById(@PathVariable("di") String id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{di}")
    public String deleteById(@PathVariable("di") String id){
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/{di}")
    public String updateProduct(@PathVariable("di") String id, String name, String description){
        return categoryService.updateCategory(id, name, description);
    }
}
