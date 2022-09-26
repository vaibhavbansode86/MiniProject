package com.npvsoftech.pbmart.ecommerce.administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.npvsoftech.pbmart.ecommerce.design.Format1;
import com.npvsoftech.pbmart.ecommerce.registration.ConnectToMysql;

public class AdminAuthentication  {
	static Scanner sc = new Scanner(System.in);

	 public Boolean login() {
		 
		 String password = null;
		 ConnectToMysql obj1 = new ConnectToMysql();
		
		 System.out.print("\nUser ID: ");
			int user_id=Integer.parseInt(sc.next());
			System.out.print("\nPassword: ");
			String pass=sc.next();
		  try {
			Connection connection = obj1.connect();
			PreparedStatement prepareStatement = connection.prepareStatement("select password from minipro.admindetails where userId="+user_id+";");
			
			 
			ResultSet executeQuery = prepareStatement.executeQuery();
			
//			executeQuery.next();
			while(executeQuery.next()) {
			password = executeQuery.getString(1);}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    	
	 		if(pass.equals(password)) {
	 			Format1.starLineFormatting();
	 			System.out.println("Logged in successfully..........");
	 			Format1.starLineFormatting();
	 			return true;
	 		}else {
	 			Format1.starLineFormatting();
	 			System.err.println("\nYou have entered wrong password.\nPlease visit your Branch Head to recover password.");
	 			Format1.starLineFormatting();
	 			return false;
	 		}
	    	 
	     }

	 
		public void setPassword() throws Exception {
			String password=null;
			String password1=null;
	
			ConnectToMysql obj1 = new ConnectToMysql();

			Connection connection = obj1.connect();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select password from minipro.admindetails where userId=1998;");
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
			password=rs.getString(1);
			
			}
			System.out.print("Enter your old password : ");
			password1=sc.next();
			if(password.equals(password1)) {
				System.out.print("Enter new password : ");
				password=sc.next();
				PreparedStatement ps = connection
						.prepareStatement("update minipro.admindetails set password = "+password+"where userId=1998;");
				ps.executeUpdate();
			}
		}
}
