package main.java.projectpack;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String region = request.getParameter("region");
		String town = request.getParameter("town");
		String kebele = request.getParameter("kebele");
		String house = request.getParameter("house");
		
		PrintWriter out = response.getWriter();
		out.println(fullname); 
		out.println(username);
		out.println(password);
		out.println(email);
		out.println(id);
		out.println(region);
		out.println(town);
		out.println(kebele);
		out.println(house);
		
		 
	}

}
