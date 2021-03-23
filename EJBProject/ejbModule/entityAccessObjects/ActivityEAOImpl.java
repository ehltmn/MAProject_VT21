package entityAccessObjects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import classesEJB.Activity;
import classesEJB.Person;

/**
 * Session Bean implementation class ActivityEAOImpl
 */
@Stateless
public class ActivityEAOImpl implements ActivityEAOLocal {
	
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public ActivityEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    //CRUD methods 
    public Activity createActivity(Activity activity) {
    	entityManager.persist(activity);
    	return activity;
    }
    
    public Activity findActivityByActivityNumber(String activityNumber) {
    	return entityManager.find(Activity.class, activityNumber);
    }
    
    public Activity updateActivity(Activity activity) {
    	entityManager.merge(activity);
    	return activity;
    }
    
    public void deleteActivity(String activityNumber) {
    	Activity a = this.findActivityByActivityNumber(activityNumber);
    	if (a != null) {
    		entityManager.remove(a);
    	}
    }

}
