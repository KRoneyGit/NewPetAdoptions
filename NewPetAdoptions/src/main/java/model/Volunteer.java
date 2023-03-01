package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Feb 28, 2023
*/
@Entity
public class Volunteer {
	@Id
	@GeneratedValue
	private int id;
	String volunteerName;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Pet> listOfPets;
	
	public Volunteer() {
		super();
	}
	
	/**
	 * @param id
	 * @param volunteerName
	 * @param listOfPets
	 */
	public Volunteer(int id, String volunteerName, List<Pet> listOfPets) {
		super();
		this.id = id;
		this.volunteerName = volunteerName;
		this.listOfPets = listOfPets;
	}
	
	/**
	 * @param volunteerName
	 * @param listOfPets
	 */
	public Volunteer(String volunteerName, List<Pet> listOfPets) {
		super();
		this.volunteerName = volunteerName;
		this.listOfPets = listOfPets;
	}
	
	/**
	 * @param volunteerName
	 */
	public Volunteer(String volunteerName) {
		super();
		this.volunteerName = volunteerName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVolunteerName() {
		return volunteerName;
	}
	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}
	public List<Pet> getListOfPets() {
		return listOfPets;
	}
	public void setListOfPets(List<Pet> listOfPets) {
		this.listOfPets = listOfPets;
	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", volunteerName" + volunteerName + ", listOfPets=" + listOfPets + "]";
	}
}
