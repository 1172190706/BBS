package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.sykj.bbs.pojo.ReplyInfo;
import org.sykj.bbs.pojo.Theme;
import org.sykj.bbs.pojo.ThemeInfo;
import org.sykj.bbs.utils.DBManager;

public class ThemeInfoDao {
	
	
	Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();

	public ThemeInfo selectAll(int ThemeId)  {
		
	     Connection conn = this.conn;
	     
         String sqlThis = "select * from theme t,users u,usersinfo ui,bclass b,themeclass tc where t.UserId=u.UserId "
        		+ "and u.UserId=ui.UserId and t.ClassId=b.ClassId "
                +"and t.ThemeClassId=tc.ThemeClassId and t.ThemeId="+ThemeId;
         
         
         String sqlReplyList = "select * from reply r LEFT JOIN users u on r.UserId=u.UserId LEFT JOIN "
         		+ "usersinfo ui on r.UserId=ui.UserId Where r.ThemeId="+ThemeId+" ORDER BY r.ReplyTime ASC";
         
         ThemeInfo ti = null;
		
		try {
			ti=qr.query(conn, sqlThis, new BeanListHandler<ThemeInfo>(ThemeInfo.class)).get(0);
			
		   List<ReplyInfo> replyList = qr.query(conn, sqlReplyList, new BeanListHandler<ReplyInfo>(ReplyInfo.class));
		   
		   ti.setReplyList(replyList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ti;
	}
	
	
	

}
