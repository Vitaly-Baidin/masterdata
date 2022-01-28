package ru.vitaly.baidin.service;

import ru.vitaly.baidin.model.Product;

public interface IProductService {

    void addProduct(Product product, String manufacturerId);
    void putProduct(Product product, String manufacturerId);
}
