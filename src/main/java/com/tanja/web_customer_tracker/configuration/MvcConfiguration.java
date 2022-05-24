package com.tanja.web_customer_tracker.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages="com.tanja.web_customer_tracker")
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfiguration implements WebMvcConfigurer {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource dataSource() {
		// create connection pool
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		dataSource.setUrl("jdbc:mysql://localhost:3306/customer_tracker");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.tanja.web_customer_tracker.model");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
    
    private Properties hibernateProperties() {
    	Properties hibernateProperties = new Properties();
    	
    	hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	hibernateProperties.setProperty("show_sql", "true");
    	hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
    	hibernateProperties.setProperty("connection.pool_size", "1");
    	
    	return hibernateProperties;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() {
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    	
    	transactionManager.setSessionFactory(sessionFactory().getObject());
    	
    	return transactionManager;
    }
	
    @Bean
    public CommonsMultipartResolver multipartResolver() {
    	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    	multipartResolver.setMaxUploadSize(2097152);
    	
    	return multipartResolver;
    }
}
