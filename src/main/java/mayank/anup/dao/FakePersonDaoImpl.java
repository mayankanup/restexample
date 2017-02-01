package mayank.anup.dao;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mayank.anup.model.Person;

@Repository
@Qualifier("fakedata")
public class FakePersonDaoImpl implements PersonDao {
	static Hashtable<String, Person> persons;
	static{
		persons = new Hashtable<String,Person>();
		Person p = new Person("1","Steve","Smith",21);
		persons.put("1", p);
		p = new Person("2","Anup","Mayank",30);
		persons.put("2", p);
		p = new Person("3","Matt","Mckune",33);
		persons.put("3", p);
	}
	/* (non-Javadoc)
	 * @see mayank.anup.dao.PersonDao#getPerson(java.lang.String)
	 */
	@Override
	public Person getPerson(String id) {
		return persons.get(id);
	}
	/* (non-Javadoc)
	 * @see mayank.anup.dao.PersonDao#getAll()
	 */
	@Override
	public Hashtable<String, Person> getAll() {
		return persons;
	}
	/* (non-Javadoc)
	 * @see mayank.anup.dao.PersonDao#updatePerson(mayank.anup.model.Person)
	 */
	@Override
	public Person updatePerson(Person p) {
		Person per = persons.get(p.getId());
		if(per!=null){
			per.setAge(p.getAge());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
		}else{
			per = new Person();
			per.setId(p.getId());
			per.setAge(p.getAge());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			persons.put(p.getId(), per);
		}
		return per;
	}
}
