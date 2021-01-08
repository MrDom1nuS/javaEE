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
 * Servlet implementation class CreatePacientServlet
 */
@WebServlet("/create_violent")
public class CreateViolentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_violent.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String name = request.getParameter("name");
		            String skarga = request.getParameter("violnet");
		            Violent pacient = new Violent(name, skarga);
		            ViolentBD.insert(pacient);
		            response.sendRedirect(request.getContextPath()+"/violent");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_violent.jsp").forward(request, response); 
		        }
		    }

}
