package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;
import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface OrderRepository extends CrudRepository<Receipt, String> {
    Receipt save(Receipt order);
    Receipt findById(int id);
}
