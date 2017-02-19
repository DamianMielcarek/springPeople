package pl.akademiakodu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Book;

// spring data

@Repository
public interface BookDao extends CrudRepository<Book,Long> {
    /*
    save(entity) - zapisywanie do bazy
    findOne(id) - znajduje obiekt o danym id
    findAll() - zwraca wszystkie
    delete(id) - usuwa rekord o danym id
    deleteAll() - usuwa wszystkie
    count() - zlicza ilość
    exists(id) - sprawdza czy istnieje dany rekord
     */

}
