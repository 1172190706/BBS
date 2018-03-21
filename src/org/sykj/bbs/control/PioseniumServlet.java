package org.sykj.bbs.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sykj.bbs.dao.BclassDao;
import org.sykj.bbs.dao.UsersDao;
import org.sykj.bbs.dao.UsersinfoDao;
import org.sykj.bbs.pojo.Bclass;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.pojo.Usersinfo;
import org.sykj.bbs.utils.OnlineCounter;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class PioseniumLogin
 */
@WebServlet("/pioseniumServlet")
public class PioseniumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PioseniumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("pioseniumServlet");
            String state = request.getParameter("state");
    		System.out.println(state);
    		if(state!=null&&!"".equals(state)){
    		if("login".equals(state)){
    			login(request,response);
    		}else if("selectAllBclass".equals(state)){
    			selectAllBclass(request,response);
			}else if("headImg".equals(state)){
				headImg(request,response);
			}else if("enroll".equals(state)){
				enroll(request,response);
			}else if("selectAllUserName".equals(state)){
				selectAllUserName(request,response);
			}else if("forgetPassword".equals(state)){
				forgetPassword(request,response);
			}else if("selectUser".equals(state)){
				selectUser(request,response);
			}else if("update".equals(state)){
				update(request,response);
			}else if("updatePwd".equals(state)){
				updatePwd(request,response);
			}
      }
	}
	/**
	 * 每次刷新首页时发请求判断是否登陆及权限
	 * @param request
	 * @param response
	 *//*
	private void Islogin(HttpServletRequest request, HttpServletResponse response) {
		
		
	}*/

	/**
	 * 找回密码成功后修改密码
	 * @param request
	 * @param response
	 */
	private void updatePwd(HttpServletRequest request, HttpServletResponse response) {
		try {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("Pwd2");
		System.out.println(userName+":"+pwd);
		UsersDao usersDao = new UsersDao();
		usersDao.updateByUserName(userName,pwd);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}

	/**
	 *修改信息
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("update");
		List<String> fileName=new ArrayList<String>();
		Map<String, String> values=new HashMap<String,String>();
		 try {
			 //磁盘文件工厂
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 // Servlet文件上传对象
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 // 设置请求头编码
			 upload.setHeaderEncoding("utf-8");//解决文件乱码
			// 参数化请求头数据
			List<FileItem> pr = upload.parseRequest(request);
			// 数据遍历
			for (FileItem fileItem : pr) {
		    //如果不是普通表单数据则就是要上传文件
				if(!fileItem.isFormField()){
					//获取文件绝对路径
					String name=fileItem.getName();
					System.out.println(name);//C:\Users\Administrator\Desktop\feature.xml
					//获取文件的最后一个"\"的下标
				int index = name.lastIndexOf("\\");
		    // 通过最后一个"\"的下标截取文件名
				if(index>0){
					name = name.substring(index+1);
					System.out.println(name);//feature.xml
				}
				fileName.add("images/"+name);
				System.out.println(request.getContextPath());//  /jsp-upload
				System.out.println(request.getServletContext().getRealPath("images"));//C:/Tomcat 7.0/webapps/jsp-upload/upload
			//	获取文件夹的绝对路径创建文件对象( 在/Tomcat 7.0/webapps下创建一个“upload”文件夹用来放上传文件 )
	            File file = new File(request.getServletContext().getRealPath("images"));
	            //判断文件是否存在，如果不存在就创建一个。
	           if(!file.exists()){
	        	   file.mkdirs();
	           }
	        //   上传文件写入磁盘中( 将“upload”文件夹中名字为name的文件写入磁盘 )
	           File file2=new File(file, name);
	           fileItem.write(file2);
				}else {
					String sdf=fileItem.getFieldName();
					System.out.println(sdf);
					String value=fileItem.getString("utf-8");//解决内容乱码
					System.out.println(value);
					values.put(sdf, value);
				}
			}
			System.out.println(fileName);//[images/t0101ce5a5ad9fae9bf.jpg]
			System.out.println(values);
		//	{Birthday=1995-01-01, Phone=12345678912, Email=aaa@qq.com, userSex=女, userName=张三, UserSpe=JSP, Pwd1=1234561, Pwd2=1234561}
			UsersDao usersDao = new UsersDao();//修改users表中的数据
			usersDao.update(values);
			UsersinfoDao usersinfoDao =new UsersinfoDao();//修改usersinfo表中的数据
			usersinfoDao.update(fileName,values);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
	     	out.write("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
		
	}

	/**
	 * 前台修改密码时，发Ajax请求查登陆用户
	 * @param request
	 * @param response
	 */
	private void selectUser(HttpServletRequest request, HttpServletResponse response) {
		try {
		Users user = (Users) request.getSession().getAttribute("user");
		System.out.println("updateUser:"+user);
		String json=JSON.toJSONString(user);
		if(user==null){
		json=JSON.toJSONString("NOUSER");
	   }
		  response.setContentType("application/json;charset=utf-8");
		   PrintWriter	out = response.getWriter();
			out.write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	/**
	 * 找回密码
	 * @param request
	 * @param response
	 */
	private void forgetPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
		System.out.println("forgetPassword");
		String userName = request.getParameter("forgetUserName");
		String userPassQ = request.getParameter("UserPassQ");
		String userPassA = request.getParameter("UserPassA");
		System.out.println(userName);
		System.out.println(userPassQ);
		System.out.println(userPassA);
		UsersDao usersDao = new UsersDao();
		Users user = usersDao.selectIf(userName);
		System.out.println("user="+user);
		if(user==null){
			System.out.println("qwe");
		   response.setContentType("text/html;charset=utf-8");
  		   PrintWriter out = response.getWriter();
			out.write("1");
			}else {
				System.out.println("sddf");
				System.out.println("user.getUserId()="+user.getUserId());
				UsersinfoDao usersinfoDao = new UsersinfoDao();
			    Usersinfo usersInfo = usersinfoDao.selectInfo(user.getUserId());
				System.out.println(usersInfo.getUserPassQ());
				System.out.println(usersInfo.getUserPassA());
				if(userPassQ.equals(usersInfo.getUserPassQ())&&userPassA.equals(usersInfo.getUserPassA())){
					 String json=JSON.toJSONString(user);
					 System.out.println(json);
			         response.setContentType("application/json;charset=utf-8");
					   PrintWriter out = response.getWriter();
						out.write(json);
				}else {
					 response.setContentType("text/html;charset=utf-8");
			  		   PrintWriter out = response.getWriter();
						out.write("1");
				}
			}
		 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 查是否有重名的用户名
	 * @param request
	 * @param response
	 */
	private void selectAllUserName(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("----------------");
		try {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		UsersDao usersDao=new UsersDao();
		Users user = usersDao.selectIf(userName);
		System.out.println(user);
		String json=JSON.toJSONString(user);
		System.out.println("json="+json);
		  response.setContentType("application/json;charset=utf-8");
		   PrintWriter out = response.getWriter();
			out.write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 登陆，带文件上传
	 * @param request
	 * @param response
	 */
	private void enroll(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("enroll");
		List<String> fileName=new ArrayList<String>();
		Map<String, String> values=new HashMap<String,String>();
		 try {
			 //磁盘文件工厂
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 // Servlet文件上传对象
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 // 设置请求头编码
			 upload.setHeaderEncoding("utf-8");//解决文件乱码
			// 参数化请求头数据
			List<FileItem> pr = upload.parseRequest(request);
			// 数据遍历
			for (FileItem fileItem : pr) {
		    //如果不是普通表单数据则就是要上传文件
				if(!fileItem.isFormField()){
					//获取文件绝对路径
					String name=fileItem.getName();
					System.out.println(name);//C:\Users\Administrator\Desktop\feature.xml
					//获取文件的最后一个"\"的下标
				int index = name.lastIndexOf("\\");
		    // 通过最后一个"\"的下标截取文件名
				if(index>0){
					name = name.substring(index+1);
					System.out.println(name);//feature.xml
				}
				fileName.add("images/"+name);
				System.out.println(request.getContextPath());//  /jsp-upload
				System.out.println(request.getServletContext().getRealPath("images"));//C:/Tomcat 7.0/webapps/jsp-upload/upload
			//	获取文件夹的绝对路径创建文件对象( 在/Tomcat 7.0/webapps下创建一个“upload”文件夹用来放上传文件 )
	            File file = new File(request.getServletContext().getRealPath("images"));
	            //判断文件是否存在，如果不存在就创建一个。
	           if(!file.exists()){
	        	   file.mkdirs();
	           }
	        //   上传文件写入磁盘中( 将“upload”文件夹中名字为name的文件写入磁盘 )
	           File file2=new File(file, name);
	           fileItem.write(file2);
				}else {
					String sdf=fileItem.getFieldName();
					System.out.println(sdf);
					String value=fileItem.getString("utf-8");//解决内容乱码
					System.out.println(value);
					values.put(sdf, value);
				}
			}
			System.out.println(fileName);//[images/2.jpg]
			System.out.println(values);
			//{Birthday=1991-04-20, Phone=12312312312, userNmae=123, Email=123@, userSex=男, UserPassA=西施, UserPassQ=你的女朋友是谁?, UserSpe=1, Pwd1=qweqwe, Pwd2=qweqwe}
			UsersDao usersDao = new UsersDao();//注册添加users表中的数据
			usersDao.insert(values);
			UsersinfoDao usersinfoDao =new UsersinfoDao();//注册时添加usersinfo表中的数据
			usersinfoDao.insert(fileName,values);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
	     	out.write("1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	/**
	 * 登陆时按userName查头像路径
	 * @param request
	 * @param response
	 */
	private void headImg(HttpServletRequest request, HttpServletResponse response) {
		try {
		System.out.println("img");
		String userName = request.getParameter("userName");
		System.out.println(userName);
		if(userName==null)userName="";
		 UsersDao usersDao=new UsersDao(); 
		 Users user = usersDao.selectIf(userName);
		 System.out.println("user="+user);
		 if(user==null){
			 user=new Users();
			 user.setUserId(1);
			 user.setUserName(userName);
			 user.setUserPwd("213");
			 user.setState("Y");
			 user.setAuthMsg("普通用户");
			 user.setAuthId("1");
			 user.setUserPicture("images/2_223_79969_503_501.jpg");
		 }
		 String json=JSON.toJSONString(user);
		 System.out.println(json);
         response.setContentType("application/json;charset=utf-8");
		   PrintWriter out = response.getWriter();
			out.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 注册时查询全部板块，确定擅长领域。
	 * @param request
	 * @param response
	 */
private void selectAllBclass(HttpServletRequest request, HttpServletResponse response) {
	try {
		BclassDao bclassDao=new BclassDao();
		List<Bclass> arr=bclassDao.selectAll();
		  String json=JSON.toJSONString(arr);
		      System.out.println(json);
	          response.setContentType("application/json;charset=utf-8");
			   PrintWriter out = response.getWriter();
			   out.write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

/**
 * 登陆
 * @param request
 * @param response
 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
		String userName= request.getParameter("userName").trim();
          System.out.println("userName="+userName);
          String userPwd= request.getParameter("userPwd").trim();
          System.out.println("userPwd="+userPwd);
         UsersDao usersDao=new UsersDao(); 
         Users user = usersDao.selectIf(userName);
         System.out.println("user="+user);
         if(user!=null&&userPwd.equals(user.getUserPwd())&&user.getState().equals("Y")){
        	 request.getSession().setAttribute("user", user);
//        		OnlineCounter.raise();  
         }
         if(user!=null&&!userPwd.equals(user.getUserPwd())||user.getState().equals("N")){
        	 user=null;
         }
          String json=JSON.toJSONString(user);
          System.out.println("json="+json);
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
