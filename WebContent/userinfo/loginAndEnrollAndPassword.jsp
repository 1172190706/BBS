<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

		<link rel="stylesheet" href="css/front.css" />
		<link rel="stylesheet" href="css/layout.css" />
		<link rel="stylesheet" href="css/whole.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-table.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/verify.css" />

		
		<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
		<script type="text/javascript" src="js/front.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table-zh-CN.js" ></script>
	    <script type="text/javascript" src="js/verify.js" ></script>
</head>

<body>
<p>
  <button type="button" class="btn btn-primary btn-lg" id="login">登陆</button>
    <button type="button" class="btn btn-primary btn-lg" id="update">修改</button>
  <button type="button" class="btn btn-primary btn-lg" id="enroll">注册</button>
</p>

<div class="modal fade" tabindex="-1" role="dialog" id="loginModal"><!-- 登陆modal  id为loginModal -->
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">登陆</h4>
      </div>
      <div class="modal-body">
      
      <form class="form-horizontal" id="loginForm">
  <div class="form-group">
    <div class="col-sm-12">
      <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名/手机/邮箱">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-12">
      <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="密码">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-12">
      <input type="hidden" class="form-control"  name="state" value="login">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-12">
     <div class="checkbox">
       <p style="text-align: center;">
        <label>
          <a onclick="enroll()" style="margin-left:1px">立即注册</a>  
        </label>
        <label style="width: 390px"></label>
        <label >
          <a  >忘记密码</a>  
          </label>
          </p>
     </div>
    </div>
  </div>
   <div class="form-group">
     <div class="col-sm-12" style="text-align: center;">
       <img  src="images/2_223_79969_503_501.jpg" id="loginHeadImg">
    </div>
  </div>
 <div class="form-group">
    <div class="col-sm-12" >
      <p style="text-align: center;">
      <button type="button" class="btn btn-success btn-lg" id="loginBotton" style="width: 300px ">登陆</button>
      </p>
    </div>
  </div>
</form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" tabindex="-1" role="dialog" id="enrollModal"><!--  注册modal  id为enrollModal  -->
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">注册</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" id="enrollForm">
  <div class="form-group">
    <label for="inputName" class="col-sm-3 control-label">用户名：</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="enrollUserName" name="userNmae">
    </div>
     <div class="col-sm-4">
      <span  id="span1" >请输入至少3位字符</span></p>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword1" class="col-sm-3 control-label">密码：</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="enrollPwd1" name="Pwd1" >
    </div>
    <div class="col-sm-4">
     <span id="span2" >请输入6至16位字符</span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword2" class="col-sm-3 control-label">确认密码：</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="enrollPwd2" name="Pwd2" >
    </div>
    <div class="col-sm-4">
     <span id="span3" >确认密码</span>
    </div>
  </div>
  <div class="form-group">
   <label for="inputPhone" class="col-sm-3 control-label">手机号：</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="enrollPhone" name="Phone" >
    </div>
    <div class="col-sm-4">
     <span id="span4" >请输入11电话号码</span>
    </div>
  </div>
   <div class="form-group">
   <label for="inputEmail" class="col-sm-3 control-label">注册邮箱：</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="enrollEmail" name="Email" >
    </div>
    <div class="col-sm-4">
     <span id="span5" >邮箱必须含有@且位于第四位</span>
    </div>
  </div>
  <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">生日：</label>
    <div class="col-sm-5">
      <input type="date" class="form-control" id="enrollBirthday" name="Birthday" >
    </div>
    <div class="col-sm-4">
     <span id="span6">请输入您的生日</span>
    </div>
  </div>
    <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">性别：</label>
     <div class="radio">
    <div class="col-sm-4">
        <label>
          <input type="radio" name="userSex" value="男" checked="checked">男
        </label>
    </div>
    <div class="col-sm-5">
        <label>
          <input type="radio" name="userSex" value="女">女
        </label>
    </div>
       </div>
  </div>
  <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">擅长领域：</label>
    <div class="col-sm-9">
    <select id="enrollUserSpe" name="UserSpe" class="form-control">
    </select>
    </div>
  </div>
  <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">请选择头像：</label>
    <div class="col-sm-9">
        <input type="file" class="form-control" id="enrollHeadImg" name="headImg" >
       <!--  不选头像返回"" -->
    </div>
  </div>
   <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">密保问题：</label>
    <div class="col-sm-5">
    <select id="enrollUserPassQ" name="UserPassQ" class="form-control">
    <option value="" selected="selected">请选择问题</option>
    </select>
    </div>
    <div class="col-sm-4">
    <select id="enrollUserPassA" name="UserPassA" class="form-control">
    </select>
    </div>
  </div>
   <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">请通过验证：</label>
    <div class="col-sm-9">
        <div id="mpanel1" >
        </div>
    </div>
  </div> 
  <!--  <div class="form-group">
    <div class="col-sm-12">
       <input type="hidden" name="UserRegTime" id="userRegTime"/>
    </div>
  </div>  -->
</form>
      </div>
      <div class="modal-footer" >
        <button type="button" id="close" class="btn btn-default" data-dismiss="modal" >关闭</button>
        <button type="button" id="enrollOk" class="btn btn-primary" disabled="disabled" >提交</button>
      </div>
       <script type="text/javascript">
        $('#mpanel1').slideVerify({//验证
    		type : 1,		//类型
    		vOffset : 5,	//误差量，根据需求自行调整
	        barSize : {
	        	width : '550%',
	        	height : '50px',
	        },
	        ready : function() {
	    	},
	        success : function() {
	       $("#enrollOk").removeAttr("disabled")
	        },
	        error : function() {
         //	        	alert('验证失败！');
	        }
	        
	    });
        </script>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

  <script type="text/javascript">
  var user=null;//定义登陆时点登陆按钮后返回的user对象，若没有则返回null
  
  $("#enrollUserName").on("blur",function(){//注册时验证用户名是否符合规范\
	  var a=$("#enrollUserName").val();
	  if (a.length<3) {
		 // alert(123);
		  $("#span1").empty();
		  $("#span1").append("用户名输入有误！");
		  $("#span1").attr("style","color:red");
		}else{
			  $("#span1").empty();
			 $("#span1").append("输入正确");
			  $("#span1").attr("style","color:black");
		};
  }); 
  
  $("#enrollPwd1").on("blur",function(){//注册时验证用户名是否符合规范
	  var a=$("#enrollPwd1").val();
  alert(a);
	  if (a.length<6||a.length>16) {
		 // alert(123);
		  $("#span2").empty();
		  $("#span2").append("密码输入有误！");
		  $("#span2").attr("style","color:red");
		}else{
			  $("#span2").empty();
			 $("#span2").append("输入正确");
			  $("#span2").attr("style","color:black");
		};
  }); 
  
  $("#enrollPwd2").on("blur",function(){//再次输入密码
	  var a=$("#enrollPwd1").val();
	  var b=$("#enrollPwd2").val();
	  if (a==b&&b.length>=6&&b.length<=16) {
		  $("#span3").empty();
			 $("#span3").append("输入正确");
			  $("#span3").attr("style","color:black");
		 // alert(123);
		}else{
			 $("#span3").empty();
			  $("#span3").append("密码输入有误！");
			  $("#span3").attr("style","color:red"); 
		};
  }); 
  
  $("#enrollPhone").on("blur",function(){//注册时验证电话号码是否符合规范
	  var photo=$("#enrollPhone").val();
		var reg1 = /^1\d{10}$/; 
	if (!reg1.test(photo)) {
		 $("#span4").empty();
		  $("#span4").append("电话号码格式错误！");
		  $("#span4").attr("style","color:red"); 
	}else{
		 $("#span4").empty();
		 $("#span4").append("输入正确");
		  $("#span4").attr("style","color:black");
		};
  }); 
  
  $("#enrollEmail").on("blur",function(){//注册时验证邮箱是否符合规范
	 // indexOf 方法返回一个整数值，指出 String 对象内子字符串的开始位置。如果没有找到子字符串，则返回 -1。
	  var email=$("#enrollEmail").val();
	if (email.indexOf('@')==3) {
		 $("#span5").empty();
		 $("#span5").append("输入正确");
		  $("#span5").attr("style","color:black");
	}else{
		 $("#span5").empty();
		  $("#span5").append("邮箱格式错误！");
		  $("#span5").attr("style","color:red"); 
		
		};
  }); 
  
	$("#userName").on("blur",function(){//登陆时输入账号后失去焦点时更改头像
		$.ajax({
			 url:"/BBS/pioseniumServlet",
			 type:"get",
			 data:"userName="+$("#userName").val()+"&state=headImg",
			 dataType:"json",
			 success:function(data){
				 alert(data.userPicture);
				$("#loginHeadImg").attr("src",data.userPicture);
			 }
		 });
	});
	
 function enroll(){//点登陆模态框里的注册时关闭登陆模态框，显示注册模态框
	  $("#loginModal").modal("hide");
	 $("#enrollModal").modal("show");
 };
 
 $.ajax({//查擅长领域下拉框的内容
	 url:"/BBS/pioseniumServlet",
	 type:"get",
	 data:"state=selectAllBclass",
	 dataType:"json",
	 success:function(data){
		  $.each(data,function(i,n){//data是数组要循环遍历
         $("#enrollUserSpe").append("<option value='"+n.classId+"'>"+n.className+"</option>");
		  })
	 }
 });
 
  $(function(){//页面加载完成后执行
	  var citys = {//定义问题以及答案
				"你的教员是谁?":["鹏鹏","花花","绿绿"],
				"你的女朋友是谁?":["西施","恐龙"],
				"你的男票是谁?":["唐僧","猪八戒","孙悟空","沙和尚"]
				};
	  for(var key in citys){//向问题下拉框中加入option
         $("#enrollUserPassQ").append("<option value='"+key+"'>"+key+"</option>");
	  }
	  $("#enrollUserPassQ").on("change",function(e){//当问题下拉框改变时
		  event=e||event;
		//  alert(event.target.value);//湖北省
		var cityArray =citys[event.target.value];//长沙,湘潭 object
		//console.log($("#UserPassA option"));
		$("#enrollUserPassA").empty();//清除答案下拉框中的内容
	   for(var i in cityArray){////向答案下拉框中加入option
		//alert(cityArray[i]);
        $("#enrollUserPassA").append("<option value='"+cityArray[i]+"'>"+cityArray[i]+"</option>");
	    }  
	  });
	  
	  $("#login").on("click",function(e){//输入完成后点登陆按钮
		    event=e||event;
		   event.preventDefault();//清除表单中的提交功能 
		  $("#loginModal").modal("show");
		  $("#loginBotton").off();
		  $("#loginBotton").on("click",function(){
			 // alert($("#userId").val());
			 if($("#userName").val()==""||$("#userPwd").val()==""){
				 alert("用户名或密码为空！");
				 return;
			 }
			 $.ajax({
		    		 url:"/BBS/pioseniumServlet",
					 data:$("#loginForm").serialize(),
					 success:function(data){
						alert(data);
						
					 }
		    	});
			  $("#loginModal").modal("hide");
		  });
	  });
	  
	  $("#enroll").on("click",function(e){//注册时弹出模态框
		    event=e||event;
		/* 	$(":checked").removeAttr("checked");
			$(":selected").removeAttr("selected"); */
		    $("#enrollModal").modal("show");
		    $("#enrollOk").off();
		    $("#enrollOk").on("click",function(){//注册提交按钮
		 
		    	if($("#enrollUserName").val().length<3){
		    		alert("请完善用户名信息");
		    		return;
		    	}
		    	  
		    	  $.ajax({//查用户名是否被占用
		    			 url:"/BBS/pioseniumServlet",
		    			 type:"get",
		    			 data:"state=selectAllUserName&userNmae="+$("#enrollUserName").val(),
		    			 dataType:"json",
		    			 success:function(data){
		    				 alert(123);
		    			 }
		    		 });
		    	  
		    	  
		    	 if($("#enrollPwd1").val().length<6||$("#enrollPwd1").val().length>16){
		    		 alert("请完善密码信息");
			    		return;
		    	 } 
		    	 if(($("#enrollPwd2").val().length<6||$("#enrollPwd2").val().length>16)||$("#enrollPwd1").val()!=$("#enrollPwd2").val()){
		    		 alert("请完善密码信息");
			    		return;
		    	 } 
		    	 var photo=$("#enrollPhone").val();
		 		var reg1 = /^1\d{10}$/; 
		    	 if(!reg1.test(photo)){
		    		 alert("请完善手机号码信息");
			    		return;
		    	 } 
		    	 var email=$("#enrollEmail").val();
		    	 if(email.indexOf('@')!=3){
		    		 alert("请完善邮箱信息");
			    		return;
		    	 } 
		    	 if($("#enrollBirthday").val()==""){
		    		 alert("请选择您的生日");
			    		return;
		    	 } 
		    	   if($("#enrollUserPassQ").val()==""){
		    		 alert("请选择保密问题");
			    		return;
		    	 }    
		    	
				 var fd = new FormData($("#enrollForm")[0]);//通过[0]将jQuery转换成js
					console.log(fd);
		    	  $.ajax({
		    		 url:"/BBS/pioseniumServlet?state=enroll",
		    		 data:fd,
					 type:"post",
					 dataType:"json",
					 processData:false,
					 contentType:false,
					 success:function(data){
						alert(123);
						/*  $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 }); */
					 }
		    	});	
		  
		    });
	  });
  });
  </script>


</body>
</html>