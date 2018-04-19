package trial;

import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import trial.model.Product;
import trial.service.ProductService;

@Controller
public class TestMainController {

	@Autowired
	private ProductService productService;

	@GetMapping("/home")
	public String index(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/allproducts")
	public String allProducts(HttpServletRequest request) {
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}
	
	@GetMapping("/newproduct")
	public String newProduct(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult, HttpServletRequest request) {
		product.setDate_posted(new Date());
		productService.save(product);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}
	
	@GetMapping("/updateproduct")
	public String updateProduct(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("product", productService.findProduct(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam int id, HttpServletRequest request){
		productService.delete(id);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}

}
