

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Car;
import mysql.cars.CarBD;


/**
 * Servlet implementation class CreateDoctorServlet
 */
@WebServlet("/create_car")
public class CreateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_car.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String name = request.getParameter("name");
		            String special = request.getParameter("model");
		            Car car = new Car(name, special);
		            CarBD.insert(car);
		            response.sendRedirect(request.getContextPath()+"/car");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_car.jsp").forward(request, response); 
		        }
		    }


}
