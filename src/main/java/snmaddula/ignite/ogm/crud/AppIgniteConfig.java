package snmaddula.ignite.ogm.crud;

import java.util.Arrays;

import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.hibernate.ogm.datastore.ignite.IgniteConfigurationBuilder;

import snmaddula.ignite.ogm.crud.entity.Product;

/**
 * Ignite Configuration 
 * 
 * @author snmaddula
 *
 */
public class AppIgniteConfig implements IgniteConfigurationBuilder {

	public IgniteConfiguration build() {
		return new IgniteConfiguration() {{
			setPeerClassLoadingEnabled(true);
			setClientMode(false);
			new TcpDiscoverySpi() {{
				setIpFinder(new TcpDiscoveryMulticastIpFinder() {{
					setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
				}});
			}};
			setCacheConfiguration(new CacheConfiguration<Long, Product>("product"));
		}};
	}

}
