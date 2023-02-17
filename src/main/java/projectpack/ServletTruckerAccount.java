package main.java.projectpack;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/tr_account")
public class ServletTruckerAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	
	//get request handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
        // out.print(userEmail);
		try{
            request.setAttribute("infoRec", new userinfoJDBC().getUserInfo());
		    dispatcher = request.getRequestDispatcher("trucker/tr_account.jsp");
		    dispatcher.forward(request, response);
        }
        catch(Exception e)
        {
            PrintWriter out = response.getWriter();
            out.print(e.getMessage());
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}