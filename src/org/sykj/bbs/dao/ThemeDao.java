package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.sykj.bbs.pojo.Theme;
import org.sykj.bbs.pojo.ThemePage;
import org.sykj.bbs.pojo.Themeclass;
import org.sykj.bbs.utils.DBManager;

public class ThemeDao {
	
	
Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();

	/**
	 * 浏览量查询
	 */
	public Theme selectByThemeViewCount(int ThemeId) {
		
	     Connection conn = this.conn;
         String sql = "select * from theme where ThemeId="+ThemeId;
         
         Theme t = null;
         
         try {
      	   
        	 t= qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class)).get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return t;
	}
	
	
	/**
	 * 浏览量加一
	 */
	public void updateByThemeViewCount(int ThemeId,int count) {
				
	     Connection conn = this.conn;
         String sql = "update theme set ThemeViewCount="+count+" where ThemeId="+ThemeId;
         
         try {
      	   
        	qr.update(conn, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/*
	    * 依据板块id（classId）查论坛主贴
	    * 以此判断是否删除板块
	    */
	public List<Theme> selectAllThemeByClassId(String classid) {

		String sql = "select * from theme where classId = ?";
		List<Theme> arr=null;
		try {
		arr=qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class), classid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * 查全部帖子，做分页
	 * @param themePage
	 * @param search
	 * @return
	 * @throws Exception
	 */
	public ThemePage Query(ThemePage themePage, String search) throws Exception {
		String sql = "select th.*,u.UserName,b.ClassName,thc.ThemeClassName from theme th,users u,bclass b,themeclass thc where th.UserId=u.UserId and th.ClassId=b.ClassId and th.ThemeClassId=thc.ThemeClassId and ( b.className like '%"+search+"%' or thc.themeClassName like '%"+search+"%' or th.themeTitle like '%"+search+"%' or th.themeBody like '%"+search+"%' ) limit "+themePage.getStart()+","+themePage.getEnd();
		String sqlCount="select count(*) from theme th,users u,bclass b,themeclass thc where th.UserId=u.UserId and th.ClassId=b.ClassId and th.ThemeClassId=thc.ThemeClassId";
		Long num = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
		themePage.setTotal(num.intValue());
		List<Theme> ThemeArr = qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class));
	for (Theme theme : ThemeArr) {
		System.out.println(theme);
	}
		themePage.setRows(ThemeArr);
		System.out.println(sql);
		return themePage;
	}
	
	
	@Test
	public void fun (){
		ThemePage page = new ThemePage();
		
	}

/**
* 置顶
* @param themeId
* @param isTopState
*/
	public void top(String themeId, String isTopState) {
		String sql ="update theme set themeIsTop=? where themeId=?";
		try {
			qr.update(conn, sql, isTopState,themeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
* 普通/精华帖
* @param themeId
* @param themeSign
*/
public void sign(String themeId, String themeSign) {
	String sql = "update theme set themeSign=? where themeId=?";
	try {
		qr.update(conn, sql, themeSign,themeId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
* 删除帖子
* @param themeId
*/
public void delete(String themeId) {
	String replySql="delete from reply where themeId=?";
	String themeSql="delete from theme where themeId=?";
	try {
		qr.update(conn, replySql, themeId);
		qr.update(conn, themeSql, themeId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
