//package com.traderfactory.config;
//
//import java.util.Properties;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.hibernate.ejb.HibernatePersistence;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
////@Configuration
////@EnableWebMvc
////@EnableTransactionManagement
////@ComponentScan("com.mvc")
////@PropertySource("classpath:application.properties")
////@EnableJpaRepositories(basePackages = {
////      "com.mvc.repository"
////})
//////@WebAppConfiguration
//public class AlternateConfig {
//
//	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
//  private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
//  private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
//  private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
//
//  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
//  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//  private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
//	
//	@Resource
//	private Environment env;
//
//	@Bean
//  public DataSource dataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//      dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
//      dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
//      dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
//      dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
//
//      return dataSource;
//  }
//	
//	@Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//      entityManagerFactoryBean.setDataSource(dataSource());
//      entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//      entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
//       
//      entityManagerFactoryBean.setJpaProperties(hibProperties());
//       
//      return entityManagerFactoryBean;
//  }
//
//  private Properties hibProperties() {
//      Properties properties = new Properties();
//      properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//      properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//      return properties;
//  }
//
//  @Bean
//  public JpaTransactionManager transactionManager() {
//      JpaTransactionManager transactionManager = new JpaTransactionManager();
//      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//      return transactionManager;
//  }
//
//  @Bean
//  public UrlBasedViewResolver setupViewResolver() {
//      UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//      resolver.setPrefix("/WEB-INF/pages/");
//      resolver.setSuffix(".jsp");
//      resolver.setViewClass(JstlView.class);
//      return resolver;
//  }
//	
//	
////FOR BACKUP
////	@Bean(destroyMethod = "close")
////	DataSource dataSource(Environment env) {
////		HikariConfig dataSourceConfig = new HikariConfig();
////		dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
////		dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
////		dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
////		dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
////
////		return new HikariDataSource(dataSourceConfig);
////	}
//	
//	
//	//FOR BACKUPS
////	@Bean
////	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
////			Environment env) {
////		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
////		entityManagerFactoryBean.setDataSource(dataSource);
////		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////		entityManagerFactoryBean.setPackagesToScan("net.petrikainulainen.springdata.jpa.todo");
////
////		Properties jpaProperties = new Properties();
////
////		//Configures the used database dialect. This allows Hibernate to create SQL
////		//that is optimized for the used database.
////		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
////
////		//Specifies the action that is invoked to the database when the Hibernate
////		//SessionFactory is created or closed.
////		jpaProperties.put("hibernate.hbm2ddl.auto", 
////				env.getRequiredProperty("hibernate.hbm2ddl.auto")
////				);
////
////		//Configures the naming strategy that is used when Hibernate creates
////		//new database objects and schema elements
////		jpaProperties.put("hibernate.ejb.naming_strategy", 
////				env.getRequiredProperty("hibernate.ejb.naming_strategy")
////				);
////
////		//If the value of this property is true, Hibernate writes all SQL
////		//statements to the console.
////		jpaProperties.put("hibernate.show_sql", 
////				env.getRequiredProperty("hibernate.show_sql")
////				);
////
////		//If the value of this property is true, Hibernate will format the SQL
////		//that is written to the console.
////		jpaProperties.put("hibernate.format_sql", 
////				env.getRequiredProperty("hibernate.format_sql")
////				);
////
////		entityManagerFactoryBean.setJpaProperties(jpaProperties);
////
////		return entityManagerFactoryBean;
////	}
////	
////	@Bean
////  JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
////      JpaTransactionManager transactionManager = new JpaTransactionManager();
////      transactionManager.setEntityManagerFactory(entityManagerFactory);
////      return transactionManager;
////  }
////	
////	//Add the other beans here
//
//}
