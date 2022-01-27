package ru.vitaly.baidin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private String manufactureId;

    @Column(name = "manufacturer_name")
    private String manufactureName;
}
