package org.sykj.bbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sykj.bbs.pojo.BclassInfo;
import org.sykj.bbs.pojo.BclassTheme;
import org.sykj.bbs.pojo.Theme;
import org.sykj.bbs.utils.DBManager;

public class BclassInfoDao {
	  
	Connection conn = DBManager.getConn();
	
	QueryRunner qr = new QueryRunner();
	
	
	

	/**
	 * 全部版块信息
	 * @return
	 * 
	 */
	public List<BclassInfo> selectAll() {
		      Connection conn = this.conn;
               String sql = "select b.*,m.MdId,m.UserId,u.AuthId,u.State,u.UserName,u.UserPwd,a.AuthMsg from bclass b LEFT JOIN moderator m on b.ClassId=m.ClassId LEFT JOIN users u on m.UserId=u.UserId LEFT JOIN auth a on u.AuthId=a.AuthId";
               
               List<BclassInfo> bl = null;
               
               try {
            	   
				bl= qr.query(conn, sql, new BeanListHandler<BclassInfo>(BclassInfo.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
		return bl;
	}
	
	
	/**
	 *  点击版块信息
	 * @param classId
	 * @return
	 * 
	 */
	public BclassTheme selectByclassId(Integer classId) {
	      Connection conn = this.conn;
	      
	      String sqlThis ="select * from bclass b LEFT JOIN  moderator m ON b.ClassId=m.ClassId LEFT JOIN users u on m.UserId=u.UserId where b.ClassId="+classId;
	      
	    
	 	 String sqlTheme="select t1.tid,t1.*,COUNT(r.ThemeId) ThemeReplyCount FROM (select t.ThemeId tid,t.*,tc.ThemeClassName,u.UserName,u.UserPwd,u.AuthId,u.State,b.ClassName,b.ClassMsg,b.ClassPicture "
	 			 						+"from theme t,themeclass tc,users u,bclass b where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ClassId=b.ClassId "
	 			 						+"and t.ClassId="+classId+"  ORDER BY t.ThemeIsTop=0,t.ThemeSign=0,t.ThemeTime desc) t1 "
										+"LEFT JOIN reply r on t1.tid=r.ThemeId GROUP BY t1.tid ORDER BY t1.ThemeIsTop=0,t1.ThemeSign=0,t1.ThemeTime desc";

	 	String sqlCount="select COUNT(*) from theme t,themeclass tc,users u,bclass b where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ClassId=b.ClassId and t.ClassId="+classId+"";
	 	
	 	String sqlEliteCount="select COUNT(*) from theme t,themeclass tc,users u,bclass b where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ClassId=b.ClassId and t.ThemeSign=1 and t.ClassId="+classId+"";
	 	
	 	String sqlNoReplyCount="select COUNT(*) from theme t,themeclass tc,users u,bclass b where t.ThemeClassId=tc.ThemeClassId and t.UserId=u.UserId and t.ClassId=b.ClassId and t.ClassId="+classId+" and t.ThemeId not in (SELECT ThemeId FROM reply)";
	 	
         
         BclassTheme bt = new BclassTheme();
         
    	
         
         try {
        	    //版块对象赋值
        	    bt= qr.query(conn, sqlThis, new BeanListHandler<BclassTheme>(BclassTheme.class)).get(0);
        	 
        	    List<Theme> tl = qr.query(conn, sqlTheme, new BeanListHandler<Theme>(Theme.class));
        	  
        	    
        	    
        	    
        	    // 版块所属主题贴赋值           
        		bt.setTl(tl);
        		
        		Long count = qr.query(conn,sqlCount,new ScalarHandler<Long>(1));		
        		//总帖数量赋值
        		bt.setThemeCount(count.intValue());
        		
        		Long eliteCount = qr.query(conn,sqlEliteCount,new ScalarHandler<Long>(1));
        		//精品帖数量赋值
        		bt.setSignCount(eliteCount.intValue());
        		
        		Long noReplyCount = qr.query(conn,sqlNoReplyCount,new ScalarHandler<Long>(1));
        		//未回复帖数量赋值
        		bt.setNoReplyCount(noReplyCount.intValue());
               	 
        	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	
	return bt;
}

}
