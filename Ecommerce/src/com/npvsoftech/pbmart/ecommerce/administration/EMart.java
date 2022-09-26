package com.npvsoftech.pbmart.ecommerce.administration;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.npvsoftech.pbmart.ecommerce.design.Format1;
import com.npvsoftech.pbmart.ecommerce.registration.CustomerManagement;

public class EMart {
	public static Scanner sc = new Scanner(System.in);

	static {
		//System.out.println("******************Welcome To PBMart*****************");
		//Format1.starLineFormatting();
		System.out.println(StringUtils.center(StringUtils.center("Welcome To PBMart", 130 - 112), 130, "*"));
		//Format1.starLineFormatting();
	}
	
	
	public static void afterLogedInCust(int customer_id) throws InterruptedException {
		CustomerFuctionality cF = new CustomerFuctionality();
		cF.displayProducts();
		char ch = 'y';
		while (ch == 'y') {
			Format1.lineFormatting();
			System.out.print("\nSelect product Id for adding the product into CART : ");
			// int product_id = Integer.parseInt(sc.next());
			int product_id = sc.nextInt();
			sc.nextLine();
			System.out.print("\nEnter the Quantity : ");
			// int quantity = Integer.parseInt(sc.next());
			int quantity = sc.nextInt();
			sc.nextLine();
			//System.out.println("\n\ncust" + customer_id + "\n\n");
			cF.addToCart(product_id, customer_id, quantity);
			System.out.print("\nDo you want to add more product into CART (y/n) : ");
			
			ch = sc.next().charAt(0);
			
			
		}
		Format1.doubleLineFormatting();
		char ch1 = 'y';
		while (ch1 == 'y') {
			
			cF.displayBill(customer_id);
			int i;
			while(true) {
				try {
					System.out.print("\n1.To Buy the products ");
					System.out.print("\n\n2.To romove the products from CART  ");
					System.out.print("\n\nEnter your choice: ");
					i = Integer.parseInt(sc.next());
					break;
				}catch(NumberFormatException e) {
					System.err.println("Invalid Input........");
				}

			}

			
			if (i == 1) {
				cF.placeorder(customer_id);
				if (CustomerFuctionality.flag == 1) {
					CustomerFuctionality.flag = 0;
					Format1.doubleLineFormatting();
					System.out.println("\nYour order is placed successfully....");
					Format1.doubleLineFormatting();
					
				} else if (CustomerFuctionality.flag == 0) {
					Format1.lineFormatting();
					Thread.sleep(1000);
					System.err.println("\nYou don't have anything in your CART." + "\n\nThank you for visiting PB-MART.");
					Format1.lineFormatting();
				}
				break;

			} else if (i == 2 && CustomerFuctionality.flag == 1) {
				CustomerFuctionality.flag = 0;
				Format1.lineFormatting();
//			char ch1='y';
//			while(ch1=='y') {
				System.out.print("\nSelect product Id for removing the product from CART : ");
				int product_id = Integer.parseInt(sc.next());
				cF.removeFromCart(product_id, customer_id);

			} else if (CustomerFuctionality.flag == 0) {
				System.err.println("\nCART is empty...");
				Format1.lineFormatting();
			
			}
		}

	}

	public static void operateCustRequirement() throws InterruptedException {
		int flag1=0;
		char ch = 'y';
		CustomerManagement cm = new CustomerManagement();
		while(true) {
			
		System.out.println("\n1. Login \t2.Sign up \t3.Forgot Password");
		Format1.lineFormatting();
		Thread.sleep(1000);
		System.out.print("\nEnter your choice :");
		ch = sc.next().charAt(0);
		Format1.lineFormatting();
		
		switch (ch) {
		case '1':
			try {

				if (cm.login()) {
					Format1.doubleLineFormatting();
					System.out.println("\nYou are successfully loged in .......");
					Format1.doubleLineFormatting();
					while(true) {
					afterLogedInCust(cm.user_id);
					System.out.print("\nLog Out (y/n) : ");
					char at = sc.next().charAt(0);
					if(at=='y') {
						flag1=1;
						break;
					}
					}
				} else {
					System.err.println("\nInvalid User Id or Password...");

//					cm.forgotPassword(cm.user_id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case '2':
			// CustomerManagement cm=new CustomerManagement();
			try {
				cm.addNewCustomer();
				if (cm.login()) {
					Format1.doubleLineFormatting();
					System.out.println("\nYou are successfully loged in .......");
					Format1.doubleLineFormatting();
					while(true) {
						afterLogedInCust(cm.user_id);
						Thread.sleep(1000);
						System.out.print("\nLog Out (y/n) : ");
						char at = sc.next().charAt(0);
						if(at=='y') {
							flag1=1;
							break;
						}
						}
				} else {
					System.err.println("\nInvalid User Id or Password...");
					//cm.forgotPassword();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case '3':
			try {
				
				cm.forgotPassword();
			}  catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default :
			System.err.println("\nInvalid option.");
		 
			}
		if(flag1==1) {break;}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Admin ad = new Admin();
		char ch = 'y';
		int mainFlag=0;
		while(ch=='y'){
		System.out.println("1.Customer  \n\n2.Admin");
		Format1.lineFormatting();
		System.out.print("\nEnter your choice : ");
		char choice = sc.next().charAt(0);
		Format1.doubleLineFormatting();
		
		switch (choice) {
		case '1':
				
			operateCustRequirement();
			//System.out.println("\nend.....");
			Format1.starLineFormatting();
			mainFlag=1;
			break;
		
		case '2':
			if(ad.login()) {
				while (true) {
					int i=0;
					while(true) {
						Thread.sleep(1000);
					System.out.println("\n1-Display product quantity by product id."
							+ "\n2-Display product list.\n3-Add product quantity."
							+ "\n4-Display customer list.\n5-Display customer history.");
					System.out.print("\nEnter your option: ");
					try {
					 i = Integer.parseInt(sc.next());
					 break;
					}catch(NumberFormatException e){
						System.err.println("\nInvalid input");
						System.err.println("\nPlease enter correct option.");
						Format1.lineFormatting();
					}
					Format1.doubleLineFormatting();
					}
					switch(i) {
					case 1 :
						System.out.print("\nEnter the product id : ");
						int product_id = Integer.parseInt(sc.next());
						ad.displayProductQuantity(product_id);
					break;
					case 2 :
						ad.displayProductQuantity();
					break;
					case 3:
						System.out.print("\nEnter the product id : ");
						int p_id = Integer.parseInt(sc.next());
						System.out.print("\nEnter the quantity to add : ");
						int new_qty = Integer.parseInt(sc.next());
						ad.updateQuantity(new_qty, p_id);
					break;
					case 4 :
						ad.displayCustomerList();
						break;
					case 5:
						System.out.print("\nEnter the customer id : ");
						int c_id = Integer.parseInt(sc.next());
						ad.displayPurchaseHistory(c_id);
					break;
					default :
						System.err.println("\nInvalid input");
					}
				Format1.doubleLineFormatting();
				System.out.print("\nLog out (y/n) : ");
				char out = sc.next().charAt(0);
				Format1.doubleLineFormatting();
				if(out=='y') {
					ch='n';
					break;
				}
				
				}
			}else {
 
			}
			
				}
		if(mainFlag==1) {
			//System.out.println("\nEnd of application.....");
			
			break;
		}
			}
		System.out.println("\nEnd of application.....\n");
		Format1.starLineFormatting();

		}

	}


