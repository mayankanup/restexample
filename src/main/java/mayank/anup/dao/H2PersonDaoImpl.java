package mayank.anup.dao;

import java.util.Hashtable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mayank.anup.model.Person;

@Repository
@Qualifier("h2data")
public class H2PersonDaoImpl implements PersonDao {

	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Person getPerson(String id) {
		EntityManager em = emf.createEntityManager();
		Person p = em.find(Person.class, id);
		return p;
	}

	@Override
	public Hashtable<String, Person> getAll() {
		Hashtable <String, Person> personMap = new Hashtable<String, Person>();
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createQuery("from Person", Person.class).getResultList();
		if(persons!=null && persons.size()>0){
			for(Person p: persons){
				personMap.put(p.getId(), p);
			}
		}
		return personMap;
	}

	@Override
	public Person updatePerson(Person p) {
		Person saved = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		saved = em.merge(p);
		em.getTransaction().commit();
		return saved;
	}

}
