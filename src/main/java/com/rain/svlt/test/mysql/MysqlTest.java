package com.rain.svlt.test.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class MysqlTest {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/javademo?"
				+ "user=root&password=password&useUnicode=true&characterEncoding=UTF8";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// or:
			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// or：
			// new com.mysql.jdbc.Driver();

			System.out.println("Successfully Load MySQL Driver");

			conn = DriverManager.getConnection(url);

			Statement stmt = conn.createStatement();
			sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
			int result = stmt.executeUpdate(sql);
			if (result != -1) {
				System.out.println("Successfully Create Table");
				sql = "insert into student(NO,name) values('2012001','Jodan')";
				result = stmt.executeUpdate(sql);
				sql = "insert into student(NO,name) values('2012002','Smith')";
				result = stmt.executeUpdate(sql);
				sql = "select * from student";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("No.\tName");
				while (rs.next()) {
					System.out.println(rs.getString(1) + "\t" + rs.getString(2));
				}
			}
		} catch (SQLException e) {
			System.out.println("MySQL Error!!!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

}
