package org.sykj.bbs.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sykj.bbs.dao.BclassDao;
import org.sykj.bbs.dao.BclassInfoDao;
import org.sykj.bbs.dao.ModeratorDao;
import org.sykj.bbs.dao.StateThemeAndReplyDao;
import org.sykj.bbs.dao.ThemeClassDao;
import org.sykj.bbs.dao.ThemeDao;
import org.sykj.bbs.dao.ThemeHpDao;
import org.sykj.bbs.dao.ThemeInfoDao;
import org.sykj.bbs.dao.UsersThemeFDao;
import org.sykj.bbs.pojo.Bclass;
import org.sykj.bbs.pojo.BclassInfo;
import org.sykj.bbs.pojo.BclassTheme;
import org.sykj.bbs.pojo.Moderator;
import org.sykj.bbs.pojo.Reply;
import org.sykj.bbs.pojo.Theme;
import org.sykj.bbs.pojo.Themeclass;
import org.sykj.bbs.pojo.Users;
import org.sykj.bbs.utils.OnlineCounter;
import org.sykj.bbs.pojo.ThemeInfo;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		String state = request.getParameter("state");

		if (state!=null&&!"".equals(state)) {

			if (state.equals("BclassInfo")) {
				BclassInfo(request,response);
			}else if (state.equals("newTheme")) {

				newTheme(request,response);

			}else if (state.equals("EliteTheme")) {

				EliteTheme(request,response);

			}else if (state.equals("HotTheme")) {

				HotTheme(request,response);

			}else if (state.equals("onClass")) {

				onClass(request,response);

			}else if (state.equals("ThemeClass")) {
				fThemeClass(request,response);

			}else if (state.equals("ThemeViewCount")) {

				ThemeViewCount(request,response);

			}else if (state.equals("ThemeInfo")) {

				ThemeInfo(request,response);

			}else if (state.equals("onThemeInfoReply")) {

				onThemeInfoReply(request,response);

			}else if (state.equals("btnClassThemeChange")) {

				btnClassThemeChange(request,response);


			}else if (state.equals("bClassFTheme")) {

				bClassFTheme(request,response);

			}else if (state.equals("btnThemefChange")) {

				btnThemefChange(request,response);

			}else if (state.equals("btnTfxChange")) {

				btnTfxChange(request,response);

			}else if (state.equals("btnThemeUpdateChange")) {

				btnThemeUpdateChange(request,response);

			}else if (state.equals("SelectModeratorUserId")) {

				SelectModeratorUserId(request,response);

			}else if (state.equals("removeLogin")) {

				removeLogin(request,response);


			}else if (state.equals("SelectThemeIdByClassId")) {

				SelectThemeIdByClassId(request,response);
			}
















		}



	}





	/**
	 * 閫氳繃涓婚甯朓D鏌ョ増鍧桰D
	 */
	private void SelectThemeIdByClassId(HttpServletRequest request, HttpServletResponse response) {
		String SThemeId = request.getParameter("ThemeId");	
		int ThemeId = Integer.parseInt(SThemeId);

		BclassDao bd = new BclassDao();

		Bclass bc =    bd.SelectThemeIdByClassId(ThemeId);


		String json = JSON.toJSONString(bc);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);



	}





	/**
	 * @param request
	 * @param response
	 * 娉ㄩ攢鐧诲綍
	 */
	private void removeLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		request.getSession().setAttribute("user", null);

		System.out.println("relogin"+request.getSession().getAttribute("user"));
//		OnlineCounter.reduce();  
		String json=JSON.toJSONString("NOUSER");
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter	out = response.getWriter();
			out.write(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 閫氳繃鍒嗙被ID鏌ョ敤鎴稩D
	 */
	private void SelectModeratorUserId(HttpServletRequest request, HttpServletResponse response) {
		String SClassId = request.getParameter("ClassId");	
		int ClassId = Integer.parseInt(SClassId);
		ModeratorDao md = new ModeratorDao();
		List<Moderator> lm = md.ClassIdByUserIdSelect(ClassId);
		String json = JSON.toJSONString(lm);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);

	}

	/**
	 * 涓婚甯栫紪杈�
	 */
	private void btnThemeUpdateChange(HttpServletRequest request, HttpServletResponse response) {
		String state2 = request.getParameter("state2");		
		String SThemeId = request.getParameter("ThemeId");
		int ThemeId = Integer.parseInt(SThemeId);
		String ThemeTitle = request.getParameter("ThemeTitle");
		String ThemeBody = request.getParameter("ThemeBody");
		UsersThemeFDao utd = new UsersThemeFDao();






		if (state2!=null&&!"".equals(state2)) {

			if (state2.equals("ThemeUedit")){	

				utd.updateThemeEditorUp(ThemeId,ThemeTitle,ThemeBody);





			}






		}


		String json = JSON.toJSONString("OK!");
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);




	}

	/**
	 * 涓婚甯栨ゼ灞傛搷浣滃垹闄�淇敼绛�
	 */
	private void btnTfxChange(HttpServletRequest request, HttpServletResponse response) {
		String state2 = request.getParameter("state2");		
		String SReplyId = request.getParameter("ReplyId");
		int ReplyId = Integer.parseInt(SReplyId);

		UsersThemeFDao utd = new UsersThemeFDao();
		StateThemeAndReplyDao std = new StateThemeAndReplyDao();

		if (state2!=null&&!"".equals(state2)) {
			//妤煎眰鍥炲鍒犻櫎鎿嶄綔
			if (state2.equals("del")){	
				Users user = std.ReplyIdByUserSelect(ReplyId);

				utd.updateDelByReply(ReplyId);

				//鐢ㄦ埛鍒犻櫎鍥炲鍑忕Н鍒� //鍥炲鍐呭 exp -10 money-5

				String sql = "UPDATE usersinfo set UserExp=UserExp-10,UserMoney=UserMoney-5 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql);	

			}



		}



		String json = JSON.toJSONString("OK!");
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);








	}

	/**
	 * @param request
	 * @param response
	 * 涓婚甯栬鎯呴〉鎿嶄綔 鍒犻櫎/缃《绛�.
	 * 
	 */
	private void btnThemefChange(HttpServletRequest request, HttpServletResponse response) {
		String state2 = request.getParameter("state2");
		String SThemeId = request.getParameter("ThemeId");
		int ThemeId = Integer.parseInt(SThemeId);
		StateThemeAndReplyDao std = new StateThemeAndReplyDao();
		Users user = std.ThemeIdByUserSelect(ThemeId);

		System.out.println(state2+" "+ThemeId);
		UsersThemeFDao utd = new UsersThemeFDao();
		String sql="";

		if (state2!=null&&!"".equals(state2)) {

			//鍒犻櫎
			if (state2.equals("del")){			
				sql = "DELETE t.*,r.* FROM theme t LEFT JOIN reply r  ON t.ThemeId=r.ThemeId where t.ThemeId="+ThemeId;

				//鐢ㄦ埛鍒犻櫎鍑忕Н鍒�  exp -10 money-5       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp-10,UserMoney=UserMoney-5 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);	

				//鍙栨秷缃《
			}else if (state2.equals("qtop")) {

				sql = "UPDATE theme set ThemeIsTop=0 where ThemeId="+ThemeId;

				//鍙栨秷绮惧崕甯�
			}else if (state2.equals("qsign")) {

				sql = "UPDATE theme set ThemeSign=0 where ThemeId="+ThemeId;



				//缃《
			}else if (state2.equals("top")) {

				sql = "UPDATE theme set ThemeIsTop=1 where ThemeId="+ThemeId;

				//鐢ㄦ埛缃《鍔犵Н鍒� exp +20money+10       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp+20,UserMoney=UserMoney+10 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);	


				//绮惧崕甯�
			}else if (state2.equals("sign")) {

				sql = "UPDATE theme set ThemeSign=1 where ThemeId="+ThemeId;

				//鐢ㄦ埛绮惧崕鍔犵Н鍒� exp +15money+8       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp+15,UserMoney=UserMoney+8 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);

			}




			std.UpdateTableThemeAndReply(sql);

			String json = JSON.toJSONString("OK!");
			response.setContentType("application/json;charset=utf-8");      
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			out.write(json);


		}







	}

	/**
	 * 鏉垮潡椤靛彂琛ㄤ富棰樺笘
	 */
	private void bClassFTheme(HttpServletRequest request, HttpServletResponse response) {
		//data:{state:"bClassFTheme",ThemeTitle:FthemeTitle,ThemeBody:FThemeBody,ClassId:FclassId,ThemeClassId:FthemeClassId,UserId:FuserId}
		String ThemeTitle = request.getParameter("ThemeTitle");
		String ThemeBody = request.getParameter("ThemeBody");
		String SClassId = request.getParameter("ClassId");
		String SThemeClassId = request.getParameter("ThemeClassId");
		String SUserId = request.getParameter("UserId");
		int  ClassId = Integer.parseInt(SClassId);
		int  ThemeClassId = Integer.parseInt(SThemeClassId);
		int  UserId= Integer.parseInt(SUserId);

		UsersThemeFDao utd = new UsersThemeFDao();

		//娣诲姞涓婚
		utd.insertByTheme(ThemeTitle,ThemeBody,ClassId,ThemeClassId,UserId);   

		//鐢ㄦ埛鍙戣〃鍔犵Н鍒� //Ueditor鍥炲鍐呭 exp +10 money+5       		
		String sql = "UPDATE usersinfo set UserExp=UserExp+10,UserMoney=UserMoney+5 where UserId="+UserId;
		utd.UpdateUserExpMoney(UserId,sql);	

		String json = JSON.toJSONString("OK!");
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);



	}

	/**
	 * 鐗堝潡椤垫搷浣滃笘瀛�
	 */
	private void btnClassThemeChange(HttpServletRequest request, HttpServletResponse response) {
		String state = request.getParameter("state");
		//鎿嶄綔澹版槑 锛氬垹闄�缃《/璁剧簿鍗庡笘绛�.
		String state2 = request.getParameter("state2");

		String SThemeId = request.getParameter("ThemeId");

		//涓婚甯朓D
		int ThemeId = Integer.parseInt(SThemeId);

		StateThemeAndReplyDao std = new StateThemeAndReplyDao();
		UsersThemeFDao utd = new UsersThemeFDao();

		Users user = std.ThemeIdByUserSelect(ThemeId);

		String sql="";



		if (state2!=null&&!"".equals(state2)) {

			//鍒犻櫎
			if (state2.equals("del")){			
				sql = "DELETE t.*,r.* FROM theme t LEFT JOIN reply r  ON t.ThemeId=r.ThemeId where t.ThemeId="+ThemeId;

				//鍒犻櫎鍑忕Н鍒�  exp -10 money-5       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp-10,UserMoney=UserMoney-5 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);	

				//鍙栨秷缃《
			}else if (state2.equals("qtop")) {

				sql = "UPDATE theme set ThemeIsTop=0 where ThemeId="+ThemeId;

				//鍙栨秷绮惧崕甯�
			}else if (state2.equals("qsign")) {

				sql = "UPDATE theme set ThemeSign=0 where ThemeId="+ThemeId;
				//缃《
			}else if (state2.equals("top")) {

				sql = "UPDATE theme set ThemeIsTop=1 where ThemeId="+ThemeId;

				//鐢ㄦ埛缃《鍔犵Н鍒� exp +20money+10       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp+20,UserMoney=UserMoney+10 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);	

				//绮惧崕甯�
			}else if (state2.equals("sign")) {

				sql = "UPDATE theme set ThemeSign=1 where ThemeId="+ThemeId;

				//鐢ㄦ埛绮惧崕鍔犵Н鍒� exp +15money+8       		
				String sql2 = "UPDATE usersinfo set UserExp=UserExp+15,UserMoney=UserMoney+8 where UserId="+user.getUserId();
				utd.UpdateUserExpMoney(user.getUserId(),sql2);

			}


			std.UpdateTableThemeAndReply(sql);

			String json = JSON.toJSONString("OK!");
			response.setContentType("application/json;charset=utf-8");      
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			out.write(json);


		}







	}

	/**
	 * 甯栧瓙璇︽儏椤靛彂琛ㄥ洖澶�
	 */
	private void onThemeInfoReply(HttpServletRequest request, HttpServletResponse response) {

		//涓婚璐碔D
		String SThemeId = request.getParameter("themeId");

		int ThemeId = Integer.parseInt(SThemeId);
		//鐧婚檰鐢ㄦ埛ID
		String SUserId = request.getParameter("rUserIdValue");

		int UserId = Integer.parseInt(SUserId);

		//鍥炲鍐呭
		String ReplyBody= request.getParameter("ReplyValue");

		UsersThemeFDao utd = new UsersThemeFDao();

		Users user = utd.selectByUserId(UserId);

		//鐢ㄦ埛鍥炲鍔犵Н鍒� //Ueditor鍥炲鍐呭 exp +10 money+5

		String sql = "UPDATE usersinfo set UserExp=UserExp+10,UserMoney=UserMoney+5 where UserId="+UserId;
		utd.UpdateUserExpMoney(UserId,sql);	

		Reply reply = utd.insertByReply(ThemeId, ReplyBody, user.getUserId(), user.getUserName());



		String json = JSON.toJSONString(reply);
		System.out.println("returnReply:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);


	}

	/**
	 * 涓婚甯栬鎯�
	 */
	private void ThemeInfo(HttpServletRequest request, HttpServletResponse response) {

		ThemeInfoDao tid = new ThemeInfoDao();
		String ThemeId = request.getParameter("themeId");
		ThemeInfo ti = tid.selectAll(Integer.parseInt(ThemeId));                                 
		String json = JSON.toJSONString(ti);
		System.out.println("selectThemeInfo:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);



	}

	/**
	 * 鐐瑰嚮甯栧瓙娴忚鏁伴噺+1
	 */
	private void ThemeViewCount(HttpServletRequest request, HttpServletResponse response) {

		String ThemeId = request.getParameter("themeId");

		ThemeDao td = new ThemeDao();
		Theme t= td.selectByThemeViewCount(Integer.parseInt(ThemeId));                        
		int count = t.getThemeViewCount();
		count+=1;

		td.updateByThemeViewCount(Integer.parseInt(ThemeId), count);


	}

	/**
	 * 涓嬫媺鍒楄〃鏌ヨ涓婚鍒嗙被
	 */
	private void fThemeClass(HttpServletRequest request, HttpServletResponse response) {

		ThemeClassDao tcd = new ThemeClassDao();

		List<Themeclass> tcl = tcd.selectAll();

		String json = JSON.toJSONString(tcl);
		System.out.println("selectThemeClass:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);

	}

	/**
	 * 鏌ヨ鐐瑰嚮鏉垮潡淇℃伅
	 * @param request
	 * @param response
	 * 
	 */
	private void onClass(HttpServletRequest request, HttpServletResponse response) {

		String classId = request.getParameter("classID");

		System.out.println("on classID:"+classId);
		BclassInfoDao bid = new BclassInfoDao();

		BclassTheme bt = bid.selectByclassId(Integer.parseInt(classId));

		String json = JSON.toJSONString(bt);
		System.out.println("onBclassInfoJSON:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);



	}

	/**
	 * 鏌ヨ鎵�湁鏉垮潡
	 * @param request
	 * @param response
	 */
	private void BclassInfo(HttpServletRequest request, HttpServletResponse response) {

		BclassInfoDao bid = new BclassInfoDao();

		List<BclassInfo> bl = bid.selectAll();

		String json = JSON.toJSONString(bl);
		System.out.println("BclassInfoJSON:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);

	}


	/**
	 * 鏈�柊涓婚
	 * @param request
	 * @param response
	 */
	private void newTheme(HttpServletRequest request, HttpServletResponse response) {


		ThemeHpDao thd = new ThemeHpDao();
		List<Theme> tl = 	thd.selectNewTheme();
		String json = JSON.toJSONString(tl);
		System.out.println("ThemeHpNew:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);

	}


	/**
	 *
	 * 鏈�柊绮惧崕甯�
	 * @param request
	 * @param response
	 */
	private void EliteTheme(HttpServletRequest request, HttpServletResponse response) {
		ThemeHpDao thd = new ThemeHpDao();
		List<Theme> tl = 	thd.selectEliteTheme();
		String json = JSON.toJSONString(tl);
		System.out.println("ThemeHpElite:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);



	}


	/**
	 * 鐑棬鍥炲璐�
	 * @param request
	 * @param response
	 */
	private void HotTheme(HttpServletRequest request, HttpServletResponse response) {
		ThemeHpDao thd = new ThemeHpDao();
		List<Theme> tl = 	thd.selectHotTheme();
		String json = JSON.toJSONString(tl);
		System.out.println("ThemeHpHot:"+json);
		response.setContentType("application/json;charset=utf-8");      
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
		out.write(json);

	}

}
