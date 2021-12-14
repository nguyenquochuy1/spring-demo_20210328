package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ResponseObject;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
        // return an object with : data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("ok", "Query product successfully", foundProduct)) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("false", "Can't find product with id " + id, ""));

    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        List<Product> foundProducts = repository.findProductsByName(newProduct.getName().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name is taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert product successfully", repository.save(newProduct))
        );
    }

    // update + insert = upsert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updatedProduct = repository.findById(id).map(product1 -> {
            product1.setName(newProduct.getName());
            product1.setBrand(newProduct.getBrand());
            product1.setMadeIn(newProduct.getMadeIn());
            product1.setPrice(newProduct.getPrice());
            product1.setUrl(newProduct.getUrl());
            return repository.save(product1);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return repository.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok",
                "Update product successfully", updatedProduct));
    }

    //Delete a Product => Product
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exist = repository.existsById(id);
        if (exist) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete product successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("ok", "Cant find product to delete", ""));
    }
}
