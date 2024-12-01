package com.example.nimap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.nimap.Model.Category;
import com.example.nimap.Model.Product;
import com.example.nimap.Repository.CategoryRepository;
import com.example.nimap.Repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> allRpoducts = productRepository.findAll(pageable);

        return allRpoducts.getContent();
    }

    public String addProduct(Product product){
        
        if (product.getCategory() == null || product.getCategory().getId() == null) {
            throw new RuntimeException("Category information is missing for the product");
        }
         
        Category category = categoryRepository.findById(product.getCategory().getId()).orElseThrow(()-> new RuntimeException("Category with ID"+product.getCategory().getId()+" entered not found"));
        product.setCategory(category);
        productRepository.save(product);

        return product.toString()+" added successfully";
    }

    public String getProductById(String id){
        Product product = productRepository.findById(id).get();
        if(product==null){
            return "Product with ID0"+id+" not found";
        }
        return product.toString();
        // Optional<Product> productOpt = productRepository.findById(id);
        // if (productOpt.isPresent()) {
        //     return productOpt.get().toString();
        // }
        // return "Product not found";
        }

    public String deleteById(String id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        productRepository.delete(product);
        return product.toString()+" deleted successfully";

    } 

    public String updateProduct(String id, String productName, Double price, String description, Integer stock){
        Product product = productRepository.findById(id).get();
        if(product.equals(null)){
            return "category not found";
        }else{
            product.setProductName(productName);
            product.setPrice(price);
            product.setDescription(description);
            product.setStock(stock);
            productRepository.save(product);
            return product.toString()+" updated successfully";
        }
    }



}
