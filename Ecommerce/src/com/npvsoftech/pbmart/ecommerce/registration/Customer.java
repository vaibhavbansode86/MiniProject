package com.npvsoftech.pbmart.ecommerce.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.npvsoftech.pbmart.ecommerce.design.Format1;
import com.npvsoftech.pbmart.ecommerce.util.Authenticable;

public abstract class Customer implements Authenticable {

	static Scanner sc = new Scanner(System.in);

	private String firstName;
	private String lastName;
	private String birthdate;
	private String city;
	private String dist;
	private String state;
	private int pincode;
	private String email;
	private String password;
	private int userId;
	static int count = 0;
	private String Question;
	private String Answer;

	//private Object prepareStatement;

	// Connection connection;
	// PreparedStatement prepareStatement;

	public String getFirstName() {
		return firstName;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getuserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(int userId) throws Exception {
		ConnectToMysql obj1 = new ConnectToMysql();

		Connection connection = obj1.connect();

		while (true) {
			System.out.print("\nEnter new password");
			String newpassword = sc.next();
			System.out.print("\nConfirm new password");
			String newpassword1 = sc.next();

			if (newpassword.equals(newpassword1)) {
				password = newpassword;
				PreparedStatement prepareStatement = connection.prepareStatement(
						"update minipro.userdetails set password =" + password + " where userId =" + userId + ";");
				prepareStatement.executeUpdate();
				prepareStatement.close();
				break;
			} else {
				System.err.println("\nPassword not matched ");
			}
		}

		connection.close();

	}

	public void setPassword() throws SQLException, InterruptedException {
		ConnectToMysql obj1 = new ConnectToMysql();

		Connection connection = obj1.connect();
		if (count < 3) {

			System.out.print("\nEnter your password : ");
			String next = sc.nextLine();
			System.out.print("\nConfirm your password : ");
			String next1 = sc.nextLine();
			if (next.equals(next1)) {
				this.password = next;
			} else {

				System.err.println("\nPassword not matched ");
				count++;
				setPassword();
			}
		} else {
			System.err.println("\nToo many failed attempts. Please try after 10 sec");
			Thread.sleep(10000);
			count = 0;
			setPassword();
		}

		PreparedStatement prepareStatement = connection
				.prepareStatement("select max(customer_id) from minipro.customerdetails;");

		ResultSet executeQuery = prepareStatement.executeQuery();

		executeQuery.next();
		userId = executeQuery.getInt(1);

		if (executeQuery.next()) {
			userId = executeQuery.getInt(1);
		}

		prepareStatement = connection.prepareStatement("insert into minipro.userDetails(userId,password)values(?,?);");

		System.out.println();
		prepareStatement.setInt(1, userId);
		prepareStatement.setString(2, getPassword());

		prepareStatement.executeUpdate();

		connection.close();
		prepareStatement.close();

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate() {
		ImplementCheck check = new ImplementCheck();
		String next = sc.next();
		if (check.isValidbirthDate(next)) {
			this.birthdate = next;
		} else {
			System.err.println("\nEnter in correct format ");
			setBirthdate();
		}

	}

	public String getCity() {
		return city;
	}

	public void setCity(String address) {
		this.city = address;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		ImplementCheck check = new ImplementCheck();
		String next = sc.nextLine();

		if (check.isValidEmail(next)) {
			this.email = next;
		} else {
			System.err.println("\nEnter in correct format ");
			setEmail();
		}

	}

	public void forgotPassword() throws InterruptedException, SQLException {
		String newPass=null;
		System.out.print("\nEnter Your User Id : ");
		int user_id = Integer.parseInt(sc.next());
		System.out.println();
		ConnectToMysql obj1 = new ConnectToMysql();
		
		Connection connection = obj1.connect();
		PreparedStatement prepareStatement = connection.prepareStatement("select question,answer from minipro.customerDetails where customer_id="+user_id+";");
		
		ResultSet set = prepareStatement.executeQuery();
		while(set.next()) {
			Question=set.getString(1);
			Answer=set.getString(2);
		}
		//sc.nextLine();
		System.out.println(Question);
		sc.nextLine();
		System.out.print("\nEnter your answer: ");
		String ans = sc.nextLine();
		if (ans.equals(Answer)) {
			//setPassword();

			while(true) {
			System.out.print("\nEnter your password : ");
			String next = sc.nextLine();
			System.out.print("\nConfirm your password : ");
			String next1 = sc.nextLine();
			if (next.equals(next1)) {
				newPass = next;
				Format1.lineFormatting();
				System.out.println("\nYour password set successfully..........");
				Format1.lineFormatting();
				break;
			} else {

				System.err.println("\nPassword not matched ");
			
			 	}
			}
		//prepareStatement = connection.prepareStatement("update minipro.userDetails set password='?' where userId=?;");
		prepareStatement = connection.prepareStatement("update minipro.userDetails set password=? where userId=?");
		prepareStatement.setString(1,newPass);
		prepareStatement.setInt(2, user_id);

		prepareStatement.executeUpdate();
		} else {
			Format1.lineFormatting();
			System.err.println("\nAuthentification failed!!!");
			Format1.lineFormatting();
		}
	}
}


