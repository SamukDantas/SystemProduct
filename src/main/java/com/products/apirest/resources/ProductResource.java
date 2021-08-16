package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductResource {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/produtos")
	public List<Product> showProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Product showUniqueProduct(@PathVariable("id") long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
