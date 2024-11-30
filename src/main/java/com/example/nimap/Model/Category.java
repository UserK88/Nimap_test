package com.example.nimap.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    
    @Id
    private String id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;

    public Category() {
    }

    public Category(String id, String name, String description, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
                + "]";
    }

}
