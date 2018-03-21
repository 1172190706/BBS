package org.sykj.bbs.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sykj.bbs.dao.UsersDao;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.pojo.UsersPage;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BackstageUsersManagerServlet
 */
@WebServlet("/backstageUsersServlet")
public class BackstageUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackstageUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("backstageUsersServlet");
		String state = request.getParameter("state").trim();
		System.out.println(state);
		if(state!=null&&!"".equals(state)){
			if("Manager".equals(state)){
				Manager(request,response);
			}else if ("updatePwd".equals(state)) {
				updatePwd(request,response);
			}else if ("join".equals(state)) {
				join(request,response);
			}else if ("selectAllUsers".equals(state)) {
				selectAllUsers(request,response);
			}
		}
	}
	
/**
 * 查全部用户，改版主
 * @param request
 * @param response
 */
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) {
		try {
		UsersDao backstageUsersDao = new UsersDao();
		List<Users> selectAllUsers = backstageUsersDao.selectAllUsers();
		 String json=JSON.toJSONString(selectAllUsers);
		 System.out.println("selectAllUsers"+json);
		 response.setContentType("application/json;charset=utf-8");
		 PrintWriter out = response.getWriter();
			out.write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * 加入黑名单
	 * @param request
	 * @param response
	 */
	private void join(HttpServletRequest request, HttpServletResponse response) {
		try {
		String userId = request.getParameter("userId");
		String userState = request.getParameter("userState");
		System.out.println(userId+":"+userState);
		UsersDao backstageUsersDao = new UsersDao();
		backstageUsersDao.updateJoin(userId,userState);
		 response.setContentType("text/html;charset=utf-8");	
			PrintWriter	out = response.getWriter();
			out.write("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

	/**
	 * 修改密码
	 * @param request
	 * @param response
	 */
private void updatePwd(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("sd");
		try {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd").trim();
		System.out.println(userId+":"+userName+":"+userPwd);
		UsersDao backstageUsersDao = new UsersDao();
		backstageUsersDao.update(userId,userPwd);
		 response.setContentType("text/html;charset=utf-8");	
		  PrintWriter	out = response.getWriter();
		 out.write("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

/**
 * 查全部
 * @param request
 * @param response
 */
	private void Manager(HttpServletRequest request, HttpServletResponse response) {
		UsersPage usersPage = new UsersPage();
		UsersDao backstageUsersDao = new UsersDao();
		String search =request.getParameter("search");
		System.out.println(search);
		if(search==null)search="";
		String start =request.getParameter("offset");
		String end =request.getParameter("limit");
		System.out.println(start+":"+end);
		usersPage.setStart(Integer.parseInt(start));
		usersPage.setEnd(Integer.parseInt(end));
		   try {
			   usersPage = backstageUsersDao.query(usersPage,search);
			 String json=JSON.toJSONString(usersPage);
			 System.out.println(json);
			 response.setContentType("application/json;charset=utf-8");
			 PrintWriter out = response.getWriter();
			 out.write(json);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
