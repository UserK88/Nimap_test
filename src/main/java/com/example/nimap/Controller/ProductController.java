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

import com.example.nimap.Model.Product;
import com.example.nimap.Service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        List<Product> products = productService.getAllProducts(page-1, size);
        return products;
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{di}")
    public String getProductById(@PathVariable("di") String id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{di}")
    public String deleteById(@PathVariable("di") String id){
        return productService.deleteById(id);
    }

    @PutMapping("/{di}")
    public String updateProduct(@PathVariable("di") String id,@RequestParam("name") String name,@RequestParam("price") Double price,@RequestParam("description") String description,@RequestParam("stock") Integer stock){
        return productService.updateProduct(id, name, price, description, stock);
    }
}
