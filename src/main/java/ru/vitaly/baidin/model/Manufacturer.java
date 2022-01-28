package ru.vitaly.baidin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private String manufactureId;

    @Column(name = "manufacturer_name")
    private String manufactureName;

    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference
    private List<Product> products;
}
