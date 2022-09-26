package com.npvsoftech.pbmart.ecommerce.design;


import java.sql.Date;

import org.apache.commons.lang3.StringUtils;

public class Format1 {
	public static void lineFormatting() {
		System.out.println(StringUtils.center(StringUtils.center("-", 1), 178, "-"));
	}
	public static void doubleLineFormatting() {
		System.out.println(StringUtils.center(StringUtils.center("=", 1), 178, "="));
	}
	public static void starLineFormatting() {
		System.out.println(StringUtils.center(StringUtils.center("*", 1), 178, "*"));
	}
	public static void formatAdminProductBorder() {
		System.out.print(StringUtils.rightPad("+", 14 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 20 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 51 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 12 - 1, "-") + "+");
		System.out.println(StringUtils.rightPad("", 12 - 1, "-") + "+");
	}
	public static void adminProductListHeading() {
		//System.out.println(StringUtils.center(StringUtils.center("-".repeat(107),109-2), 109, "+"));
		System.out.println(StringUtils.rightPad("+", 109 - 1, "-") + "+");
		System.out.println(StringUtils.center(StringUtils.center("Product List", 109 - 2), 109, "|"));
	}
	public static void formatedAdminProductList(String product_id,String product_Name,String description,String price,String quantity ) {

		System.out.print(StringUtils.center(StringUtils.center(product_id, 14 - 2), 14, "|"));
		System.out.print(StringUtils.center(StringUtils.center(product_Name, 20 - 1), 20, "|"));
		System.out.print(StringUtils.center(StringUtils.center(description, 51 - 1), 51, "|"));
		System.out.print(StringUtils.center(StringUtils.center(price, 12 - 1), 12, "|"));
		System.out.println(StringUtils.center(StringUtils.center(quantity, 12 - 1), 12, "|"));
	}
	
	
	public static void customerProductListHeading() {
		//System.out.println(StringUtils.center(StringUtils.center("-".repeat(107),109-2), 109, "+"));
		System.out.println(StringUtils.rightPad("+", 97 - 1, "-") + "+");
		System.out.println(StringUtils.center(StringUtils.center("Product List", 97 - 2), 97, "|"));
	}
	public static void formatCustomerProductBorder() {
		System.out.print(StringUtils.rightPad("+", 14 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 20 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 51 - 1, "-") + "+");
		//System.out.print(StringUtils.rightPad("", 12 - 1, "-") + "+");
		System.out.println(StringUtils.rightPad("", 12 - 1, "-") + "+");
	}
	public static void formatedCustomerProductList(String product_id,String product_Name,String description,String price ) {

		System.out.print(StringUtils.center(StringUtils.center(product_id, 14 - 2), 14, "|"));
		System.out.print(StringUtils.center(StringUtils.center(product_Name, 20 - 1), 20, "|"));
		System.out.print(StringUtils.center(StringUtils.center(description, 51 - 1), 51, "|"));
		//System.out.print(StringUtils.center(StringUtils.center(price, 12 - 1), 12, "|"));
		System.out.println(StringUtils.center(StringUtils.center(price, 12 - 1), 12, "|"));
	}
	
	
	
	public static void formatAdminCustomerHeading() {
		System.out.println(StringUtils.rightPad("+", 178 - 1, "-") + "+");
		System.out.println(StringUtils.center(StringUtils.center("Customer List", 178 - 2), 178, "|"));
	}
	public static void formatAdminCustomerBorder() {
		System.out.print(StringUtils.rightPad("+", 14 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 23 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 23 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 13 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 15 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 15 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 15 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 10 - 1, "-") + "+");
		System.out.println(StringUtils.rightPad("", 50 - 1, "-") + "+");
	}
	public static void formatedAdminCustomerList(String customer_id,String firstName,String lastName,String birthdate, 
			String city,String dist,String state,String i,String email) {

		System.out.print(StringUtils.center(StringUtils.center(customer_id, 14 - 2), 14, "|"));
		System.out.print(StringUtils.center(StringUtils.center(firstName, 23 - 1), 23, "|"));
		System.out.print(StringUtils.center(StringUtils.center(lastName, 23 - 1), 23, "|"));
		System.out.print(StringUtils.center(StringUtils.center(birthdate, 13 - 1), 13, "|"));
		System.out.print(StringUtils.center(StringUtils.center(city, 15 - 1), 15, "|"));
		System.out.print(StringUtils.center(StringUtils.center(dist, 15 - 1), 15, "|"));
		System.out.print(StringUtils.center(StringUtils.center(state, 15 - 1), 15, "|"));
		System.out.print(StringUtils.center(StringUtils.center(i, 10 - 1), 10, "|"));
		System.out.println(StringUtils.center(StringUtils.center(email, 50 - 1), 50, "|"));
	}
	
	public static void billFormatHeading() {
		System.out.println(StringUtils.rightPad("+", 59 - 1, "-") + "+");
		System.out.println(StringUtils.center(StringUtils.center("Bill", 59 - 2), 59, "|"));
	}
	public static void totalBill(String totalBill) {
		
		System.out.print(StringUtils.center(StringUtils.center("Total ", 14 - 2), 14, "|"));
		System.out.println(StringUtils.rightPad(StringUtils.rightPad(" Rs "+totalBill, 45 -1), 45, "|"));
		System.out.println(StringUtils.rightPad("+", 59 - 1, "-") + "+");
	}
	public static void billBorder() {
		System.out.print(StringUtils.rightPad("+", 14 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 20 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 12 - 1, "-") + "+");
		System.out.println(StringUtils.rightPad("", 13 - 1, "-") + "+");
	}
	public static void billFormat(String product_id,String productName,String Quantity,String totatPrice) {
		System.out.print(StringUtils.center(StringUtils.center(product_id, 14 - 2), 14, "|"));
		System.out.print(StringUtils.center(StringUtils.center(productName, 20 - 1), 20, "|"));
		System.out.print(StringUtils.center(StringUtils.center(Quantity, 12 - 1), 12, "|"));
		System.out.println(StringUtils.center(StringUtils.center(totatPrice, 13 - 1), 13, "|"));
	}
	
//	public static void purchaseHistoryHeading(String customerId) {
//		System.out.println(StringUtils.rightPad("+", 76 - 1, "-") + "+");
//		System.out.println(StringUtils.center(StringUtils.center("Custemor Id: "+customerId+"   purchase history", 76 - 2), 76, "|"));
//	}
	
	public static void purchaseHistoryHeading(String customerId,String fName,String lName,String city,String pincode) {
		
		System.out.println(StringUtils.rightPad("+", 76 - 1, "-") + "+");
		System.out.println(StringUtils.center(StringUtils.center("purchase history", 76 - 2), 76, "|"));
		System.out.println(StringUtils.rightPad("+", 76 - 1, "-") + "+");
		//System.out.print(StringUtils.center(StringUtils.center("Customer Id : ", 14 - 2), 14, "|"));
		System.out.println(StringUtils.center(StringUtils.center("Customer Id : "+customerId
				+" ["+fName+" "+lName+","+" "+city+"-"+pincode+"]", 76 -2), 76, "|"));
	}
	public static void purchaseHistoryBorder() {
		System.out.print(StringUtils.rightPad("+", 14 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 20 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 12 - 1, "-") + "+");
		System.out.print(StringUtils.rightPad("", 15 - 1, "-") + "+");
		System.out.println(StringUtils.rightPad("", 15 - 1, "-") + "+");
	}
	public static void purchaseHistoryFormat(String product_id,String productName,String quantity,String date,String time) {
		System.out.print(StringUtils.center(StringUtils.center(product_id, 14 - 2), 14, "|"));
		System.out.print(StringUtils.center(StringUtils.center(productName, 20 - 1), 20, "|"));
		System.out.print(StringUtils.center(StringUtils.center(quantity, 12 - 1), 12, "|"));
		System.out.print(StringUtils.center(StringUtils.center(date, 15 - 1), 15, "|"));
		System.out.println(StringUtils.center(StringUtils.center(time, 15 - 1), 15, "|"));
	}
	
	
	
	
	public static void main(String[] args) {
		int id1=2;
		Integer id=id1;
		//formatAdminProductBorder();
		adminProductListHeading();
		formatAdminProductBorder();
		formatedAdminProductList("product_id","product_Name","description","price","quantity" );
		formatAdminProductBorder();
		formatedAdminProductList(id.toString(),"APPLE iPhone 13","Handset, USB-C to Lightning Cable, Documentation","69900","100" );
		formatAdminProductBorder();
		
		//Integer id=2;
		customerProductListHeading();
		formatCustomerProductBorder();
		formatedCustomerProductList("product_id","product_Name","description","price" );
		formatCustomerProductBorder();
		formatedCustomerProductList(id.toString(),"APPLE iPhone 13","Handset, USB-C to Lightning Cable, Documentation","69900" );
		formatCustomerProductBorder();
		
		formatAdminCustomerHeading();
		formatAdminCustomerBorder();
		formatedAdminCustomerList("Customer_Id","First Name","Last Name","Birth date", 
				"City","District","State","Pincode","Email Id");
		formatAdminCustomerBorder();
		formatedAdminCustomerList(id.toString(),"Nadem","Sheikh","12-12-1998", 
				"Akola","Akola","Maharashtra","415409","nadeem1998@gmail.com");
		formatAdminCustomerBorder();
		starLineFormatting();
		
		billBorder();
		billFormat("Product Id","Product Name","Quntity","Qty*Price");
		billBorder();
		billFormat("1","APPLE iPhone 13","10","1000000");
		billBorder();
		totalBill("1000000");
		
		purchaseHistoryHeading("6","Salman","Khan","Mumbai","123");
		purchaseHistoryBorder();
		purchaseHistoryFormat("Product Id","Product Name","Quntity","Date","Time");
		purchaseHistoryBorder();
		
		
	}
	

}
