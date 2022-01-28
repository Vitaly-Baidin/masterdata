package ru.vitaly.baidin.service;

import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.model.ProductDto;

public interface IProductService {

    void addProduct(ProductDto productDto);
    void putProduct(Product product, String manufacturerId);
}
