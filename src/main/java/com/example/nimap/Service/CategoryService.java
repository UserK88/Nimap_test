package com.example.nimap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.nimap.Model.Category;
import com.example.nimap.Repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> allCategories = categoryRepository.findAll(pageable);
        return allCategories.getContent();
    }

    public Category addNewCategory(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Category getById(String id){
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    public Category deleteCategory(String id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        categoryRepository.delete(category);
        return category;
    }

    public String updateCategory(String id, String name, String description){
        Category category = categoryRepository.findById(id).get();
        if(category.equals(null)){
            return "category not found";
        }else{
            category.setName(name);
            category.setDescription(description);
            return category.toString()+" updated successfully";
        }

    }
}
