package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;
import model.Volunteer;

/**
 * Servlet implementation class CreateNewVolunteerServlet
 */
@WebServlet("/createNewVolunteerServlet")
public class CreateNewVolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewVolunteerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("volunteerName").trim().equals("")) {
			getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
		}else {
			PetHelper ph = new PetHelper();
			String volunteerName = request.getParameter("volunteerName");
			System.out.println("Volunteer Name: " + volunteerName);
			
			String[] selectedPets = request.getParameterValues("allPetsToAdd");
			List<Pet> selectedPetsInList = new ArrayList<Pet>();
			if( selectedPets != null && selectedPets.length > 0) {
				for(int i = 0; i < selectedPets.length; i++) {
					System.out.println(selectedPets[i]);
					Pet p = ph.searchForPetById(Integer.parseInt(selectedPets[i]));
					selectedPetsInList.add(p);
				}
			}
			
			Volunteer vol = new Volunteer(volunteerName);
			
			vol.setListOfPets(selectedPetsInList);
			VolunteerHelper vh = new VolunteerHelper();
			vh.insertNewVolunteer(vol);
			
			System.out.println("Success");
			System.out.println(vol.toString());
			
			getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
