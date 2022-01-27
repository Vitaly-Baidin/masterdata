package ru.vitaly.baidin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vitaly.baidin.model.Manufacturer;

import java.util.List;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, String> {




    @Query(value = "SELECT manufacturer_name AS name, count(*) AS cnt " +
            "FROM manufacturer AS m " +
            "INNER JOIN product p ON m.manufacturer_id = p.manufacturer_id " +
            "GROUP BY p.manufacturer_id " +
            "HAVING cnt > :count", nativeQuery = true)
    List<String> getAllByQuery(@Param("count") int count);
}
