package ru.vitaly.baidin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.model.ProductDto;
import ru.vitaly.baidin.model.ProductMapper;
import ru.vitaly.baidin.repository.ManufacturerRepository;
import ru.vitaly.baidin.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProduct(ProductDto productDto) {
        productRepository.save(productMapper.mapToProductEntity(productDto));
    }

    @Override
    public void putProduct(Product product, String manufacturerId) {
        if (!manufacturerId.isEmpty()) {
            product.setManufacturer(manufacturerRepository.findByManufactureId(manufacturerId));
        }
        productRepository.save(product);
    }
}
