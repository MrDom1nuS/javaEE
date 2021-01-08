import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Violent;
import mysql.cars.ViolentBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditViolentServlet
 */
@WebServlet("/edit_violent")
public class EditViolentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            int id = Integer.parseInt(request.getParameter("id"));
		            Violent violent = ViolentBD.selectOne(id);
		            if(violent!=null) {
		                request.setAttribute("violent", violent);
		                getServletContext().getRequestDispatcher("/edit_violent.jsp").forward(request, response);
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
		            String violent = request.getParameter("violent");
		            Violent violent = new Violent(id, name, violent);
		            ViolentBD.update(violent);
		            response.sendRedirect(request.getContextPath() + "/violent");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
		        }
		    }
}
