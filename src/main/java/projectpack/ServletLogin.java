package main.java.projectpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get request handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	// post request handler
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String em = "killo@mail.com", pass="pass123";
		//print writer
		PrintWriter out = response.getWriter();
		//dispatcher
		RequestDispatcher dispatcher = null;
		
		if(em.equals(email) && pass.equals(password)) {
			//request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("post.jsp");
		}
		else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request, response);
		// TODO1
		// 1. connect to db and check username and password
		// if true redirect to home page
		// else popup login failed error
	}

}
