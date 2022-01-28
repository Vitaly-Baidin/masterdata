package ru.vitaly.baidin.service;

import ru.vitaly.baidin.model.Product;

import java.util.List;

public interface IManufacturerService {
    List<Product> getAllProductOfCompany(String manufacturerId);
    List<String> getManufacturers(String count);
}
