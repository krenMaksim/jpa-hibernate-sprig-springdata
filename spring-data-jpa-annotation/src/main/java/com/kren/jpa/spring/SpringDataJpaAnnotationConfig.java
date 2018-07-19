package com.kren.jpa.spring;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories("com.kren.jpa.dao")
@ComponentScan("com.kren.jpa.dao")
@PropertySource("classpath:postgres.properties")
@Configuration
public class SpringDataJpaAnnotationConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
	PGPoolingDataSource dataSource = new PGPoolingDataSource();
	dataSource.setUrl(env.getProperty("pg.test.jpa.url"));
	dataSource.setUser(env.getProperty("pg.login"));
	dataSource.setPassword(env.getProperty("pg.password"));
	dataSource.setInitialConnections(Integer.parseInt(env.getProperty("pg.initcon")));
	dataSource.setMaxConnections(Integer.parseInt(env.getProperty("pg.maxcon")));

	return dataSource;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);

	Properties jpaProperties = new Properties();
	jpaProperties.setProperty("hibernate.format_sql", "true");

	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("com.kren.jpa.entity");
	factory.setDataSource(dataSource());
	factory.setJpaProperties(jpaProperties);

	return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

	JpaTransactionManager txManager = new JpaTransactionManager();
	txManager.setEntityManagerFactory(entityManagerFactory);
	return txManager;
    }
}
