package pl.akademiakodu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.akademiakodu.dao.PersonDao;
import pl.akademiakodu.model.Person;

@SpringBootApplication
public class SpringPeopleApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx =
        SpringApplication.run(SpringPeopleApplication.class, args);
/*
        PersonDao personDao = ctx.getBean(PersonDao.class);
        Person person = new Person("Jan", "Kowalski");
        personDao.save(person);

        ctx.close();
        */
	}
}
