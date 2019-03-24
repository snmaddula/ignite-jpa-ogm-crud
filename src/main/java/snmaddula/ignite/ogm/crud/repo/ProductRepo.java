package snmaddula.ignite.ogm.crud.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import snmaddula.ignite.ogm.crud.entity.Product;

/**
 * Product Repo with CRUD operations on Product (and Price)
 * 
 * @author snmaddula
 *
 */
@Repository
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class ProductRepo {

	private final EntityManager em;
	
	public List<Product> findAll() {
		em.getTransaction().begin();
	    List<Product> products = em.createQuery("SELECT p FROM Product p").getResultList();
	    em.getTransaction().commit();
	    return products;
	}

	public Optional<Product> findById(Long id) {
		em.getTransaction().begin();
		Product product = em.find(Product.class, id);
		em.getTransaction().commit();
		return Optional.ofNullable(product);
	}

	public void save(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	public void deleteById(Long id) {
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
	}

	public void deleteAllInBatch() {
		em.getTransaction().begin();
	    em.createQuery("DELETE FROM Product").executeUpdate();
	    em.getTransaction().commit();
	}

}
