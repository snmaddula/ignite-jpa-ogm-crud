package snmaddula.ignite.ogm.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.ignite.ogm.crud.entity.Product;
import snmaddula.ignite.ogm.crud.repo.ProductRepo;

/**
 * Product Service 
 * 
 * @author snmaddula
 *
 */
@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepo productRepo;

	public List<Product> fetchAll() {
		return productRepo.findAll();
	}

	public Optional<Product> fetchById(Long id) {
		return productRepo.findById(id);
	}

	public void create(Product product) {
		productRepo.save(product);
	}

	public void remove(Long id) {
		productRepo.deleteById(id);
	}

	public void removeAll() {
		productRepo.deleteAllInBatch();
	}

}
