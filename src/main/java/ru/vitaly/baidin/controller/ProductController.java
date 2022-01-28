package ru.vitaly.baidin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.model.ProductDto;
import ru.vitaly.baidin.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct/")
    public void addProduct(@ModelAttribute ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @PutMapping("/addProduct/{productId}")
    public void putProduct(Product product, @RequestParam String manufacturerId) {
        productService.putProduct(product, manufacturerId);
    }
}
