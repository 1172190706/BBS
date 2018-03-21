package org.sykj.bbs.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sykj.bbs.dao.BclassDao;
import org.sykj.bbs.dao.ModeratorDao;
import org.sykj.bbs.dao.ThemeDao;
import org.sykj.bbs.dao.UsersDao;
import org.sykj.bbs.pojo.BclassPage;
import org.sykj.bbs.pojo.Theme;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BackstageBclassManager
 */
@WebServlet("/backstageBclassServlet")
public class BackstageBclassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackstageBclassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("backstageBclassServlet");
		String state = request.getParameter("state").trim();
		System.out.println(state);
		if(state!=null&&!"".equals(state)){
			if("Manager".equals(state)){
				Manager(request,response);
			}else if ("Delete".equals(state)) {
				Delete(request,response);
			}else if ("updateModerator".equals(state)) {
				updateModerator(request,response);
			}
		}
		
		
	}
/**
 * 更改版主
 * @param request
 * @param response
 */
	private void updateModerator(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("updateModerator");
		String classId = request.getParameter("classId");
		System.out.println(classId);
		String[] userIds = request.getParameterValues("userId");
		 try {
		ModeratorDao backstageModeratorDao =new ModeratorDao();
		backstageModeratorDao.delete(classId);
		for (String string : userIds) {
			backstageModeratorDao.insert(string,classId);
		}
		 response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * @param request
	 * @param response
	 */
private void Delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
		try {
		String classId = request.getParameter("classId");
		System.out.println("classid="+classId);
		ThemeDao themeDao = new ThemeDao();
		List<Theme> arr = themeDao.selectAllThemeByClassId(classId);
		System.out.println("arr="+arr);
		
		if(arr.size()!=0){
			System.err.println("arr不为null");
			 response.setContentType("text/html;charset=utf-8");
			 //如返回的是字符串就不能用application/json
			 PrintWriter out = response.getWriter();
			 out.write("此板块中有帖子，不能删除！");
			
		}else {
			System.err.println("arr为null");
		 BclassDao bclassDao = new BclassDao();
		 bclassDao.delete(classId);
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 out.write("删除成功！");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


   /**
    * 查询全部分页
    * @param request
    * @param response
    */
	private void Manager(HttpServletRequest request, HttpServletResponse response) {
       System.out.println();
		System.out.println("manager");
		String search = request.getParameter("search");
		System.out.println(search);
		if(search==null)search="";
		String start =request.getParameter("offset");
		String end =request.getParameter("limit");
		System.out.println(start+":"+end);
		BclassPage bclassPage= new BclassPage();
		bclassPage.setStart(Integer.parseInt(start));
		bclassPage.setEnd(Integer.parseInt(end));
		  BclassDao backstageBclassDao = new BclassDao();
		   try {
			   bclassPage = backstageBclassDao.query(bclassPage,search);
			 String json=JSON.toJSONString(bclassPage);
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
