package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.sykj.bbs.pojo.Bclass;
import org.sykj.bbs.pojo.BclassPage;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.pojo.UsersPage;
import org.sykj.bbs.utils.DBManager;

import com.sun.org.apache.regexp.internal.recompile;

public class UsersDao {
	
	Connection conn = DBManager.getConn();
	QueryRunner qr = new QueryRunner();
	/**
	 * 后台查询全部查全部
	 * @param usersPage
	 * @param search 
	 * @return
	 * @throws Exception
	 */
	public UsersPage query(UsersPage usersPage, String search) throws Exception {
			   String sql = "select * from users u,auth a where u.authId=a.authId and ( u.userName like '%"+search+"%' or a.authMsg like '%"+search+"%') limit "+usersPage.getStart()+","+usersPage.getEnd();
			   String sqlCount="select count(*) from users u,auth a where u.authId=a.authId and ( u.userName like '%"+search+"%' or a.authMsg like '%"+search+"%') ";
			   Long sd = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
			   usersPage.setTotal(sd.intValue());
			   List<Users> query = qr.query(conn, sql, new BeanListHandler<Users>(Users.class));
			for (Users users : query) {
				System.out.println(users);
			}
			usersPage.setRows(query);
			   System.out.println(sql);
			    System.out.println(sqlCount);
			   return usersPage;
	}
	/**
	 * 板块中修改版主时查全部用户
	 * @return
	 */
	public List<Users> selectAllUsers() {
		String sql = "select * from users ";
		List<Users> query=null;
		try {
		 query = qr.query(conn, sql, new BeanListHandler<Users>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return query;
		
	}
	
	/**
	 * 后台改密码
	 * @param userId
	 * @param userPwd
	 */
	public void update(String userId,String userPwd) {
		String sql  = "update users set userPwd = ? where userId = ?";
		try {
			qr.update(conn, sql, userPwd,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 后台加入黑名单
	 * @param userId
	 * @param userState 
	 */
	public void updateJoin(String userId, String userState) {
		String sql = "update users set state = ? where userId = ?";
		try {
			qr.update(conn, sql, userState,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * 前台登陆按用户名查密码
 * @param userName
 */
	public Users selectIf(String userName) {
		List<Users> selectAllUsers = selectAllUsers();
		boolean flag=false;
		for (Users users : selectAllUsers) {
			if(users.getUserName().equals(userName)){
				flag=true;
				break;
			}
		}
		if(flag){
			String sql = "select * from users u,auth a,usersinfo i where u.authId=a.authId and u.userId=i.userId and u.userName=?";
			Users users=null;
			try {
				users = qr.query(conn, sql, new BeanListHandler<Users>(Users.class),userName).get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
		}
		return null;
	}
	@Test
	public void fun(){
		Users selectIf = selectIf("张三");
		System.out.println(selectIf);
	}
	/**
	 * 前台注册时添加users表中的数据
	 * @param values
	 */
	public void insert(Map<String, String> values) {
//{Birthday=1991-04-20, Phone=12312312312, userNmae=123, Email=123@, userSex=男, UserPassA=西施, UserPassQ=你的女朋友是谁?, UserSpe=1, Pwd1=qweqwe, Pwd2=qweqwe}
		String sql = "insert into users values (null,?,?,3,'Y')";
		try {
			qr.insert(conn, sql, new ScalarHandler<Long>(1), values.get("userName"),values.get("Pwd2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 前台修改时，修改users表中的数据
	 * @param values
	 */
	public void update(Map<String, String> values) {
		//	{Birthday=1995-01-01, Phone=12345678912, Email=aaa@qq.com, userSex=女, userName=张三, UserSpe=JSP, Pwd1=1234561, Pwd2=1234561}
		String sql = "update users set userPwd =? where userName=?";
		try {
			qr.update(conn, sql, values.get("Pwd2"),values.get("userName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 找回密码成功后修改密码
	 * @param userName
	 * @param pwd
	 */
	public void updateByUserName(String userName, String pwd) {
		String sql = "update users set userPwd =? where userName=?";
		try {
			qr.update(conn, sql, pwd,userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void fun1(){
		System.out.println("sd");
	}
}
