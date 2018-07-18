package com.kren.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kren.jpa.entity.TestUserEntity;
import com.kren.jpa.entity.util.DataUtil;
import com.kren.jpa.util.PersistenceUnit;

public class App {

    public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PersistenceUnit.NAME);
	EntityManager entityManager = factory.createEntityManager();
	entityManager.getTransaction()
	             .begin();

	TestUserEntity entity = DataUtil.getUser();

	entityManager.persist(entity);

	entityManager.getTransaction()
	             .commit();

	entityManager.close();
	factory.close();
    }
}
