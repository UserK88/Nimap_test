package com.example.nimap.Repository;

// import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nimap.Model.Category;


public interface CategoryRepository extends JpaRepository<Category,String>{
    Page<Category> findAll(Pageable pageable);
    // Optional<Category> findById(String id);
}