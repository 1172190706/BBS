<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>



<style type="text/css">
body {
	font-family: Microsoft YaHei UI
}

#adminMenubg {
	margin: 0 auto;
}
</style>

</head>
<body>
	<div id="adminMenubg">
		<ul class="nav nav-pills nav-justified">
			<li role="presentation" class="active"><a href="bclass.jsp"
				id="onBclass" onclick="return false" target="">版块管理</a></li>
			<li role="presentation"><a href="users.jsp" id="onUsers"
				onclick="return false">用户管理</a></li>
			<li role="presentation"><a href="theme.jsp" id="onTheme"
				onclick="return false">主题帖管理</a></li>
		</ul>
	</div>

	<%-- <div id="bclass"><jsp:include page='bclass.jsp' /> </div> --%>
	<iframe width="100%" height="1283px" frameborder="0" scrolling="no" src="admin/bclass.jsp"> </iframe>


	<script type="text/javascript">

$(function(){
	
	   $(".nav-pills li").click(function(e){
	       e.preventDefault();
	       $(this).addClass("active").siblings().removeClass("active");
	   });

	   
		$("#onBclass").on("click",function(){
			$("iframe").attr('src', "admin/bclass.jsp");
		});
	   
		$("#onUsers").on("click",function(){
			$("iframe").attr('src', "admin/users.jsp");
		});
		$("#onTheme").on("click",function(){
			$("iframe").attr('src', "admin/theme.jsp");
		});
	   
	   

	
})


</script>


</body>
</html>