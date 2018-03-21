package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.sykj.bbs.pojo.Bclass;
import org.sykj.bbs.pojo.BclassPage;
import org.sykj.bbs.pojo.Moderator;
import org.sykj.bbs.utils.DBManager;

public class BclassDao {
	
	Connection conn = DBManager.getConn();
	QueryRunner qr = new QueryRunner();
	/**
	 *后台 bootstrap查出全部板块
	 * @param page
	 * @param search 
	 * @return
	 * @throws SQLException
	 */
   public BclassPage query(BclassPage bclassPage, String search) throws SQLException {
	   String sql = "select b.*,u.userName from bclass b left join moderator m on b.classId=m.classId left join users u on  m.userId=u.userId where  ( b.classId like '%"+search+"%' or b.className like '%"+search+"%' or b.classMsg like '%"+search+"%' or b.classPicture like '%"+search+"%') limit "+bclassPage.getStart()+","+bclassPage.getEnd();
	   String sqlCount = "select count(*) from bclass b left join moderator m on b.classId=m.classId left join users u on  m.userId=u.userId where ( b.classId like '%"+search+"%' or b.className like '%"+search+"%' or b.classMsg like '%"+search+"%' or b.classPicture like '%"+search+"%')";
	  System.out.println(sql);
	  System.out.println(sqlCount);
	   Long sd = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
	   bclassPage.setTotal(sd.intValue());
	   List<Bclass> query = qr.query(conn, sql, new BeanListHandler<Bclass>(Bclass.class));
	   for (Bclass bclass : query) {
		System.out.println(bclass);
	}
	   bclassPage.setRows(query);
	   return bclassPage;
  }
   /**
    * 后台，删除板块
    * @param classId
    */
   public void delete(String classId) {
	   String sql = "delete from bclass where classId = ?";
	   try {
		qr.update(conn, sql, classId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
  
	/**
	 * 后台，更改板块
	 * @param bclass
	 */
	public void update(List<String> fileName,List<String> values) {
		try {
		String sql = "update bclass set className=? ,classMsg=?,classPicture=? where classId=?";
		qr.update(conn, sql, values.get(1),values.get(2),fileName.get(0),values.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 后台，添加板块
	 * @param bclass
	 */
	public void insert(List<String> fileName,List<String> values) {
		try {	
		String sql = "insert into bclass values(null,?,?,?)";
			 qr.insert(conn, sql, new ScalarHandler<Long>(1), values.get(0),values.get(1),fileName.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		/**
		 * 前台注册时，查全部板块以确定擅长领域。
		 * @return
		 */
		public List<Bclass> selectAll() {
			String sql = "select * from bclass";
			List<Bclass> query=null;
			try {
			query = qr.query(conn, sql, new BeanListHandler<Bclass>(Bclass.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return query;
		}
		@Test
		public void fun (){
			List<Bclass> selectAll = selectAll();
			System.out.println(selectAll);
		}
		
		
		
		
		/**
		 * @param themeId
		 * @return
		 * 通过主题帖ID查版块ID
		 */
		public Bclass SelectThemeIdByClassId(int themeId) {


			Connection conn = this.conn;
			
			String sql = "select * from bclass b LEFT JOIN theme t on b.ClassId=t.ClassId where t.ThemeId="+themeId;
			
			Bclass bc= null;
			
			try {
				bc=qr.query(conn, sql, new BeanListHandler<Bclass>(Bclass.class)).get(0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return bc;
		}
}
