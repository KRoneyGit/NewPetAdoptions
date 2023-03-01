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
 * Servlet implementation class EditVolunteerServlet
 */
@WebServlet("/editVolunteerServlet")
public class EditVolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVolunteerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VolunteerHelper dao = new VolunteerHelper();


		if (request.getParameter("volunteerName").trim().equals("")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Volunteer volunteerToDelete = dao.searchForVolunteerById(tempId);
				dao.deleteVolunteer(volunteerToDelete);
				getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
				getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
			} 
		}

		
		
		PetHelper ph = new PetHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Volunteer volunteerToUpdate = dao.searchForVolunteerById(tempId);
		
		String newVolunteerName = request.getParameter("volunteerName");
		
		try {
			String[] selectedPets = request.getParameterValues("allPetsToAdd");
			List<Pet> selectedPetsInList = new ArrayList<Pet>();
			for (int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				Pet p = ph.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(p);
			}
			volunteerToUpdate.setListOfPets(selectedPetsInList);
		} catch (NullPointerException e) {
			List<Pet> selectedPetsInList = new ArrayList<Pet>();
		}
		
		volunteerToUpdate.setVolunteerName(newVolunteerName);
		
		dao.updateVolunteer(volunteerToUpdate);

		getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
