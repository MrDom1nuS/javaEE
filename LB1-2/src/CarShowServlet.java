import java.io.IOException;


import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Car;
import mysql.cars.CarBD;


/**
 * Servlet implementation class DoctorShowServlet
 */
@WebServlet("/car")
public class CarShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		        ArrayList<Car> cars = CarBD.select();
		        request.setAttribute("cars", cars);
		          
		        getServletContext().getRequestDispatcher("/showcar.jsp").forward(request, response);
		    } 
 

}
