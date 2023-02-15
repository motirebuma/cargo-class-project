package main.java.projectpack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class userinfoJDBC{
public ArrayList<Info> getUserInfo() {
		
		ArrayList<Info> infoRec = new ArrayList<Info>();
		
		//variables
        
		String DBuser = "root";
        String DBpass = "password123";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/test12";
        
		try {
			String sql_command = "select fullname, username, email ,phone , region, town, kebele, housenumber from truckers where email='moti@mail.com'"; //where email=dsafsfa
			//String sql_command ="select count(*) from jobList";

			Class.forName(Driver);
			
			Connection con = DriverManager.getConnection(url,DBuser,DBpass);
			
			Statement statement = con.createStatement();

			ResultSet result = statement.executeQuery(sql_command);
			
			while(result.next()) {
				Info info = new Info();
				
                info.setFullname(result.getString("fullname"));
                info.setUsername(result.getString("username"));
                info.setEmail(result.getString("email"));
                info.setPhone(result.getString("phone"));
                info.setRegion(result.getString("region"));
                info.setTown(result.getString("town"));
                info.setKebele(result.getString("kebele"));
                info.setHauseNumber(result.getString("housenumber"));
				
				infoRec.add(info);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return infoRec;
	}
}
