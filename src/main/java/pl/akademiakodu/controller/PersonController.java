package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.dao.PersonDao;
import pl.akademiakodu.model.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping("/people/add")
    public String add(ModelMap modelMap) {
        modelMap.put("person", new Person("Zdzisław", "Python"));
        return "people/add";
    }

    @PostMapping("people/create")
    public String create(@ModelAttribute Person person, ModelMap modelMap) {
        personDao.save(person);
        return "people/success";
    }

    @GetMapping("people/all")
    public String index(ModelMap modelMap) {
        modelMap.put("people", personDao.getAll());
        return "people/all";
    }

    @GetMapping("people/search")
    public String search(ModelMap modelMap) {
        modelMap.put("person", new Person());
        return "people/search";
    }


    /*
    @GetMapping("people/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap) {
        String surname = person.getSurname();
        modelMap.put("people", personDao.findBySurname(surname));
        return "people/all";
    }
    */
    @GetMapping("people/results")
    public String results(HttpServletRequest request, ModelMap modelMap) {
        Map<String, String[]> parameters = request.getParameterMap();
        String value = parameters.get("surname")[0];
        modelMap.put("people", personDao.findBySurname(value));
        return "people/all";
    }


    @GetMapping("people/{id}")
    public String delete(@PathVariable Long id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Usunięto osobę z bazy");
        System.out.println("Do usunięcia "+id);
        personDao.deleteById(id);
        modelMap.put("people", personDao.getAll());
        return "redirect:/people/all";
    }
}
