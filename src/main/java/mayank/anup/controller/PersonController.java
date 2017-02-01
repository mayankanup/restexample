package mayank.anup.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mayank.anup.model.Person;
import mayank.anup.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@RequestMapping(method = RequestMethod.GET)
	public Hashtable<String, Person> getAll() {
		return ps.getAll();
	}

	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") String id) {
		return ps.getPerson(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person updatePerson(@RequestBody Person p){
		return ps.updatePerson(p);
	}
}
