package pl.akademiakodu.dao;


import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public abstract class GenericDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

}
