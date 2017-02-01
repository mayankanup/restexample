package mayank.anup.dao;

import java.util.Hashtable;

import mayank.anup.model.Person;

public interface PersonDao {

	Person getPerson(String id);

	Hashtable<String, Person> getAll();

	Person updatePerson(Person p);

}