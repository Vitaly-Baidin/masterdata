package ru.vitaly.baidin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;
import ru.vitaly.baidin.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/addProduct/{productId}")
    public ResponseEntity putProduct(@RequestParam String productId, @RequestParam String productName, @RequestParam String manufacturerId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Product product = optionalProduct.get();

        product.setProductId(productId);
        product.setManufacturerId(manufacturerRepository.findById(manufacturerId).get());
        product.setProductName(productName);
        productRepository.save(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts/")
    public List<Product> getAllProductOfCompany(@RequestParam String manufacturerId) {
        Iterable<Product> productIterable = productRepository.findAll();

        ArrayList<Product> products = new ArrayList<>();

        for (Product product : productIterable) {
            if (product.getManufacturerId().getManufactureId().equals(manufacturerId)) {
                products.add(product);
            }
        }
        return products;
    }

    @GetMapping("/getManufacturers/")
    public List<String> getManufacturers(@RequestParam String count) {
        return manufacturerRepository.getAllByQuery(count);
    }
}
