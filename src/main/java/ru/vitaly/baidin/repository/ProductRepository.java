package ru.vitaly.baidin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vitaly.baidin.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
