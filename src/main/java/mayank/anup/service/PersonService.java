package mayank.anup.service;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mayank.anup.dao.PersonDao;
import mayank.anup.model.Person;

@Service
public class PersonService {
	
	@Autowired
	@Qualifier("h2data")
	PersonDao personDao;
	
	
	public Person getPerson(String id) {
		return personDao.getPerson(id);
	}
	
	public Hashtable<String, Person> getAll() {
		return personDao.getAll();
	}

	public Person updatePerson(Person p) {
		return personDao.updatePerson(p);
	}
}