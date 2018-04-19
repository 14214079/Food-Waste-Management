package trial;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import trial.model.Product;
import trial.service.ProductService;

@RestController
public class TestRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/hello-rest")
	public String hello() {
		return "Hello From Rest Controller";
	}
	
	@GetMapping("/all-products-rest")
	public String allProducts() {
		return productService.findAll().toString();
	}
	
	@GetMapping("/save-product-rest")
	public String saveProduct(@RequestParam String name, @RequestParam String description, @RequestParam String location) {
		Product product = new Product(name, description, location, new Date(), false, false);
		productService.save(product);
		return "Product Saved";
	}
	
	@GetMapping("/delete-product-rest")
	public String deleteProduct(@RequestParam int id) {
		productService.delete(id);
		return "Product Deleted";
	}
	
}
