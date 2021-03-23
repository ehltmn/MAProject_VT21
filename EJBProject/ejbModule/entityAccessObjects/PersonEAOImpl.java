package entityAccessObjects;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import classesEJB.Person;

/**
 * Session Bean implementation class PersonEAOImpl
 */
@Stateless
public class PersonEAOImpl implements PersonEAOLocal {
	
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PersonEAOImpl() {
    	
    }
    
    //CRUD methods 
    public Person createPerson(Person person) {
    	entityManager.persist(person);
    	return person;
    }
    
    public Person findPersonByPersonId(String personId) {
    	return entityManager.find(Person.class, personId);
    }
    
    public Person updatePerson(Person person) {
    	entityManager.merge(person);
    	return person;
    }
    
    public void deletePerson(String personId) {
    	Person p = this.findPersonByPersonId(personId);
    	if (p != null) {
    		entityManager.remove(p);
    	}
    }
    
    //NamedQuery-methods
    public List<Person> findAll(){
    	TypedQuery<Person> query = entityManager.createNamedQuery("Person.findAll", Person.class);
    	
    	List<Person> results = query.getResultList();
    	return results;
    }
    
    //Other methods if neccessary

}
