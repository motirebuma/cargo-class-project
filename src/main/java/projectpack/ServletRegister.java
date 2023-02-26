package main.java.projectpack;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig
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
		String phone = request.getParameter("phone");
		String region = request.getParameter("region");
		String town = request.getParameter("town");
		String kebele = request.getParameter("kebele");
		String house = request.getParameter("house");
		String userType = request.getParameter("userType");

		// // get file and save to verification folder
		// InputStream inputStream = null;
		// OutputStream outputStream = null;
		// try {
		// 	Part filePart = request.getPart("id_file"); // "image" is the name of the input file field in the form
		// 	inputStream = filePart.getInputStream();
		// 	outputStream = new FileOutputStream("verification/image.jpg"); // Replace "path/to/save" with the actual path on your system
		// 	int read = 0;
		// 	final byte[] bytes = new byte[1024];
		// 	while ((read = inputStream.read(bytes)) != -1) {
		// 		outputStream.write(bytes, 0, read);
		// 	}
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// 	PrintWriter out = response.getWriter();
		// 	out.println(e.getMessage());
		// } finally {
		// 	if (inputStream != null) {
		// 		inputStream.close();
		// 	}
		// 	if (outputStream != null) {
		// 		outputStream.close();
		// 	}
		// }

		//JDBC
        String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";

		try {
																																			 		//1  2  3  4  5  6  7  8  9 
			String register_customer = "insert into customers (fullname, username, password, email, phone, region, town, kebele, housenumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String register_trucker = "insert into truckers (fullname, username, password, email, phone, region, town, kebele, housenumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Class.forName(Driver);
			Connection myConn = DriverManager.getConnection(url,DBuser,DBpass);
			
			if(userType.equals("Customer")){
				PreparedStatement myStmt = myConn.prepareStatement(register_customer);
				myStmt.setString(1, fullname);
				myStmt.setString(2, username);
				myStmt.setString(3, password);
				myStmt.setString(4, email);
				myStmt.setString(5,  phone);
				myStmt.setString(6, region);
				myStmt.setString(7, town);
				myStmt.setString(8,  kebele);
				myStmt.setString(9, house);
				
				myStmt.executeUpdate();
			}
			if(userType.equals("Trucker")){
				PreparedStatement myStmt = myConn.prepareStatement(register_trucker);
				myStmt.setString(1, fullname);
				myStmt.setString(2, username);
				myStmt.setString(3, password);
				myStmt.setString(4, email);
				myStmt.setString(5,  phone);
				myStmt.setString(6, region);
				myStmt.setString(7, town);
				myStmt.setString(8,  kebele);
				myStmt.setString(9, house);
				
				myStmt.executeUpdate();
			}
			
		
			// jquery
			// PrintWriter out = response.getWriter();
			// out.println("info saved..");
			// out.println(userType);


			myConn.close();
		}

		catch(Exception e){
			PrintWriter out = response.getWriter();
			out.println("already registered");
			out.println(userType);
			e.printStackTrace();
		}
		 
	}

}
