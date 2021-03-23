package entityAccessObjects;

import java.util.List;

import javax.ejb.Local;

import classesEJB.Person;

@Local
public interface PersonEAOLocal {
	public Person createPerson(Person person);
	public Person findPersonByPersonId(String personId);
	public Person updatePerson(Person person);
	public void deletePerson(String personId);
	
	//NamedQuery signatures
	public List<Person> findAll();
}
