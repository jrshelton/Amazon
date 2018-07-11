package io.pivotal.workshop.controller;


import io.pivotal.workshop.model.Product;
import io.pivotal.workshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public Product createProduct(@Valid @RequestBody Product product) {

        return productRepository.save(product);
    }

    @RequestMapping("/all")
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Product> findById(@PathVariable("id") long id) {

        return productRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        productRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Product editById(@PathVariable("id") long id, @RequestBody Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return null;
        }
        product.setProductId(id);
        return productRepository.save(product);

    }
}