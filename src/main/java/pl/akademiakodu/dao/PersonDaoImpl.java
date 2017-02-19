package pl.akademiakodu.dao;

import org.springframework.stereotype.Repository;

import pl.akademiakodu.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class PersonDaoImpl extends GenericDao<Person> implements PersonDao {

    @Override
    @Transactional
    public List<Person> getAll() {
        // SELECT * FROM PERSON
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Person> findBySurname(String surname) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.surname='"+surname+"'");
        return query.getResultList();
    }
/*
    @Override
    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.id="+id);
        return query.getResultList();
    }
*/

    @Override
    @Transactional
    public void deleteById(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    @Transactional
    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }
}
