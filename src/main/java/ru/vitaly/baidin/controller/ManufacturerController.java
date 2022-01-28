package ru.vitaly.baidin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.service.ManufacturerService;

import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/getAllProducts/")
    public List<Product> getAllProductOfCompany(@RequestParam String manufacturerId) {
        return manufacturerService.getAllProductOfCompany(manufacturerId);
    }

    @GetMapping("/getManufacturers/")
    public List<String> getManufacturers(@RequestParam String count) {
        return manufacturerService.getManufacturers(count);
    }
}
