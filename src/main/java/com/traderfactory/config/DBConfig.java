//package com.traderfactory.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration 
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//public class DBConfig {
//
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
//		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
//		lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
//		lcemfb.setDataSource(getDataSource());
//		lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
//		lcemfb.setPackagesToScan("com.traderfactory.domain");
//		lcemfb.setJpaProperties(jpaProperties());
//		return lcemfb;
//	}
//	@Bean
//	public JpaVendorAdapter getJpaVendorAdapter() {
//		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		return adapter;
//	}
//	@Bean
//	public DataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
////		dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
////		dataSource.setUrl(env.getProperty("spring.datasource.url"));
////		dataSource.setUsername(env.getProperty("spring.datasource.username"));
////		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//		dataSource.setDriverClassName("PostgreSQL JDBC Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/paybox");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("Qwerty1234");
//		return dataSource;
//	}
//	@Bean
//	public PlatformTransactionManager txManager(){
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
//				getEntityManagerFactoryBean().getObject());
//		return jpaTransactionManager;
//	}
//
//	private Properties jpaProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
//		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//		return properties;        
//	}	
//} 
