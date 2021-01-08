import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Violent;
import mysql.cars.ViolentBD;
/**
 * Servlet implementation class PatientShowServlet
 */
@WebServlet("/violent")
public class ViolentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		        ArrayList<Violent> violents = ViolentBD.select();
		        request.setAttribute("violents", violents);

		          
		        getServletContext().getRequestDispatcher("/showviolent.jsp").forward(request, response);
		    } 
  

}
