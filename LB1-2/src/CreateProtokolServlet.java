

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.cars.Protokol;
import mysql.cars.ProtokolBD;

/**
 * Servlet implementation class CreatePriyomServlet
 */
@WebServlet("/CreateProtokolServlet")
public class CreateProtokolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/create_protokol.jsp").forward(request, response);
		    }
		     
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        try {
		            String name = request.getParameter("name");
		            String protokol = request.getParameter("protokol");
		            Protokol priyom = new Protokol(name,protokol);
		            ProtokolBD.insert(priyom);
		            response.sendRedirect(request.getContextPath()+"/protokol");
		        }
		        catch(Exception ex) {
		             
		            getServletContext().getRequestDispatcher("/create_protokol.jsp").forward(request, response); 
		        }
		    }

}
