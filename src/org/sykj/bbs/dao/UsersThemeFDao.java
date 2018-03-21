package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sykj.bbs.pojo.BclassInfo;
import org.sykj.bbs.pojo.Reply;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.utils.DBManager;

import com.mysql.jdbc.PreparedStatement;

public class UsersThemeFDao {
	
	
	Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();

	
	
	/**
	 * userId鏌sers瀵硅薄
	 */
	public Users selectByUserId(int userId) {
		
		 Connection conn = this.conn;
		
		 String sql = "SELECT * FROM users u,usersinfo ui where u.UserId=ui.UserId and u.UserId="+userId;
		 
		   Users user = null;
           
           try {
        	   
        	   user= qr.query(conn, sql, new BeanListHandler<Users>(Users.class)).get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	
	
	/**
	 * 涓婚甯栨坊鍔犲洖澶�
	 */
	public Reply insertByReply(int ThemeId,String ReplyBody,int UserId,String UserName) {
		
		 Connection conn = this.conn;	 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡	
		String ReplyTime = df.format(new Date());		
		 String sql = "INSERT INTO reply VALUES(null,?,?,?,?,?)";
		 String sqlReturn = "select * from reply r,users u,usersinfo ui where  r.UserId=u.UserId and  u.UserId=ui.UserId and ReplyId=?";
		 
		 Long ReplyId=0L;
		 Reply reply=null;
		  
          try {
        	  
        	  //杩斿洖涓婚敭鍊�QueryRunner鐨刬nsert鑾峰彇鎻掑叆鏁版嵁鐨勪富閿叾瀹炶皟鐢ㄧ殑鏄痵elect SCOPE_IDENTITY()
       	   
        	 ReplyId =	 qr.insert(conn, sql,new ScalarHandler<Long>(),ThemeId,ReplyBody,UserId,UserName,ReplyTime);
        	 
        	 reply = qr.query(conn, sqlReturn,new BeanHandler<Reply>(Reply.class),ReplyId);
  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

          return reply;
          
          
	}
	
	
	/**
	 * 涓婚甯栧洖澶嶅垹闄�
	 */
	public void updateDelByReply(int ReplyId) {
		
		 Connection conn = this.conn;	 
/*		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡	
		String ReplyTime = df.format(new Date());		*/
	
		 String sql = "DELETE FROM reply where ReplyId="+ReplyId;
		 
	      try {
			qr.update(conn, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
	}



	/**
	 * 鐢ㄦ埛鍥炲鏇存柊Exp Money
	 */
	public void UpdateUserExpMoney(int userId,String sql) {
		
		 Connection conn = this.conn;
		 
		 
			try {
				qr.update(conn, sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}



	/**
	 * 鍙戝竷涓婚
	 */
	public void insertByTheme(String themeTitle, String themeBody, int classId, int themeClassId, int userId) {
		 Connection conn = this.conn;
		 
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡	
			String ThemeTime = df.format(new Date());		
		 
		 String sql = "INSERT INTO theme VALUES(null,?,?,?,?,?,?,0,0,0,null)";
		 
		 try {
			 
			qr.insert(conn, sql,new ScalarHandler<Long>(),userId,classId,themeClassId,themeTitle,themeBody,ThemeTime);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	/**
	 * 涓婚甯栬鎯呴〉缂栬緫
	 */
	public void updateThemeEditorUp(int themeId, String themeTitle, String themeBody) {
		Connection conn = this.conn;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡	
		String ThemeUpTime = df.format(new Date());		
		
		String sql = "UPDATE theme set ThemeTitle='"+themeTitle+"',ThemeBody='"+themeBody+"',ThemeUpTime='"+ThemeUpTime+"' where ThemeId="+themeId;

		try {
			qr.update(conn, sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
