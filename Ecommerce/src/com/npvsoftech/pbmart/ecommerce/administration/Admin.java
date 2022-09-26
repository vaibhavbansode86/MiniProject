package com.npvsoftech.pbmart.ecommerce.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.npvsoftech.pbmart.ecommerce.design.Format1;
import com.npvsoftech.pbmart.ecommerce.registration.ConnectToMysql;
import com.npvsoftech.pbmart.ecommerce.util.Moniterable;

public class Admin extends AdminAuthentication implements Moniterable {
//	int customer_id = 3;

//	public static void main(String[] args) {
//		Admin a = new Admin();
//
//		int b = a.updateQuantity(1, 1);
//		//System.out.println(b);
//	}

//	public Connection getConnect() {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minipro", "root", "online123");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

	public Connection getConnect() {
	
	ConnectToMysql obj1 = new ConnectToMysql();
	Connection con = null;
	try {
		con = obj1.connect();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

	@Override
	public void displayPurchaseHistory(int customer_id) {
		ArrayList<String> product = new ArrayList<String>();

		Connection con = null;
		PreparedStatement ps = null;

		con = getConnect();
		try {
			con = getConnect();
			ps = con.prepareStatement("Select * from minipro.purchase_history where customer_id=" + customer_id + ";");
			ResultSet rs = ps.executeQuery();

			ps = con.prepareStatement("Select product from minipro.product_info ;");
			ResultSet pi = ps.executeQuery();

			ps = con.prepareStatement("Select * from minipro.customerdetails where customer_id=" + customer_id + ";");
			ResultSet ci = ps.executeQuery();

			if (ci.next()) {
//				System.out.printf("%d %s %s %s-%d\n", ci.getInt(1), ci.getString(2), ci.getString(3), ci.getString(5),
//						ci.getInt(8));
				Format1.purchaseHistoryHeading(((Integer)ci.getInt(1)).toString(), ci.getString(2), ci.getString(3), ci.getString(5),((Integer)ci.getInt(8)).toString());

			}

			while (pi.next()) {

				product.add(pi.getString(1));

			}

//			System.out.printf("%5s\t%12s\t%13s\t%22s\t%23s\n", "Product_id", "Product", "Quantity", "Purchase Date",
//					"Purchase Time");
			Format1.purchaseHistoryBorder();
			Format1.purchaseHistoryFormat("Product Id","Product Name","Quntity","Date","Time");
			Format1.purchaseHistoryBorder();

			while (rs.next()) {

//				System.out.printf("%4d\t\t%10s\t% 10d\t%20s\t%20s\n", rs.getInt(1), product.get(rs.getInt(1)),
//						rs.getInt(3), rs.getDate(4), rs.getTime(5));
				Format1.purchaseHistoryFormat(((Integer)rs.getInt(1)).toString(), product.get(rs.getInt(1)-1),((Integer)rs.getInt(3)).toString(), rs.getDate(4).toString(), rs.getTime(5).toString());
				Format1.purchaseHistoryBorder();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void displayProductQuantity(int product_id) {
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnect();
		try {
			con = getConnect();
			ps = con.prepareStatement(
					"Select * from minipro.product_info where product_info.product_id=" + product_id + ";");

			ResultSet rs = ps.executeQuery();

////			System.out.printf("%5s\t%10s\t%30s\t%32s\t%8s\n", "Product_id", "Product Name", "Description", "Price",
////					"Quantity");
//
//			while (rs.next()) {
//				System.out.printf("%4d\t%20s\t%50s\t%5s %d\t%5d\n", rs.getInt(1), rs.getString(2), rs.getString(3),
//						"Rs", rs.getInt(4), rs.getInt(5));
//			}
			Format1.adminProductListHeading();
			Format1.formatAdminProductBorder();
			Format1.formatedAdminProductList("product_id","product_Name","description","price","quantity" );
			Format1.formatAdminProductBorder();
			while (rs.next()) {
//				System.out.printf("%4d\t%20s\t%50s\t%5s %d\t%5d\n", rs.getInt(1), rs.getString(2), rs.getString(3),
//						"Rs", rs.getInt(4), rs.getInt(5));
				Format1.formatedAdminProductList(((Integer)rs.getInt(1)).toString(),rs.getString(2),rs.getString(3),((Integer)rs.getInt(4)).toString(),((Integer)rs.getInt(5)).toString() );
				Format1.formatAdminProductBorder();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayCustomerList() {
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnect();
		try {
			con = getConnect();
			ps = con.prepareStatement("Select * from minipro.customerdetails;");

			ResultSet rs = ps.executeQuery();

//			System.out.printf("%5s\t%10s\t%30s\t%32s\t%8s\n", "Product_id", "Product Name", "Description", "Price",
//					"Quantity");
			Format1.formatAdminCustomerHeading();
			Format1.formatAdminCustomerBorder();
			Format1.formatedAdminCustomerList("Customer_Id","First Name","Last Name","Birth date", 
					"City","District","State","Pincode","Email Id");
			Format1.formatAdminCustomerBorder();

			while (rs.next()) {
//				System.out.printf("%d %20s %1s %15s %15s %15s %20s %8d %25s\n", rs.getInt(1), rs.getString(2),
//						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
//						rs.getInt(8), rs.getString(9));
				Format1.formatedAdminCustomerList(((Integer)rs.getInt(1)).toString(),rs.getString(2),rs.getString(3),rs.getString(4), 
						rs.getString(5),rs.getString(6),rs.getString(7),((Integer)rs.getInt(8)).toString(), rs.getString(9));
				Format1.formatAdminCustomerBorder();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int updateQuantity(int newQuantity, int pro_id) {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		con = getConnect();
		try {
			con = getConnect();
			ps = con.prepareStatement(

					"update minipro.product_info set quantity=quantity+ " + newQuantity + " where (product_id=" + pro_id
							+ ");");

			rs = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void displayProductQuantity() {
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnect();
		try {
			con = getConnect();
			ps = con.prepareStatement("Select * from minipro.product_info ;");

			ResultSet rs = ps.executeQuery();

//			System.out.printf("%5s\t%10s\t%30s\t%32s\t%8s\n", "Product_id", "Product Name", "Description", "Price",
//					"Quantity");

			Format1.adminProductListHeading();
			Format1.formatAdminProductBorder();
			Format1.formatedAdminProductList("product_id","product_Name","description","price","quantity" );
			Format1.formatAdminProductBorder();
			while (rs.next()) {
//				System.out.printf("%4d\t%20s\t%50s\t%5s %d\t%5d\n", rs.getInt(1), rs.getString(2), rs.getString(3),
//						"Rs", rs.getInt(4), rs.getInt(5));
				Format1.formatedAdminProductList(((Integer)rs.getInt(1)).toString(),rs.getString(2),rs.getString(3),((Integer)rs.getInt(4)).toString(),((Integer)rs.getInt(5)).toString() );
				Format1.formatAdminProductBorder();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		
	}



