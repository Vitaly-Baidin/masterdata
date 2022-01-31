package ru.vitaly.baidin.service;

import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.dto.ProductDto;

public interface IProductService {

    void addProduct(ProductDto productDto);
    void putProduct(Product product, String manufacturerId);
}
