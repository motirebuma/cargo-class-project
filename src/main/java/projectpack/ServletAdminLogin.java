package main.java.projectpack;

import java.io.IOException;
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

@WebServlet("/admin_login")
public class ServletAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get request handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("adminLogin.jsp");
	}

	// post request handler
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

        //db
        String user = "";
        String pass = "";

        //dispatcher
        RequestDispatcher dispatcher = null;
        String DBuser = "root";
            String DBpass = "password123";
            String Driver = "com.mysql.cj.jdbc.Driver";
            
            String url = "jdbc:MySQL://localhost:3306/test12";

            
            try {
                String sql_command = "select * from admin";

                Class.forName(Driver);
                
                Connection con = DriverManager.getConnection(url,DBuser,DBpass);
                
                Statement statement = con.createStatement();
    
                ResultSet result = statement.executeQuery(sql_command);
                
                while(result.next()) {
                    user = result.getString("username");
                    pass = result.getString("password");                
                }
                if(user.equals(username) && pass.equals(password)){
                    dispatcher = request.getRequestDispatcher("post.jsp");
                }
                else{
                    request.setAttribute("status", "failed");
			        dispatcher = request.getRequestDispatcher("adminLogin.jsp");
                }
                dispatcher.forward(request, response);
                
            }catch (Exception e) {
                e.printStackTrace();
            }

	}

}
