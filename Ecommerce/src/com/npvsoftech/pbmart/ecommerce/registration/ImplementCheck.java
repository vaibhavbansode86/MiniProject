package com.npvsoftech.pbmart.ecommerce.registration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.npvsoftech.pbmart.ecommerce.util.Checkable;

public class ImplementCheck implements Checkable {

	@Override
	public boolean isValidEmail(String email) {
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
         
	        Pattern pat = Pattern.compile(emailRegex);
	        
	        if (email == null)
	            return false;
	        return pat.matcher(email).matches();
		
	}
	
  static ArrayList <String> customerList = new ArrayList<String>();
	
	  public Boolean checkEmail(String email) throws SQLException {
		  
		  ConnectToMysql obj1 = new ConnectToMysql();
		  obj1.connect();

		  PreparedStatement ps = obj1.connection.prepareStatement("SELECT email FROM user.customerdetails;");
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			  customerList.add(rs.getString(1));
		  }
     	 if (customerList.contains(email)) {
     		 System.out.println("Email Id already registered ");
     		 return true;
     	 } else {
     		System.out.println("You can do registration ");
     		 return false;
     	 }
      }

	@Override
	public boolean isValidbirthDate(String birthDate) {
		 String birthDateRegex = "\\d?\\d-\\d?\\d-\\d\\d\\d\\d";
         
	        Pattern pat = Pattern.compile(birthDateRegex);
	        
	        if (birthDate == null)
	            return false;
	        return pat.matcher(birthDate).matches();
		
	}

}
