package trial.dao;


import org.springframework.data.repository.CrudRepository;

import trial.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
	
}
