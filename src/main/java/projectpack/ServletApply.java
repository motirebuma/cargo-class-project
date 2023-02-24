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

@WebServlet("/apply")
public class ServletApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("apply.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String jobID = request.getParameter("jobID");
		String message = request.getParameter("message");
		String jobOwner = request.getParameter("jobOwner");

		
		//Image does not implemented...

        // PrintWriter out = response.getWriter();
        // out.println(fullname);
        // out.println(email);
        // out.println(phone);
        // out.println(message);

		//JDBC
        String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";

		try {
																							   				//1  2  3  4  5  6
			String sql_command = "insert into applyJob (name, email, phone, jobID, message, jobOwner) values (?, ?, ?, ?, ?, ?)";
			
			Class.forName(Driver);
			Connection myConn = DriverManager.getConnection(url,DBuser,DBpass);

			PreparedStatement myStmt = myConn.prepareStatement(sql_command);
			
			myStmt.setString(1, fullname);
			myStmt.setString(2, email);
			myStmt.setString(3, phone);
			myStmt.setString(4,  jobID);
			myStmt.setString(5, message);
			myStmt.setString(6, jobOwner);


			
			myStmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.println("apply succeded..");
			myConn.close();
		}

		catch(Exception e){
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
			// out.println("you are already applied for this job..");
			e.printStackTrace();
		}
		 
	}

}
