package classesEJB;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p"), 
	@NamedQuery(name="Person.findByName", query="SELECT p FROM Person p WHERE p.name LIKE: name"),
})
@Table(name="Person")
public class Person implements Serializable {
	
	private String personId;
	private String name;
	private String address;
	private String username;
	private String password;
	private Set<Activity> activities; //One person can register many activities
	
	@Id
	@Column(name="personId")
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy="person", fetch=FetchType.EAGER)
	public Set<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	} 
	
	

}
