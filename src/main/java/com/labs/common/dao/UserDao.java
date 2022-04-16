package com.labs.common.dao;

import com.labs.common.model.User;

import java.sql.*;

public class UserDao {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/strutsdb", "root", "root");
			//return DriverManager.getConnection("jdbc:mysql://localhost:3306/strutsdb?"+"user=root&password=root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void save(User userDto) throws Exception {

		String username = userDto.getUsername();
		String password = userDto.getPassword();

		try {

			try {
				Statement st = getConnection().createStatement();
				int value = st
						.executeUpdate("INSERT INTO USER_DETAILS(USERNAME,PASSWORD) "+ "VALUES('"+ username+ "','"+ password+ "')");
				System.out.println("1 row affected" + value);
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
			getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getAllUsers() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT USERNAME, PASSWORD  FROM USER_DETAILS";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet getUser(String username) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT USERNAME, PASSWORD FROM USER_DETAILS WHERE USERNAME=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
