package ru.vitaly.baidin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private String productId;
    private String productName;
    private String manufacturerId;
}
