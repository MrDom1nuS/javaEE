

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Car;
import mysql.cars.CarBD;

/**
 * Servlet implementation class EditDoctorServlet
 */
@WebServlet("/edit_car")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            Car car = CarBD.selectOne(id);
		            if(car!=null) {
		                request.setAttribute("car", car);
		                getServletContext().getRequestDispatcher("/edit_car.jsp").forward(request, response);
		            }
		            else {
		                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		            }
		        }
		        catch(Exception ex) {
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		        }
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            String name = request.getParameter("name");
		            String model = request.getParameter("model");
		            Car car = new Car(id, name, model);
		            CarBD.update(car);
		            response.sendRedirect(request.getContextPath() + "/car");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
		        }
		    }
}
