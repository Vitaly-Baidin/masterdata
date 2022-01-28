package ru.vitaly.baidin.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.baidin.repository.ManufacturerRepository;

@Service
public class ProductMapper {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    //из entity в dto
    public ProductDto mapToProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setManufacturerId(product.getManufacturer().getManufactureId());
        return dto;
    }
    //из dto в entity
    public Product mapToProductEntity(ProductDto dto){
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setManufacturer(manufacturerRepository.findByManufactureId(dto.getManufacturerId()));
        return product;
    }
}
