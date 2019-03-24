package snmaddula.ignite.ogm.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Data;

/**
 * Price Entity
 * @author snmaddula
 *
 */
@Data
@Entity
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "price")
	@TableGenerator(name = "price", table = "sequences", pkColumnName = "key", pkColumnValue = "price", valueColumnName = "seed")
	private Long id;
	private Double basePrice;
	private Double tax;
	private Double maxRetailPrice;

}
