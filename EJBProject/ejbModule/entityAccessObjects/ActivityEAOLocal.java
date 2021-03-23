package entityAccessObjects;

import javax.ejb.Local;

import classesEJB.Activity;

@Local
public interface ActivityEAOLocal {
	public Activity createActivity(Activity activity);
	public Activity findActivityByActivityNumber(String activityNumber);
	public Activity updateActivity(Activity activity);
	public void deleteActivity(String activityNumber);
}
