package ru.vitaly.baidin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerService implements IManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Product> getAllProductOfCompany(String manufacturerId) {
        return manufacturerRepository.findByManufactureId(manufacturerId).getProducts();
    }

    @Override
    public List<String> getManufacturers(String count) {
        return manufacturerRepository.getAllByQuery(count);
    }
}
