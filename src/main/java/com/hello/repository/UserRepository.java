package com.hello.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import com.hello.dao.DatabaseConnect;
import com.hello.model.User;

public class UserRepository {

	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public int registerUser(User user) throws Exception {
		String sql = "INSERT INTO t_user VALUES (?,?,?,?,?)";
		Connection connection = new DatabaseConnect().getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		int i = 0;
		try {	
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getPhoneNumber());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}


	public List<User> getAllUser() throws SQLException, Exception {
		String sql = "SELECT * FROM t_user";
		Connection connection = new DatabaseConnect().getConnection();
		List<User> users = new ArrayList<User>();
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
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return users;
	}

	public User getUsertByName(String name) throws SQLException, Exception {
		String sql = "SELECT * FROM t_user where name = ? ";
		Connection connection = new DatabaseConnect().getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				connection.close();
			}
		}
			return null;
	}
	
}
