package pl.akademiakodu.dao;

import pl.akademiakodu.model.Person;

import java.util.List;

/**
 * Created by Lenovo on 2016-12-07.
 */
public interface PersonDao {
    void save(Person person);
    List<Person> getAll();
    List<Person> findBySurname(String surname);
    void deleteById(Long id);
    Person find(Long id);
}
