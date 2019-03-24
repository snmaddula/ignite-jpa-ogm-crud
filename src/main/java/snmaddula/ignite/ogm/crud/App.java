package snmaddula.ignite.ogm.crud;

import static javax.persistence.Persistence.createEntityManagerFactory;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * Main Class
 * 
 * @author snmaddula
 *
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public EntityManager em() {
		return createEntityManagerFactory("IgniteOgmCrud").createEntityManager();
	}

}
