package ru.vitaly.baidin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;
import ru.vitaly.baidin.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product, String manufacturerId) {
        product.setManufacturer(manufacturerRepository.findByManufactureId(manufacturerId));
        productRepository.save(product);
    }

    @Override
    public void putProduct(Product product, String manufacturerId) {
        if (!manufacturerId.isEmpty()) {
            product.setManufacturer(manufacturerRepository.findByManufactureId(manufacturerId));
        }
        productRepository.save(product);
    }
}
