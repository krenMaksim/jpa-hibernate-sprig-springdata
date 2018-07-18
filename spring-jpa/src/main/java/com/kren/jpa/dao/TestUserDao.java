package com.kren.jpa.dao;

import java.util.List;

import com.kren.jpa.entity.TestUserEntity;

public interface TestUserDao {
    void save(TestUserEntity entity);

    TestUserEntity load(int id);

    void delete(int id);

    void update(TestUserEntity entity);

    List<TestUserEntity> loadAll();
}
