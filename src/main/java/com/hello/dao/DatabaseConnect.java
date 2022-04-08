package com.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

import com.hello.model.User;
import com.hello.repository.UserRepository;





public class DatabaseConnect {

	
//	public static Connection getConnection() throws Exception {
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","123");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public static Connection getConnection() {
		Connection conection = null;
		try {
			Class.forName("org.postgresql.Driver");
			conection =(Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","123");
			System.out.print("connect to db");
			return conection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Connection connection;
	public static void main(String[] args) {
		UserRepository us = new UserRepository();
		us.getConnection();
		String sql = "SELECT * FROM t_user ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				System.out.print(user.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();}
	}
	
	

	
}
