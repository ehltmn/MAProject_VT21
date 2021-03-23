package facade;

import javax.ejb.Remote;

import classesEJB.Activity;
import classesEJB.Person;

@Remote
public interface FacadeRemote {
	
	//Signatures - Person
		public Person findByPersonId(String personId);
		public Person createPerson(Person person);
		public Person updatePerson(Person person);
		public void deletePerson(String personId);
		
		//Signatures - Activity
		public Activity findByActivityNumber(String activityNumber);
		public Activity createActivity(String activityNumber, String dateOfWorkout, String category, 
	    		double distance, double workoutTime, String comment, String personId);
		public Activity updateActivity(Activity activity);
		public void deleteActivity(String activityNumber);

}
