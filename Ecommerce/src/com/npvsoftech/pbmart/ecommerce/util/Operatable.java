package com.npvsoftech.pbmart.ecommerce.util;

public interface Operatable {
	
	public abstract void displayProducts();
	public abstract int addToCart(int product_id,int customer_id, int quantity) ;
	public abstract int removeFromCart(int product_id,int customer_id);
	public abstract int generateBill(int customer_id);
	public abstract int placeorder(int customer_id);
	public abstract void displayBill(int customer_id);

}
