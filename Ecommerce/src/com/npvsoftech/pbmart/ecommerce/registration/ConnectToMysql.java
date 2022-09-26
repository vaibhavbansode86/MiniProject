package com.npvsoftech.pbmart.ecommerce.registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectToMysql {
	
	Connection connection;
	//PreparedStatement prepareStatement;
	
public Connection connect() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","online123");
			
			//prepareStatement = connection.prepareStatement("insert into CustomerDetails(firstName,lastName,birthdate,city,dist,state,pincode,email)values(?,?,?,?,?,?,?,?)");
								
			
		} catch (ClassNotFoundException e) {
			//Access denied for user 'root'@'localhost' (using password: YES)
			e.printStackTrace();
		}
		return this.connection;
	}
	

}
