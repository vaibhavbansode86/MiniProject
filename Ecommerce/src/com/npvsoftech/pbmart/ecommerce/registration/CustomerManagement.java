package com.npvsoftech.pbmart.ecommerce.registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.npvsoftech.pbmart.ecommerce.design.Format1;
import com.npvsoftech.pbmart.ecommerce.util.Managable;

public class CustomerManagement extends Authentication implements Managable{

	@Override
	public void addNewCustomer() throws SQLException, Exception {
		//Scanner sc = new Scanner(System.in);
		 //Authentication obj1=new Authentication();
		//	 char c = 'y' ;
	   	// while(c =='y') {
		  ConnectToMysql obj1 = new ConnectToMysql();
			 
		  Connection connection = obj1.connect();
		  
	       System.out.print(" \nEnter your first name :  ");
			
	       setFirstName(sc.next());
			
			System.out.print(" \nEnter your last name :  ");
			setLastName(sc.next());
			
			System.out.print(" \nEnter your birth date (DD-MM-YY) :  ");
			
			setBirthdate();
			
			System.out.print(" \nEnter your city name :  ");
			setCity(sc.next());
			
			System.out.print(" \nEnter your district name :  ");
			setDist(sc.next());
			
			System.out.print(" \nEnter your state name :  ");
			setState(sc.next());
			
			System.out.print(" \nEnter your pin code :  ");
			setPincode(sc.nextInt());
			sc.nextLine();
			System.out.print(" \nEnter your email id :  ");
			setEmail();
			
			
			setAuthentication();
			
			addToCustomerTable();
			
			setPassword();			
			Format1.doubleLineFormatting();
			System.out.println("\nRegistration Successfull......");
			Format1.doubleLineFormatting();
			
			PreparedStatement prepareStatement = connection.prepareStatement("select max(customer_id) from minipro.customerdetails;");
			
			 
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			executeQuery.next();
			 int userId = executeQuery.getInt(1);
			 //Format1.lineFormatting();
			 System.out.println("\nYour User ID : "+userId);
			 Format1.doubleLineFormatting();
			 System.out.println("\nLogin with your Id: ");
			 connection.close();
			 prepareStatement.close();
			
			//System.out.print("\n Do you want to continue (y/n) : \b ");
			 //c=sc.next().charAt(0);
			//sc.close();
	   	 //}
			}
	
  public  void addToCustomerTable() throws SQLException {
	  ConnectToMysql obj1 = new ConnectToMysql();
		 
		  Connection connection = obj1.connect();
		  
		  //System.out.println(getFirstName());
		  PreparedStatement prepareStatement = connection.prepareStatement("insert into minipro.CustomerDetails(firstName,lastName,birthdate,city,dist,state,pincode,email,question,answer)values(?,?,?,?,?,?,?,?,?,?)");
		  prepareStatement.setString(1,getFirstName());
		  prepareStatement.setString(2,getLastName());
		  prepareStatement.setString(3,getBirthdate());
		  prepareStatement.setString(4,getCity());
		  prepareStatement.setString(5,getDist());
		  prepareStatement.setString(6,getState());
		  prepareStatement.setInt(7,getPincode());
		  prepareStatement.setString(8,getEmail());
		  prepareStatement.setString(9,getQuestion());
		  prepareStatement.setString(10,getAnswer());
		  
		  prepareStatement.executeUpdate();
		  connection.close();
		
	     }
		
	
	
}
