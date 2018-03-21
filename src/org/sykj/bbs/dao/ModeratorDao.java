package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sykj.bbs.pojo.Moderator;
import org.sykj.bbs.utils.DBManager;

public class ModeratorDao {
	
	Connection conn = DBManager.getConn();
	QueryRunner qr = new QueryRunner();
	/**
	 * 修改版主时先删除原先的版主
	 * @param classId
	 */
	public void delete(String classId) {
		String sql = "delete from moderator where classId = ?";
		try {
			qr.update(conn, sql, classId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 依照板块id和用户id添加版主
 * @param string
 * @param classId
 */

	public void insert(String string, String classId) {
		String sql = "insert into moderator values (null,?,?)";
		try {
			qr.insert(conn, sql, new ScalarHandler<>(), string,classId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
/**
 * @param classId
 * @return
 * 分类ID查询用户ID
 */
public List<Moderator> ClassIdByUserIdSelect(int classId) {
   
	
	Connection conn = this.conn;
	
	String sql = "select * from moderator where ClassId="+classId;
	
	List<Moderator> lm= null;
	
	try {
		lm=qr.query(conn, sql, new BeanListHandler<Moderator>(Moderator.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return lm;
}

	
	
	
	
}
