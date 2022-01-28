package ru.vitaly.baidin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;
import ru.vitaly.baidin.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @PostMapping("/addProduct/")
    public void addProduct(Product product, @RequestParam String manufacturerId) {
        product.setManufacturer(manufacturerRepository.findById(manufacturerId).get());
        productRepository.save(product);
    }

    @PutMapping("/addProduct/{productId}")
    public ResponseEntity putProduct(Product product, @RequestParam String manufacturerId) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (!manufacturerId.isEmpty()) {
            product.setManufacturer(manufacturerRepository.findById(manufacturerId).get());
        }
        productRepository.save(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts/")
    public List<Product> getAllProductOfCompany(@RequestParam String manufacturerId) {
        return manufacturerRepository.findById(manufacturerId).get().getProducts();
    }

    @GetMapping("/getManufacturers/")
    public List<String> getManufacturers(@RequestParam String count) {
        return manufacturerRepository.getAllByQuery(count);
    }
}
