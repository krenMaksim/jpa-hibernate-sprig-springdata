package com.kren.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.kren.jpa.entity.TestUserEntity;

public interface TestUserDao extends CrudRepository<TestUserEntity, Integer> {

}
