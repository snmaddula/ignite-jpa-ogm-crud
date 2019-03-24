package snmaddula.ignite.ogm.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import snmaddula.ignite.ogm.crud.entity.Product;
import snmaddula.ignite.ogm.crud.service.ProductService;

/**
 * Products Controller with REST HTTP Endpoints
 * 
 * @author snmaddula
 *
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public List<Product> getAll() {
		return productService.fetchAll();
	}

	@GetMapping("{id}")
	public Optional<Product> getById(@PathVariable Long id) {
		return productService.fetchById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Product product) {
		productService.create(product);
	}

	@DeleteMapping("{id}")
	public void removeById(@PathVariable Long id) {
		productService.remove(id);
	}

	@DeleteMapping
	public void removeAll() {
		productService.removeAll();
	}

}
