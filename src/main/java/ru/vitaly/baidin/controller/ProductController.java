package ru.vitaly.baidin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vitaly.baidin.model.Manufacturer;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;
import ru.vitaly.baidin.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @PostMapping("/addProduct/")
    public void addProduct(@RequestParam String productId, @RequestParam(required = false) String productName, @RequestParam String manufacturerId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setManufacturerId(manufacturerRepository.findById(manufacturerId).get());
        product.setProductName(productName);
        productRepository.save(product);
    }

    @GetMapping("/getAllProducts/{manufacturerId}")
    public List<Product> getAllProductOfCompany(@PathVariable String manufacturerId) {
        Iterable<Product> productIterable = productRepository.findAll();

        ArrayList<Product> products = new ArrayList<>();

        for (Product product : productIterable) {
            products.add(product);
        }
        return products;
    }

    @GetMapping("/getManufacturers/{num}")
    public List<String> getManufacturers() {

        return manufacturerRepository.getAllByQuery(0);
    }
}
