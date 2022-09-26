package com.npvsoftech.pbmart.ecommerce.util;

public interface Moniterable {
	public abstract void displayPurchaseHistory(int customer_id);
	public abstract void displayProductQuantity();
	public void displayProductQuantity(int product_id);
	public abstract void displayCustomerList();
	public abstract int updateQuantity(int newQuantity, int pro_id);

}
