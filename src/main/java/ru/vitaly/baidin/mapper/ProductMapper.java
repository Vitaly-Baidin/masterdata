package ru.vitaly.baidin.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vitaly.baidin.dto.ProductDto;
import ru.vitaly.baidin.model.Product;
import ru.vitaly.baidin.repository.ManufacturerRepository;

@Service
public class ProductMapper implements Mapper<ProductDto, Product> {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    //из entity в dto
    @Override
    public ProductDto mapToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setManufacturerId(product.getManufacturer().getManufactureId());
        return dto;
    }

    //из dto в entity
    @Override
    public Product mapToModel(ProductDto dto){
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setManufacturer(manufacturerRepository.findByManufactureId(dto.getManufacturerId()));
        return product;
    }
}
