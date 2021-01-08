import java.io.IOException;

import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Protokol;
import mysql.cars.ProtokolBD;

/**
 * Servlet implementation class PriyomShowServlet
 */
@WebServlet("/priyom")
public class ProtokolShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		        ArrayList<Protokol> priyoms = ProtokolBD.select();
		        request.setAttribute("priyom", priyoms);
		          
		        getServletContext().getRequestDispatcher("/showpriyom.jsp").forward(request, response);
		    } 

}
