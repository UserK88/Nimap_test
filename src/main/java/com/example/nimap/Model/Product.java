package com.example.nimap.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    
    @Id
    private String productId;

    private String productName;
    private Double price;
    private String description;
    @Column(nullable = false)
    private Integer stock=0;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {

    }

    public Product(String productId, String productName, double price, String description, int stock, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
                + ", description=" + description + ", stock=" + stock + ", category=" + (category != null ? category.getId() :"null") + "]";
    }

//    The ternary operator above in the toString() method is added to Avoid Recursive Calls in toString()
//    Modify the toString() methods to avoid printing the full referenced objects.
    
}
