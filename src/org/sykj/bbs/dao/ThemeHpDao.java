package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.sykj.bbs.pojo.BclassInfo;
import org.sykj.bbs.pojo.Theme;
import org.sykj.bbs.utils.DBManager;

/**
 * 首页主题DAO
 * @author MGA
 *
 */
public class ThemeHpDao {
	
	Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();

	/**
	 * @return
	 * 最新主题
	 */
	public List<Theme> selectNewTheme() {
		  Connection conn = this.conn;
		
		 String sql="select * from theme t,themeclass tc,users u where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId ORDER BY ThemeTime desc";
		 List<Theme> tl = null;
		 
			try {
				tl= qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return tl;
	}
	
	
	
	/**
	 * @return
	 * 最新精华主题帖子
	 */
	public List<Theme> selectEliteTheme() {
		  Connection conn = this.conn;
		
		 String sql="select * from theme t,themeclass tc,users u where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ThemeSign=1 ORDER BY ThemeTime desc";
		 List<Theme> tl = null;
		 
			try {
				tl= qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return tl;
	}
	
	
	
	
	
	
   /**
     * @return
     * 最热回复帖
     */
    public List<Theme> selectHotTheme() {
    	  Connection conn = this.conn;
		
		 String sql="select *,COUNT(r.ThemeId) rNum from theme t,themeclass tc,users u,reply r "
		 		+ "where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ThemeId=r.ThemeId GROUP BY r.ThemeId ORDER BY rNum desc";
		 List<Theme> tl = null;
		 
			try {
				tl= qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return tl;
	}
    
  

}
