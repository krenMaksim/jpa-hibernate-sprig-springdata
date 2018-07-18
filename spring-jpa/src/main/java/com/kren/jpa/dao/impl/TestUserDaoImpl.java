package com.kren.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.kren.jpa.dao.TestUserDao;
import com.kren.jpa.entity.TestUserEntity;

@Repository("testUserDao")
public class TestUserDaoImpl extends AbstractDao implements TestUserDao {

    @Override
    public void save(TestUserEntity entity) {
	EntityManager em = emf.createEntityManager();
	em.getTransaction()
	  .begin();

	em.persist(entity);

	em.getTransaction()
	  .commit();

	em.close();

    }

    @Override
    public TestUserEntity load(int id) {
	EntityManager em = emf.createEntityManager();

	TestUserEntity user = em.find(TestUserEntity.class, id);

	em.close();

	return user;
    }

    @Override
    public void delete(int id) {
	EntityManager em = emf.createEntityManager();
	TestUserEntity user = em.find(TestUserEntity.class, id);

	em.getTransaction()
	  .begin();

	em.remove(user);
	em.getTransaction()
	  .commit();

	em.close();
    }

    @Override
    public void update(TestUserEntity entity) {
	EntityManager em = emf.createEntityManager();

	em.getTransaction()
	  .begin();

	em.merge(entity);

	em.getTransaction()
	  .commit();

	em.close();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TestUserEntity> loadAll() {
	EntityManager em = emf.createEntityManager();

	List<TestUserEntity> users = em.createNativeQuery("SELECT * FROM public.test_user", TestUserEntity.class)
	                               .getResultList();
	em.close();

	return users;
    }
}
