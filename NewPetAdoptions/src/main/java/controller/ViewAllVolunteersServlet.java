package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Volunteer;

/**
 * Servlet implementation class ViewAllVolunteersServlet
 */
@WebServlet("/viewAllVolunteersServlet")
public class ViewAllVolunteersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllVolunteersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VolunteerHelper vh = new VolunteerHelper();
		List<Volunteer> vols = vh.getVolunteers();
		request.setAttribute("allVolunteers", vols);
		
		if(vols.isEmpty()) {
			getServletContext().getRequestDispatcher("/addVolunteerServlet").forward(request, response);
		}
		
		getServletContext().getRequestDispatcher("/all-volunteers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
