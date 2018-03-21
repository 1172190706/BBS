package org.sykj.bbs.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sykj.bbs.dao.StateThemeAndReplyDao;
import org.sykj.bbs.dao.ThemeDao;
import org.sykj.bbs.dao.UsersThemeFDao;
import org.sykj.bbs.pojo.ThemePage;
import org.sykj.bbs.pojo.Users;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BackstageThemeServlet
 */
@WebServlet("/backstageThemeServlet")
public class BackstageThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackstageThemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("backstageThemeServlet");
		String state = request.getParameter("state").trim();
		System.out.println(state);
		if(state!=null&&!"".equals(state)){
			if("Manager".equals(state)){
				Manager(request,response);
			}else if ("top".equals(state)) {
				top(request,response);
			}else if ("sign".equals(state)) {
				sign(request,response);
			}else if ("delete".equals(state)) {
				delete(request,response);
			}
		}
		
	}
	/**
	 * 删除帖子
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
        String themeId =request.getParameter("themeId");
		System.out.println(themeId);
		int ThemeId = Integer.parseInt(themeId);
		StateThemeAndReplyDao std = new StateThemeAndReplyDao();
		UsersThemeFDao utd = new UsersThemeFDao();
		Users user = std.ThemeIdByUserSelect(ThemeId);
		//删除减积分   exp -10 money-5       		
		String sql2 = "UPDATE usersinfo set UserExp=UserExp-10,UserMoney=UserMoney-5 where UserId="+user.getUserId();
		utd.UpdateUserExpMoney(user.getUserId(),sql2);	
		
		
		ThemeDao backstageThemeDao = new ThemeDao();
		backstageThemeDao.delete(themeId);
		 try {
			 response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 普通/精华帖
	 * @param request
	 * @param response
	 */
private void sign(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("sign");
		String themeId =request.getParameter("themeId");
		String themeSign =request.getParameter("themeSign");
		System.out.println(themeId+":"+themeSign);
		ThemeDao backstageThemeDao = new ThemeDao();
		backstageThemeDao.sign(themeId,themeSign);
		 try {
			 response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * 置顶
 * @param request
 * @param response
 */
	private void top(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("top");
		String themeId =request.getParameter("themeId");
		String isTopState =request.getParameter("isTopState");
		System.out.println(themeId+":"+isTopState);
		ThemeDao backstageThemeDao = new ThemeDao();
		backstageThemeDao.top(themeId,isTopState);
		 try {
			 response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * 查询全部并分页
 * @param request
 * @param response
 */
	private void Manager(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Manager");
		String search =request.getParameter("search");
		System.out.println(search);
		if(search==null)search="";
		String start =request.getParameter("offset");
		String end =request.getParameter("limit");
		System.out.println(start+":"+end);
		try {
		ThemePage themePage = new ThemePage();
		themePage.setStart(Integer.parseInt(start));
		themePage.setEnd(Integer.parseInt(end));
		ThemeDao backstageThemeDao = new ThemeDao();
		themePage=backstageThemeDao.Query(themePage,search);
		 String json=JSON.toJSONString(themePage);
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
