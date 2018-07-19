package com.kren.jpa.spring;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.kren.jpa.util.PersistenceUnit;

@EnableJpaRepositories(basePackages = { "com.kren.jpa.dao" })
@ComponentScan("com.kren.jpa.dao")
@Configuration
public class SpringDataJpaVersionConfig {

    private EntityManagerFactory emf;

    @Bean
    EntityManagerFactory entityManagerFactory() {
	this.emf = Persistence.createEntityManagerFactory(PersistenceUnit.NAME);
	return emf;

    }

    @Bean
    public PlatformTransactionManager transactionManager() {
	JpaTransactionManager txManager = new JpaTransactionManager();
	txManager.setEntityManagerFactory(entityManagerFactory());
	return txManager;
    }

    @PreDestroy
    private void destroy() {
	emf.close();
    }
}
