package com.example.nimap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        productRepository.save(product);
        // categoryRepository.save()
        return product.toString()+" added successfully";
    }

    public String getProductById(String id){
        Product product = productRepository.findById(id).get();
        if(product==null){
            return null;
        }
        return product.toString();
    }

    public String deleteById(String id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        productRepository.delete(product);
        return product.toString()+" deleted successfully";

    } 

    public String updateProduct(String id, String productName, double price, String description, int stock){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with Id"+id+" not found"));
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        productRepository.save(product);

        return product.toString()+" update Successfully";
    }



}
