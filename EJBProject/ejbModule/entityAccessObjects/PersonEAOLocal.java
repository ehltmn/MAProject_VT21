package entityAccessObjects;

import javax.ejb.Local;

import classesEJB.Person;

@Local
public interface PersonEAOLocal {
	public Person createPerson(Person person);
	public Person findPersonByPersonId(String personId);
	public Person updatePerson(Person person);
	public void deletePerson(String personId);
}
