package snmaddula.ignite.ogm.crud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import lombok.Data;

/**
 * Product Entity
 * 
 * @author snmaddula
 *
 */
@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product")
	@TableGenerator(name = "product", table = "sequences", pkColumnName = "key", pkColumnValue = "product", valueColumnName = "seed")
	private Long id;
	private String title;
	private String description;
	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Price price;

}
