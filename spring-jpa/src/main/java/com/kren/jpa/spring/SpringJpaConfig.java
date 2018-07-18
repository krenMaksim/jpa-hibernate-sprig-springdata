package com.kren.jpa.spring;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.kren.jpa.util.PersistenceUnit;

@Configuration
@ComponentScan("com.kren.jpa.dao.impl")
public class SpringJpaConfig {

    private LocalEntityManagerFactoryBean factory;

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	this.factory = new LocalEntityManagerFactoryBean();
	factory.setPersistenceUnitName(PersistenceUnit.NAME);
	return factory;
    }

    @PreDestroy
    private void destroy() {
	factory.destroy();
    }
}
