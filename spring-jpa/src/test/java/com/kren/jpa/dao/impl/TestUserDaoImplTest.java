package com.kren.jpa.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kren.jpa.dao.TestUserDao;
import com.kren.jpa.entity.TestUserEntity;
import com.kren.jpa.entity.util.DataUtil;
import com.kren.jpa.spring.SpringJpaConfig;

public class TestUserDaoImplTest {

    private static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaConfig.class);

    private static TestUserDao testUserDao = ctx.getBean(TestUserDao.class);

    @Test
    void save() {
	testUserDao.save(DataUtil.getUser());
    }

    @Test
    void load() {
	TestUserEntity user = DataUtil.getUser();
	user.setUserId(14);

	assertEquals(user, testUserDao.load(14));
    }

    @Test
    void delete() {
	testUserDao.delete(13);
    }

    @Test
    void update() {
	TestUserEntity user = DataUtil.getUser();
	user.setUserId(1);
	user.setUserName("Max");
	testUserDao.update(user);
    }

    @Test
    void loadAll() {
	testUserDao.loadAll()
	           .forEach(i -> System.out.println(i));
    }
}
