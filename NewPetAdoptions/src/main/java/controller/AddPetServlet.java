package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String species = request.getParameter("species");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Pet newPet = new Pet(name, species, age);
		PetHelper dao = new PetHelper();
		dao.insertPet(newPet);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,response);
	}

}
