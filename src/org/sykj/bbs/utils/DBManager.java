package org.sykj.bbs.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	private static Connection conn = null;
	static {
		try {
			        Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///bbs?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 获得连接
	 * @return
	 * 
	 */
	public static  Connection getConn() {
		return conn;
	}

}
