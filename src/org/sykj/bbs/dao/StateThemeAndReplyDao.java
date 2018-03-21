package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.utils.DBManager;

public class StateThemeAndReplyDao {
	
	Connection conn = DBManager.getConn();
	QueryRunner qr = new QueryRunner();
	
	
	
	/**
	 * 板块页操作帖子
	 */
	public void UpdateTableThemeAndReply(String sql) {
		   Connection conn = this.conn;
		   
		   System.out.println("UCDaoSQL:"+sql);

		   try {
			qr.update(conn, sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * @param ThemeId
	 * @return
	 * ThemeId查用户
	 */
	public Users ThemeIdByUserSelect(int ThemeId) {
		   Connection conn = this.conn;
		   
		  String sql = "select u.*,ui.* from theme t,users u,usersinfo ui where t.UserId=u.UserId and u.UserId=ui.UserId and t.ThemeId="+ThemeId;

		  Users u=null;
		
		  try {
			u=qr.query(conn, sql, new BeanHandler<Users>(Users.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return u;
		
	}



	/**
	 * replyId查用户
	 */
	public Users ReplyIdByUserSelect(int replyId) {
		   Connection conn = this.conn;
		  
		  String sql = "select u.*,ui.* from reply r,users u,usersinfo ui where r.UserId=u.UserId and u.UserId=ui.UserId and r.ReplyId="+replyId;

		  Users u=null;
		  
		  try {
			  
			u=qr.query(conn, sql, new BeanHandler<Users>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
	}

}
