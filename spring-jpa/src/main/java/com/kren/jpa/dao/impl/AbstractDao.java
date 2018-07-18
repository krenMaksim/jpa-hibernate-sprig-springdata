package com.kren.jpa.dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

class AbstractDao {
    @PersistenceUnit
    protected EntityManagerFactory emf;
}
