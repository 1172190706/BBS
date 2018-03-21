package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.sykj.bbs.pojo.BclassInfo;
import org.sykj.bbs.pojo.Themeclass;
import org.sykj.bbs.utils.DBManager;

public class ThemeClassDao {
	
	Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();

	public List<Themeclass> selectAll() {
		
		
	     Connection conn = this.conn;
         String sql = "select * from themeclass";
         
         List<Themeclass> tcl = null;
         
         try {
      	   
        	 tcl= qr.query(conn, sql, new BeanListHandler<Themeclass>(Themeclass.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return tcl;
	}

	
	
	
	
}
