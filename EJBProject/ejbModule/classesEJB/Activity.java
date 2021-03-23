package classesEJB;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Activity")
public class Activity implements Serializable {
	
	private String activityNumber;
	private String dateOfWorkout;
	private String category;
	private double distance;
	private double workoutTime;
	private String comment; 
	private Person person; //Given one activity, can only belong to one person
	
	@Id
	@Column(name="activityNumber")
	public String getActivityNumber() {
		return activityNumber;
	}
	public void setActivityNumber(String activityNumber) {
		this.activityNumber = activityNumber;
	}
	
	@Column(name="dateOfWorkout")
	public String getDateOfWorkout() {
		return dateOfWorkout;
	}
	public void setDateOfWorkout(String dateOfWorkout) {
		this.dateOfWorkout = dateOfWorkout;
	}
	
	@Column(name="category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="distance")
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Column(name="workhoutTime")
	public double getWorkoutTime() {
		return workoutTime;
	}
	public void setWorkoutTime(double workoutTime) {
		this.workoutTime = workoutTime;
	}
	
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne
	@JoinColumn(name="pId", referencedColumnName ="personId")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
