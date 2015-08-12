/**
 * WebConfig
 * 
 * @Configuration indicates that the class can be used by the Spring IoC container 
 * as a source of bean definitions.
 * 
 * @Bean annotation tells Spring that a method annotated with @Bean will return an 
 * object that should be registered as a bean in the Spring application context.
 */
package springmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import springmvc.model.dao.EventDAO;
import springmvc.model.dao.LocationDAO;
import springmvc.model.dao.UserDAO;

/**
 * @author Chuck
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "springmvc.controller" })
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;
	
	/**
	 * View resolver.
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	/**
	 * 
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		String dsUrl = environment.getProperty("dataSource.url");
		String dsUser = environment.getProperty("dataSource.username");
		String dsPassword = environment.getProperty("dataSource.password");
		String dsdriver = environment.getProperty("dataSource.driver");
		
		// codejava.net/frameworks/spring/spring-4-and-hibernate-4-integration-tutorial-part-2-java-based-configuration
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(dsdriver);
	    dataSource.setUrl(dsUrl);
	    dataSource.setUsername(dsUser);
	    dataSource.setPassword(dsPassword);
	    dataSource.setInitialSize(8);
	    dataSource.setMaxActive(100);
	    dataSource.setMaxIdle(30);
	    dataSource.setMaxWait(60000);
	    dataSource.setTestOnBorrow(true);
	    dataSource.setTestOnReturn(true);
	    dataSource.setTestWhileIdle(true);
	    dataSource.setValidationQuery("select 1");
	    dataSource.setValidationQueryTimeout(60000);
	    
	    return dataSource;
	}
	
	/**
	 * 
	 * @param dataSource
	 * @return
	 */
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

    	// Connection pool
    	properties.put("hibernate.dbcp.whenExhaustedAction", "1");

    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(properties);
    	sessionBuilder.scanPackages("springmvc.model.entity");
    	
    	return sessionBuilder.buildSessionFactory();
    }
    
    /**
     * 
     * @param sessionFactory
     * @return
     */
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    	// Pass in this objects built session factory from above method
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
    
	/**
	 * 
	 * @param sessionFactory
	 * @return
	 */
    @Autowired
    @Bean(name = "userDao")
    public UserDAO getUserDao(SessionFactory sessionFactory) {
    	// Pass in this objects built session factory from above method
    	return new UserDAO(sessionFactory);
    }

	/**
	 * 
	 * @param sessionFactory
	 * @return
	 */
    @Autowired
    @Bean(name = "eventDao")
    public EventDAO getEventDao(SessionFactory sessionFactory) {
    	// Pass in this objects built session factory from above method
    	return new EventDAO(sessionFactory);
    }
	/**
	 * 
	 * @param sessionFactory
	 * @return
	 */
    @Autowired
    @Bean(name = "loctionDao")
    public LocationDAO getLoctionDao(SessionFactory sessionFactory) {
    	// Pass in this objects built session factory from above method
    	return new LocationDAO(sessionFactory);
    }
}
