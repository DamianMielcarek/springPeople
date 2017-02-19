package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.dao.BookDao;
import pl.akademiakodu.dao.PersonDao;
import pl.akademiakodu.model.Book;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PersonDao personDao;

    @GetMapping("/books/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("people", personDao.getAll());
        return "books/add";
    }

    @PostMapping("/books/create")
    public String create(@ModelAttribute Book book, ModelMap modelMap) {
        System.out.println("LOG DODAJEMY"+book);
        long id = book.getPerson().getId();
        book.setPerson(personDao.find(id));
        bookDao.save(book);
        return "people/success";
    }

}
