package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("API REST Produtos")
@CrossOrigin(origins = "*")
public class ProductResource {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/produtos")
	@ApiOperation("Retorna uma lista de produtos")
	public List<Product> showProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation("Retorna um produto")
	public Product showUniqueProduct(@PathVariable("id") long id) {
		return productRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation("Salva um produto")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@DeleteMapping("/produto")
	@ApiOperation("Deleta um produto")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}

	@PutMapping("/produto")
	@ApiOperation("Atualiza um produto")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

}
