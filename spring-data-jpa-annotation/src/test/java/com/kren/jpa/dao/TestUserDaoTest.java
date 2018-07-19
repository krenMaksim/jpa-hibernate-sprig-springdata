package com.kren.jpa.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kren.jpa.spring.SpringDataJpaAnnotationConfig;

public class TestUserDaoTest {

    private static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataJpaAnnotationConfig.class);

    private static TestUserDao testUserDao = ctx.getBean(TestUserDao.class);

    @Test
    void count() {

	System.out.println(testUserDao.count());
    }

    @Test
    void findAll() {

	testUserDao.findAll()
	           .forEach(i -> System.out.println(i));
    }
}
