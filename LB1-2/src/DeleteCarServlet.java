

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Car;
import mysql.cars.CarBD;



/**
 * Servlet implementation class DeletecarServlet
 */
@WebServlet("/deletecar")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		         
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));          
		            CarBD.delete(id);
		            response.sendRedirect(request.getContextPath() + "/car");
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }
}
