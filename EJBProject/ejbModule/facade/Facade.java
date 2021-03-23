package facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import classesEJB.Activity;
import classesEJB.Person;
import entityAccessObjects.ActivityEAOLocal;
import entityAccessObjects.PersonEAOLocal;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeRemote, FacadeLocal {
	
	@EJB
	PersonEAOLocal personEAO;
	@EJB
	ActivityEAOLocal activityEAO;
	
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    
    //Person
    public Person findByPersonId(String personId) {
    	return personEAO.findPersonByPersonId(personId);
    }
    public Person createPerson(Person person) {
    	return personEAO.createPerson(person);
    }
    public Person updatePerson(Person person) {
    	return personEAO.updatePerson(person);
    }
    public void deletePerson(String personId) {
    	personEAO.deletePerson(personId);
    }
	
    //Activity
    public Activity findByActivityNumber(String activityNumber) {
    	return activityEAO.findActivityByActivityNumber(activityNumber);
    }
    
    public Activity createActivity(String activityNumber, String dateOfWorkout, String category, 
    		double distance, double workoutTime, String comment, String personId) {
    	
    	Activity newActivity = null;
    	
    	Person p = this.findByPersonId(personId);
    	
    	if (p != null && !activityNumber.equals("")) {
    		newActivity = new Activity();
    		newActivity.setActivityNumber(activityNumber);
    		newActivity.setDateOfWorkout(dateOfWorkout);
    		newActivity.setCategory(category);
    		newActivity.setDistance(distance);
    		newActivity.setWorkoutTime(workoutTime);
    		newActivity.setComment(comment);
    		
    		newActivity = activityEAO.createActivity(newActivity);
    		
    		newActivity.setPerson(p);
    		personEAO.updatePerson(p);
    		
    	}
    	return newActivity;
    }
    
    public Activity updateActivity(Activity activity) {
    	return activityEAO.updateActivity(activity);
    }
    
    public void deleteActivity(String activityNumber) {
    	activityEAO.deleteActivity(activityNumber);
    }
}
