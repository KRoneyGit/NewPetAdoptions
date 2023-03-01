import java.util.ArrayList;
import java.util.List;

import controller.VolunteerHelper;
import model.Pet;
import model.Volunteer;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Feb 28, 2023
*/
public class VolunteerTester {
	public static void main(String[] args) {
		
		VolunteerHelper vh = new VolunteerHelper();
		
		Pet haven = new Pet("Haven", "dog", 5);
		Pet havek = new Pet("Havek", "dog", 3);
		Pet zuli = new Pet("Zuli", "dog", 2);
		
		List<Pet> cameronsPets = new ArrayList<Pet>();
		cameronsPets.add(haven);
		cameronsPets.add(havek);
		cameronsPets.add(zuli);

		Volunteer cameron = new Volunteer("Cameron");
		cameron.setListOfPets(cameronsPets);
		
		vh.insertNewVolunteer(cameron);
		
		List<Volunteer> allVolunteers = vh.getVolunteers();
		for(Volunteer v: allVolunteers) {
			System.out.println(v.toString());
		}
	}
}
