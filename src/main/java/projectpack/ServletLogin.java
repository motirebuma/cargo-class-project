package main.java.projectpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get request handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	// post request handler
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// credentials from user
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");

	
		// String em = "astu@mail.com", pass="pass123";
		RequestDispatcher dispatcher = null;

		String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";

		// db creds
		// String email_db = null;
		String pass_db = null;
        
        try {
            String sql_command = null;
            if(userType.equals("Customer")){
                sql_command = "select password from customers where email=\'"+email+"\'";
            }
            if(userType.equals("Trucker")){
                sql_command = "select password from truckers where email=\'"+email+"\'";
            }

            Class.forName(Driver);
            
            Connection con = DriverManager.getConnection(url,DBuser,DBpass);
            
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(sql_command);
            
            while(result.next()) {
                pass_db = result.getString("password");            
            }
            if(pass_db.equals(password) && userType.equals("Customer")){
                //request.setAttribute("status", "success");
                HttpSession session = request.getSession();
                session.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("jobs");
            }
            else if(pass_db.equals(password) && userType.equals("Trucker")){
                //request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("jobslist");
            }
            else{
                request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
            
        }catch (Exception e) {
            // request.setAttribute("status", "failed");
			// dispatcher = request.getRequestDispatcher("login.jsp");
            // dispatcher.forward(request, response);
            PrintWriter out = response.getWriter();
            out.print(e.getMessage());

            e.printStackTrace();
        }
	}

}
