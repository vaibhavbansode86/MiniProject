package com.npvsoftech.pbmart.ecommerce.util;

public interface Checkable {
	
	public abstract boolean isValidEmail(String email);
	
	public abstract boolean isValidbirthDate(String birthDate);
	
	 public abstract Boolean checkEmail(String email)throws Exception;

}
