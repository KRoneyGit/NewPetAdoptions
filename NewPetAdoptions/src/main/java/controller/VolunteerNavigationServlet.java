package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Volunteer;

/**
 * Servlet implementation class VolunteerNavigationServlet
 */
@WebServlet("/volunteerNavigationServlet")
public class VolunteerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VolunteerHelper dao = new VolunteerHelper();
		String act = request.getParameter("doThisToVolunteer");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("viewAllVolunteersServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Volunteer volunteerToDelete = dao.searchForVolunteerById(tempId);
				dao.deleteVolunteer(volunteerToDelete);
				getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
				getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
			} 
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Volunteer volunteerToEdit = dao.searchForVolunteerById(tempId);
				request.setAttribute("volunteerToEdit", volunteerToEdit);
				
				PetHelper daoForPets = new PetHelper();
				
				request.setAttribute("allPets", daoForPets.showAllPets());
				
				if(daoForPets.showAllPets().isEmpty()) {
					request.setAttribute("allPets", " ");
				}
				getServletContext().getRequestDispatcher("/edit-volunteer.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
				getServletContext().getRequestDispatcher("/viewAllVolunteersServlet").forward(request, response);
			} 
		} else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addVolunteerServlet").forward(request, response);
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
