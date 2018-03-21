<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/verify.css" />
    <script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
		<script type="text/javascript" src="js/verify.js" ></script>
  
</head>
<body>
 <%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 Date date = new Date();
%>
<input type="text" value=<%=sdf.format(date)%>/>
           
<SCRIPT LANGUAGE="JavaScript">
  var myDate = new Date();
alert(myDate);
  myDate.getYear();    //获取当前年份(2位)
  myDate.getFullYear();  //获取完整的年份(4位,1970-????)
  myDate.getMonth();   //获取当前月份(0-11,0代表1月)
  myDate.getDate();    //获取当前日(1-31)
  myDate.getDay();    //获取当前星期X(0-6,0代表星期天)
  myDate.getTime();    //获取当前时间(从1970.1.1开始的毫秒数)
  myDate.getHours();   //获取当前小时数(0-23)
  myDate.getMinutes();  //获取当前分钟数(0-59)
  myDate.getSeconds();  //获取当前秒数(0-59)
  myDate.getMilliseconds();  //获取当前毫秒数(0-999)
  myDate.toLocaleDateString();  //获取当前日期
  var mytime=myDate.toLocaleTimeString();  //获取当前时间
  myDate.toLocaleString( );    //获取日期与时间
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 alert(sdf.format(myDate.toLocaleString( )));
if (mytime<"23:30:00")
{
alert(mytime);
}
</SCRIPT>
</body>
</html>