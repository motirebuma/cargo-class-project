package main.java.projectpack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ServletRegister extends HttpServlet {
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
		//Image does not implemented...

		//JDBC
        String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";

		try {
																																			 //1  2  3  4  5  6  7  8  9 
			String sql_command = "insert into users (fullname, username, password, email, idnumber, region, town, kebele, housenumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Class.forName(Driver);
			Connection myConn = DriverManager.getConnection(url,DBuser,DBpass);

			PreparedStatement myStmt = myConn.prepareStatement(sql_command);
			
			myStmt.setString(1, fullname);
			myStmt.setString(2, username);
			myStmt.setString(3, password);
			myStmt.setString(4, email);
			myStmt.setString(5,  id);
			myStmt.setString(6, region);
			myStmt.setString(7, town);
			myStmt.setString(8,  kebele);
			myStmt.setString(9, house);
			
			myStmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.println("info saved..");

			myConn.close();
		}

		catch(Exception e){
			e.printStackTrace();
		}
		 
	}

}
