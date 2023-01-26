package main.java.projectpack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public class jobsJDBC{
public ArrayList<Jobs> getjobsResultSet() {
		
		ArrayList<Jobs> jobRecSet = new ArrayList<Jobs>();
		
		//variables
		String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";
        
		try {
			String sql_command = "select id, title, jobType ,truckType , description, price from jobList";
			//String sql_command ="select count(*) from jobList";

			Class.forName(Driver);
			
			Connection con = DriverManager.getConnection(url,DBuser,DBpass);
			
			Statement statement = con.createStatement();

			ResultSet result = statement.executeQuery(sql_command);
			
			while(result.next()) {
				Jobs job = new Jobs();
				
				job.setId(result.getInt(1));
				job.setTitle(result.getString(2));
				job.setJobType(result.getString(3));
				job.setTruckType(result.getString(4));
				job.setPrice(result.getString(5));
				job.setDescription(result.getString(6));
				
				jobRecSet.add(job);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jobRecSet;
	}
}
