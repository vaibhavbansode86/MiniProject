package com.npvsoftech.pbmart.ecommerce.registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Scanner;

public class Authentication extends Customer{
	//static Scanner sc = new Scanner(System.in);
//	private String Question;
//	private String Answer;
	public int user_id;

 public Boolean login() {
	 String password = null;
	 String pass=null;
	 boolean check=true;
	 ConnectToMysql obj1 = new ConnectToMysql();
	 while(check) {
		 try {
			 System.out.print("\nUser ID: ");
			 user_id=Integer.parseInt(sc.next());
			 System.out.print("\nPassword: ");
			 pass=sc.next();
			 check=false;
		 }
		 catch(NumberFormatException e) {
			 System.err.println("Invalid input.....");
		 }
	 }


	  try {
		Connection connection = obj1.connect();
		PreparedStatement prepareStatement = connection.prepareStatement("select password from minipro.userdetails where userId="+user_id+";");
		
		 
		ResultSet executeQuery = prepareStatement.executeQuery();
		
		executeQuery.next();
		password = executeQuery.getString(1);
	} catch (SQLException e) {
		e.printStackTrace();
	}
    	
 		if(pass.equals(password)) {
 			return true;
 		}else {
 			return false;
 		}
    	 
     }

     public void setAuthentication() {
 		
 		System.out.println("\nEnter your security question: ");
 		
 		setQuestion (sc.nextLine());
 		
 		System.out.println("\nEnter your answer: ");
 		
 		setAnswer (sc.nextLine());
 	}
	
     
   

}
