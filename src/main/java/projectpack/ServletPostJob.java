package main.java.projectpack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

@WebServlet("/postjob") //
public class ServletPostJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //get request handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("post.jsp");
	}

	//post request handler
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobTitle = request.getParameter("jobTitle");
		String jobType = request.getParameter("jobType");
		String price =request.getParameter("price");
		String truckType = request.getParameter("truckType");
		String description = request.getParameter("description");
		
		//variables

        String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        
        String url = "jdbc:MySQL://localhost:3306/test12";

		try {

			String sql_command = "insert into jobList (title, jobType, truckType, description, price) values (?, ?, ?, ?, ?)";
			
			Class.forName(Driver);
			Connection myConn = DriverManager.getConnection(url,DBuser,DBpass);

			PreparedStatement myStmt = myConn.prepareStatement(sql_command);
			
			//myStmt.setInt(1, 111);
			myStmt.setString(1, jobTitle);
			myStmt.setString(2, jobType);
			myStmt.setString(3, truckType);
			myStmt.setString(4, description);
			myStmt.setString(5,  price);
			
			
			myStmt.executeUpdate();

			myConn.close();
		}

		catch(Exception e){
			e.printStackTrace();
		}
        
        PrintWriter out = response.getWriter();
		out.println("Success fully posted.."); 
		
	}

}
