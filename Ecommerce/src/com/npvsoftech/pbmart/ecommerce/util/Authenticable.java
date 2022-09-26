package com.npvsoftech.pbmart.ecommerce.util;

public interface Authenticable {

	public abstract Boolean login();
	
	public abstract void setAuthentication();
	
	public abstract void forgotPassword()throws Exception;
	
	public abstract void setPassword() throws Exception;
	
}
