package trial.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import trial.dao.ProductRepository;
import trial.model.Product;

@Service
@Transactional
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		for (Product product : productRepository.findAll()) {
			products.add(product);
		}
		return products;
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public void delete(int id) {
		productRepository.delete(id);
	}

	public Product findProduct(int id) {
		return productRepository.findOne(id);
	}

}
