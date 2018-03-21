package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.pojo.Usersinfo;
import org.sykj.bbs.utils.DBManager;

public class UsersinfoDao {
	
	Connection conn = DBManager.getConn();
	QueryRunner qr = new QueryRunner();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
/**
 * 用户注册时添加usersinfo表中的数据
 * @param fileName
 * @param values
 */
	public void insert(List<String> fileName, Map<String, String> values) {
			try {
				String sql = "insert into usersinfo values (null,?,?,?,?,?,?,?,?,0,0,?,?)";
				String sqlSelectUserIdByUserName = "select * from users where userName=?";
			Users users = qr.query(conn, sqlSelectUserIdByUserName, new BeanListHandler<Users>(Users.class),values.get("userName")).get(0);
		   System.out.println(users.getUserId());
		   System.out.println(sdf.format(date));
//{Birthday=1991-04-20, Phone=12312312312, userNmae=123, Email=123@, userSex=男, UserPassA=西施, UserPassQ=你的女朋友是谁?, UserSpe=1, Pwd1=qweqwe, Pwd2=qweqwe}
		  qr.insert(conn, sql, new ScalarHandler<Long>(1), users.getUserId(),fileName.get(0),values.get("UserPassQ"),values.get("UserPassA"),values.get("Email"),values.get("Phone"),values.get("userSex"),values.get("Birthday"),values.get("UserSpe"),sdf.format(date));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void fun(){
		List<String> fileName=new ArrayList<String>();
		fileName.add("qwe");
    Map<String, String> values = new HashMap<String, String>();
    values.put("userName", "张三");
    values.put("Pwd1", "123123");
		insert(fileName,values);
	}
	
	public Usersinfo  selectInfo(Integer userId) {
		String sql = "select * from usersinfo where userId= ?";
		Usersinfo usersinfo=null;
		try {
	 usersinfo = qr.query(conn, sql, new BeanListHandler<Usersinfo>(Usersinfo.class), userId).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersinfo;
	}
	/**
	 * 前台修改usersinfo表中的数据
	 * @param fileName
	 * @param values
	 */
	public void update(List<String> fileName, Map<String, String> values) {
		//	{Birthday=1995-01-01, Phone=12345678912, Email=aaa@qq.com, userSex=女, userName=张三, UserSpe=JSP, Pwd1=1234561, Pwd2=1234561}
		try {
		String sqlSelectUserIdByUserName = "select * from users where userName=?";
		Users users = qr.query(conn, sqlSelectUserIdByUserName, new BeanListHandler<Users>(Users.class),values.get("userName")).get(0);
	   System.out.println(users.getUserId());
	   String sql = "update usersinfo set userPicture = ?,userEmail=?,userPhone=?,userSex=?,userBirth=?,userSpe=? where userId=?";
		qr.update(conn, sql,fileName.get(0),values.get("Email"),values.get("Phone"),values.get("userSex"),values.get("Birthday"),values.get("UserSpe"),users.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
