<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Twoi.css" />
	
			<link rel="stylesheet" href="css/verify.css" />
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
			<script type="text/javascript" src="js/front.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table-zh-CN.js" ></script>
	
	 <script type="text/javascript" src="js/verify.js" ></script>
	
	    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">


</style>


	
		<script type="text/javascript">
		    var 	totalSize=0;	
		    var curSize=3;
		    var curPage = 1;	
		    var totalPage=1;
		    var classId=0;
		</script>

  <script type="text/javascript">

  
  //全部版块  
  $.ajax({
	  url:"HomePageServlet",
	  type:"post",
	  data:{state:"BclassInfo"},
	  dataType:"json",
	  cache:true,
	  success:function(data){
		/*   console.log("data:"+data); */
		  var mName="";
		  $.each(data,function(i,n){ 
			  
			  
			  var mName = n.userName;
			  
			  if(mName==""||mName=="undefined"||mName==null){
				  mName="未指定"
				  
			  }
			  
				$("#bodybg2").append(""
				         +"  <table border='0' class='tableclass' cellspacing='0'>"
				         +"   <tr> <td rowspan='4' align='center' class='td_on line-limit-length wd'> <img alt='' src='"+n.classPicture+"'>    <td colspan='2' class='td_on line-limit-length'> 版块名称:<b>"+n.className+"</b></td></tr>"
				         +"     <tr>  <td colspan='2' class='td_on line-limit-length'> 版块介绍: <b>"+n.classMsg+"</b></td></tr>"
				         +"     <tr>  <td colspan='2' class='td_on line-limit-length'>版主: <b class='mName'>"+mName+"</b> </td></tr>  "
				         +"     <tr>  <td colspan='2' class='td_on line-limit-length'><input type='hidden' value='"+n.classId+"'/> </td></tr>  "
				         +"  </table>"
				         +"  ");		 
				
				  
			

		  });
		  		  
	  } ,	  
	  error:function(XMLHttpRequest, textStatus, errorThrown){
		/*   alert("Ajax error!")	   */
	  }
	  
  });
  
  
  //最新主题
  $.ajax({
	  url:"HomePageServlet",
	  type:"post",
	  data:{state:"newTheme"},
	  dataType:"json",
	  success:function(data){
		/*   console.log("dataNewTheme:"+data);   */
		  $.each(data,function(i,n){ 
			  if(i<10){	  
				  /* console.log("dataNewTheme:"+n.themeTitle+"  "+n.userName); */
				  $("#newTheme").append("<p>  <a href='#' value="+n.themeId+" class='line-limit-length-newTheme Tonclick'> "+n.themeTitle +"</a><b>["+n.userName+"]</b></p>");
			  }
			
		  });
		  		  
	  } ,	  
	  error:function(XMLHttpRequest, textStatus, errorThrown){
		 /*  alert("Ajax error!")	   */
	  }
	  
  });
  
  
  //最新精华帖
  $.ajax({
	  url:"HomePageServlet",
	  type:"post",
	  data:{state:"EliteTheme"},
	  dataType:"json",
	  success:function(data){
		 /*  console.log("dataEliteTheme:"+data);   */
		  $.each(data,function(i,n){ 
			  if(i<10){	  
				 /*  console.log("dataEliteTheme:"+n.themeTitle+"  "+n.userName); */
				  $("#newElite").append("<p><a href='#' value="+n.themeId+" class='line-limit-length-newTheme Tonclick'> "+n.themeTitle +"</a><b>["+n.userName+"]</b></p>");
			  }
			
		  });
		  		  
	  } ,	  
	  error:function(XMLHttpRequest, textStatus, errorThrown){
		 /*  alert("Ajax error!")	   */
	  }
	  
  });
  
  
  //最热回复贴
  $.ajax({
	  url:"HomePageServlet",
	  type:"post",
	  data:{state:"HotTheme"},
	  dataType:"json",
	  success:function(data){
		/*   console.log("dataHotTheme:"+data);   */
		  $.each(data,function(i,n){ 
			  if(i<10){	  
				/*   console.log("dataHotTheme:"+n.themeTitle+"  "+n.userName); */
				  $("#hotTheme").append("<p><a href='#' value="+n.themeId+" class='line-limit-length-newTheme Tonclick'> "+n.themeTitle +"</a><b>["+n.userName+"]</b></p>");
			  }
			
		  });
		  		  
	  } ,	  
	  error:function(XMLHttpRequest, textStatus, errorThrown){
		  /* alert("Ajax error!")	   */
	  }
	  
  });
  
  
  

  
  
  
  
  </script>
  
  <script type="text/javascript">
 $(function(){
	 
	 
	  //注销登录
		$("#removeLogin").on("click",function(){


			  $.ajax({
				  url:"HomePageServlet",
				  type:"post",
				  data:{state:"removeLogin"},
				  dataType:"json",
				  success:function(data){
					  flag1=data;
					window.location.reload();
					  		  
				  } 
				  
			  });
			
			
			
		});
	 
	 
	 
	 
/*              每次刷新首页时发请求判断是否登陆及权限                                            */
            $.ajax({
	    		 url:"${pageContext.request.contextPath}/pioseniumServlet?state=selectUser",
				 type:"post",
				 async:false,
				 dataType:"json",
				 cache:false,
				 success:function(data){
					 flag1=data;
					 if(flag1=="NOUSER"){
						 $("#personalCenter").hide(0);
					  }else {
						//  alert(222);
						//  alert(flag1.authId);
						
						$("#personalCenter").html("<img src='"+flag1.userPicture+"'>"+flag1.userName+"<span class='caret'></span>");
						
						
						  if(flag1.authId==1){
							  $("#onAdmin").attr("style","display: block;");
							  $("#login").attr("style","display: none;");
							  $("#enroll").attr("style","display: none;");
							  $("#personalCenter").attr("style","display: block;");
						  }else {
							  $("#login").attr("style","display: none;");
							  $("#enroll").attr("style","display: none;");
							  $("#personalCenter").attr("style","display: block;");
							  
					
						}   
				 }
					 }
 });
 
 
});
  </script>
  
  


</head>
<body>



                                <!-- 登录后台，弹出模态框验证 -->
<div class="modal fade" tabindex="-1" role="dialog" id="onAdminModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="text-align: center;">登录后台</h4>
      </div>
      <div class="modal-body">
        <div class="row">
   <label class="col-sm-3 ">请通过验证：</label>
    <div class="col-sm-9">
      <div id="mpanel3" style="margin-top: 20px">
        </div>
        <button type="button" id="check-btn2" class="verify-btn">确定</button>
    </div>
  </div> 
      </div>
      <div class="modal-footer" style="text-align: center;">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="onAdminBotton" disabled="disabled">提交</button>
      </div>
       <script type="text/javascript">
       $('#mpanel3').codeVerify({
   		type : 2,
   		figure : 100,	//位数，仅在type=2时生效
   		arith : 0,	//算法，支持加减乘，不填为随机，仅在type=2时生效
	    	width : '200px',
	    	height : '50px',
	    	fontSize : '30px',
	    	btnId : 'check-btn2',
	    	ready : function() {
	    	},
	    	success : function() {
	    		  $("#onAdminBotton").removeAttr("disabled")
	    	},
	    	error : function() {
	    		alert('验证码不匹配！');
	    	}
	    });
        </script>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->







	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation"  >
  <div class="container-fluid" >
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">TwoBBS</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active" ><a href="index.jsp" id="onIndex" onclick="return false">首页</a></li>
        <li><a href="#" id="onAdmin" onclick="return false" style="display: none;" >后台管理</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
  <!--         <input type="text" class="form-control" placeholder="搜索"> -->
        </div>
   <!--      <button type="submit" class="btn btn-default">搜索</button> -->
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" id="enroll">注册</a></li>
        <li><a href="#" id="login">登录</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="personalCenter">个人中心 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#" id="update">修改</a></li>
            <li class="divider"></li>
            <li><a href="#" id="removeLogin">注销登录</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>






<!-- bgdiv -->
<div id="bgdiv">

  <!-- bgxdiv -->
  <div id="bgxdiv">
  
      <!-- headbg -->
    <div id="headbg" >
               <img alt="" src="images/home icon1 likeWhite.png" >    论坛
    <!--/ headbg -->
    </div>
    
       <!-- bodybg -->
       <div id="bodybg" class=" container container-fluid " >
       
              <div class="row rowf" >                 
                 <div class="col-md-4 col-sm-4 col-xs-4 col-lg-4 rowmenu rborder"  >最新主题帖</div>
                 <div class="col-md-4 col-sm-4 col-xs-4 col-lg-4 rowmenu rborder"  >最新精华帖</div>
                 <div class="col-md-4 col-sm-4 col-xs-4 col-lg-4  rowmenu " >热门回复帖</div>
              </div>
              
              <div class="row rowf2" >                 
                 <div id="newTheme" class="col-md-4 col-sm-4 col-xs-4 col-lg-4 rowmenu2 rborder"  > </div>
                 <div id="newElite" class="col-md-4 col-sm-4 col-xs-4 col-lg-4 rowmenu2 rborder"  ></div>
                 <div id="hotTheme" class="col-md-4 col-sm-4 col-xs-4 col-lg-4 rowmenu2"   ></div>
              </div>
              
              
              
      <!--/ bodybg -->
     </div>

       <!-- headbg2 -->
    <div id="headbg2" >
                  &nbsp; &nbsp;技术交流
    <!--/ headbg2 -->
    </div>
    
        
    <!-- bodybg2 -->
    <div id="bodybg2">
    
           <!-- 板块DIV -->
          


  <div class="clear"></div>  
    
     <!--/ bodybg2 -->
    </div>
    
    
    
    <script type="text/javascript">
         $(function(){

    	
        var hei = $("#bodybg2").css("height");
        var num= hei.replace(/[^\d.]/g,"");

     	$("#bgxdiv").css({
    		height:(800+num*2.1)+"px" 		
    	}); 
    	
     
         /*----------板块点击事件-----------  */
        $(".td_on").on("click",function(){
        	/*点击 板块ID  */
        	var iValue =$(this).parent().parent().children().eq(3).children().children().val();
            classId = iValue;
           onClassfn();
           
           function onClassfn(){
           
           
    		$("#bgxdiv").children().remove();

    		
    		$("input[name='classId']").prop({
    			  value: classId
    		});
    		
    		/* 查询板块  */
    		 $.ajax({
    			  url:"HomePageServlet",
    			  type:"post",
    			  data:{state:"onClass",classID:classId},
    			  dataType:"json",
    			  cache:false,
    			  success:function(data){
    			/* 	  console.log(data.tl); */
    				  if(data.tl.length<=0){
    					 $("#tableTheme").after("<h4 style='position: absolute;top: 30%;left: 41.5%;'>该板块暂未发布主题帖</h4>");
    					  
    					  
    				  };
    				  $.each(data.tl,function(i,n){ 			 					 
  			 					$("#tableTheme").append(function(index, html){
  			 						//置顶帖&&精华帖判断
  			 						if(n.themeIsTop==1&&n.themeSign==1){
										return "<tr><td  rowspan='2' style='width: 40%; border: 0px solid red;' class='line-limit-length-TableTheme'><img src='images/topbg.png' style='width: 14px;height: 14px;'/><a href='#' value="+n.themeId+" class='Tonclick' ><b>[置顶]<img src='images/signbg.png' style='width: 14px;height: 14px;'/>[精华]"+n.themeTitle+"</b></a></td><td style='width: 20%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.userName+"</td><td rowspan='2' style='width: 10%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.themeReplyCount+"/"+n.themeViewCount+"</td><td style='width: 30%; border: 0px solid red;'rowspan='2'> <span><button type='button' value='"+n.themeId+"' class='clbtn' text='删除'>删除</button></span> <button type='button' value='"+n.themeId+"' class='clbtn' text='取消置顶'>取消置顶</button>   <button type='button' value='"+n.themeId+"' class='clbtn' text='取消精华帖'>取消精华帖</button> </span>  </td></tr>"
 	  	  			 					 +"<tr><td >"+n.themeTime+" </td> </tr><tr><td colspan='4'><hr></td></tr>";		
										
									}
  			 						
  			 						
  			 						
  			 						//置顶帖判断 topbg.png
  			 						if (n.themeIsTop==1) {	 							
  			 							return "<tr><td  rowspan='2' style='width: 40%; border: 0px solid red;' class='line-limit-length-TableTheme'><img src='images/topbg.png' style='width: 14px;height: 14px;'/><a href='#' value="+n.themeId+" class='Tonclick' ><b>[置顶]"+n.themeTitle+"</b></a></td><td style='width: 20%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.userName+"</td><td rowspan='2' style='width: 10%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.themeReplyCount+"/"+n.themeViewCount+"</td><td style='width: 30%; border: 0px solid red;' rowspan='2'> <span><button type='button' value='"+n.themeId+"' class='clbtn' text='删除'>删除</button></span> <button type='button' value='"+n.themeId+"' class='clbtn' text='取消置顶'>取消置顶</button>   <button type='button' value='"+n.themeId+"' class='clbtn'  text='设为精华帖'>设为精华帖</button> </span>  </td></tr>"
  	  	  			 					 +"<tr><td >"+n.themeTime+" </td> </tr><tr><td colspan='4'><hr></td></tr>";										
									};
									
									//精华帖判断  signbg.png
									if(n.themeSign==1){
										return "<tr><td  rowspan='2' style='width: 40%; border: 0px solid red;' class='line-limit-length-TableTheme'><img src='images/signbg.png' style='width: 14px;height: 14px;'/><a href='#' value="+n.themeId+" class='Tonclick' ><b>[精华]"+n.themeTitle+"</b></a></td><td style='width: 20%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.userName+"</td><td rowspan='2' style='width: 10%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.themeReplyCount+"/"+n.themeViewCount+"</td><td style='width: 30%; border: 0px solid red;' rowspan='2'> <span><button type='button' value='"+n.themeId+"' class='clbtn' text='删除'>删除</button></span> <button type='button' value='"+n.themeId+"' class='clbtn' text='置顶'>置顶</button>   <button type='button' value='"+n.themeId+"' class='clbtn' text='取消精华帖'>取消精华帖</button> </span>  </td></tr>"
 	  	  			 					 +"<tr><td >"+n.themeTime+" </td> </tr><tr><td colspan='4'><hr></td></tr>";	
									}
									
  			 						//普通贴
  			 						return "<tr><td  rowspan='2' style='width: 40%; border: 0px solid red;' class='line-limit-length-TableTheme'><a href='#' value="+n.themeId+" class='Tonclick' > "+n.themeTitle+"</a></td><td style='width: 20%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.userName+"</td><td rowspan='2' style='width: 10%; border: 0px solid blue;' class='line-limit-length-TableTheme'>"+n.themeReplyCount+"/"+n.themeViewCount+"</td><td style='width: 30%; border: 0px solid red;' rowspan='2'> <span><button type='button' value='"+n.themeId+"' class='clbtn' text='删除'>删除</button></span> <button type='button' value='"+n.themeId+"' class='clbtn' text='置顶'>置顶</button>   <button type='button' value='"+n.themeId+"' class='clbtn' text='设为精华帖'>设为精华帖</button> </span>  </td></tr>"
  	  			 					 +"<tr><td >"+n.themeTime+" </td></tr><tr><td colspan='4'><hr></td></tr>";
  			 						
  			 					});  
  			 					
  			 					
  			 					 				  
    				  });
    				  
    				  
    				//当前版主或管理员权限标识
    				var classFlag= false;  
    				  
    					$.ajax({
		     				url:"HomePageServlet",
		     				data:{state:"SelectModeratorUserId",ClassId:classId},
		     				type:"post",
		     				 cache:false,
		     				dataType:"json",
		     				success:function(data){ 		
		     		        $.each(data,function(i,n){    

		     			     if(flag1.userId==n.userId){
		     			    	classFlag=true;
		     			    	 
		     			     }
		     			
		     		        });
		     		        
		     		       if(flag1.authId==1){			  
		     		    		classFlag=true;		    					  
		    				  }
		     		       
		     		     if(classFlag==false){
		     		 	   $(".clbtn").addClass("hideClass1");	 
		     		     }  
		     		       		        
		     				
		     				} 				
		     			});
    				  
    				  
    				
    				  
    				  var state2="";
    				  var ThemeId=""
    				  
    				  $(".clbtn[text='删除']").on("click",function(){
    					/*   alert("删除");  */
    					  state2="del";   		  
    					  ThemeId = $(this).attr("value")
    					  ajaxCbtn();
    					   	  
    				  });
    				  
    				  $(".clbtn[text='置顶']").on("click",function(){
    					/*   alert("置顶");    */					  
    					  state2="top";
    					  ThemeId = $(this).attr("value")
    					  ajaxCbtn();	  
    				  });
    				  
    				  $(".clbtn[text='取消置顶']").on("click",function(){
    				/* 	  alert("取消置顶"); */
    					  state2="qtop";
    					  ThemeId = $(this).attr("value")
    					  ajaxCbtn(); 	  
    				  });
    				  
    				  $(".clbtn[text='设为精华帖']").on("click",function(){
    					  /* alert("设为精华帖"); */
    					  state2="sign";
    					  ThemeId = $(this).attr("value")
    					  ajaxCbtn(); 	  
    				  });
    				  
    				  $(".clbtn[text='取消精华帖']").on("click",function(){
    					  /* alert("取消精华帖"); */
    					  state2="qsign";
    					  ThemeId = $(this).attr("value")
    					  ajaxCbtn();
    				  });
    				  
    				  
    				  function ajaxCbtn(){
    					  
    					  
    						$.ajax({
    		     				url:"HomePageServlet",
    		     				data:{state:"btnClassThemeChange",state2:state2,ThemeId:ThemeId},
    		     				type:"post",
    		     				 cache:false,
    		     				dataType:"json",
    		     				success:function(data){ 		
    		     					//重新加载
    		     					$("#ueditor").appendTo("body");
    		     					   		$("#cancelfb").off();
     										$("#okfb").off();
     										$("#FTheme").off();
    		     					 onClassfn();
    		     				
    		     				} 				
    		     			});
    					  
    					  
    					  
    				  }
    				  
    		             var mName2=data.userName;
    		             
    		             if(mName2==""||mName2=="undefined"||mName2==null){
    		            	 mName2="未指定"
    					  
    				       }
    						 
    						  $("#classheadbg").html("技术交流>>"+data.className+"板块 <span>版主: <b id='classMname'>"+mName2+"</b></span>");
    						  
    			 			  $("#bgxdiv").append("<div id='rowf3'> <div class='row rowStyle'>"
    						 + "<div class='col-md-6 col-lg-6 col-xs-6' style='width: 40%;border: 0px solid red;'>标题</div>"
    						 + "<div class='col-md-2 col-lg-2 col-xs-2' style='width: 20%;border: 0px solid red;'>作者</div>"
    						 + "<div class='col-md-2 col-lg-2 col-xs-2' style='width: 10%; border: 0px solid blue;'>回复/人气</div>"
    						 + "<div class='col-md-2 col-lg-2 col-xs-2' style='width: 30%; border: 0px solid blue;'>操作</div>"
    				   + "</div>"
    				+"</div>"); 				  
    				  		  
    			 			  
    			 			  
    			 			  
    			 			  
    			 			  
    			  } ,	  
    			  error:function(XMLHttpRequest, textStatus, errorThrown){
    				  /* alert("Ajax error!")	   */
    			  }
    			  
    		  });
    		 	 
    		$("html,body").animate({scrollTop:0}, 50);
     		$("#bgxdiv").append("<div id='classheadbg'></div><table id='tableTheme'><tfoot><tr><td colspan='4' align='right'><button id='FTheme'>发帖</button> </td></tr></tfoot></table>"
     		+"<div id='chfbg'> <form id='formfb'><div id='chfbgx'><h5>发布主题帖</h5><input type='text' class='form-control inTitle' name='themeTitle' placeholder='请输入主题标题'> </div></form></div> ");
     		
     		
     		var bodyW=$(document.body).width();
     		var bodyH=$(document.body).height();
     		
     		$("#chfbg").css({
     			width:bodyW,
     			height:bodyH
     		});
     		
     		//实例化Ueditor
     	    var ue = UE.getEditor('editor',{  
     	    	 toolbars: [
     	    	        ['fullscreen', 'source', 'undo', 'redo', 'bold','italic','fontfamily', 'fontsize','forecolor','justifyleft', 
     	    	        'justifycenter', 'justifyright', 'justifyjustify','|', 'link', 'unlink', 'anchor', '|',
     	    	        'imagenone','simpleupload', 'insertimage', 'emotion',"|","help"]
     	    	    ],
     	    	    autoHeightEnabled: true,
     	    	    autoFloatEnabled: true,
     	    	    scaleEnabled:true,//设置不自动调整高度
     	    	    scaleEnabled:false, //是否可以拉伸长高
     	    	   autoHeightEnabled: false //自动高度
     	    });
     		 
     		 $("#ueditor").appendTo("#chfbgx")
     		 
     		
     		
     		
     		 //发布主题
     		$("#FTheme").on("click",function(){	  	
     			
     			if(flag1=="NOUSER"){
     				alert("您现在是游客不能发布主题,请登录！");
     				return;
     			};
     			
     			
     			$("#classSelect").children().not(":eq(0)").remove();
     			
     			//查询主题分类Ajax
     			$.ajax({
     				url:"HomePageServlet",
     				data:{state:"ThemeClass"},
     				type:"post",
     				dataType:"json",
     				cache:false,
     				success:function(data){ 					
     					$.each(data,function(i,n){
	                       $("#classSelect").append("<option value='"+n.themeClassId+"'>"+n.themeClassName+"</option>");
     					});		
     				} 				
     			});
     			
     			$("#ueditor").show(80);
     			$("#chfbg").show(220);
     			$("#chfbgx").show(220);
     		});
     		
     		
     		 //取消发布
     		$("#cancelfb").on("click",function(){	
     			$("#ueditor").hide(80);
     			$("#chfbgx").hide(120);
     			$("#chfbg").hide(120);
     		
     		});
     		 
     		//确认发布
   
     		$("#okfb").on("click",function(){		

     			/*  alert($("input[name='classId']").attr("value"));  */
     			
     			//主题内容
     		   var FThemeBody = UE.getEditor('editor').getContent();   
     		   //主题分类ID
     			var FthemeClassId = $("select[name='themeClassId']").val();
     			//主题标题
     			var FthemeTitle = $("input[name='themeTitle']").val();
     			//主题所属板块ID
     			var FclassId = classId;
     			//用户ID
     			var FuserId = flag1.userId;
     			
     			
     			FthemeTitle =	$.trim(FthemeTitle);
     			FThemeBody = $.trim(FThemeBody);
     			
     		
     			
     			if(FthemeTitle==""){ 				
     				alert("请输入主题标题");
     				return;
     			}
     			
     			if(FThemeBody==""){ 				
     				alert("请输入主题内容");
     				return;
     			}
     			
     			if(FthemeClassId=="请选择主题分类"){ 				
     				alert("请选择主题分类");
     				return;
     			}

     			
     			$.ajax({
     				url:"HomePageServlet",
     				data:{state:"bClassFTheme",ThemeTitle:FthemeTitle,ThemeBody:FThemeBody,ClassId:FclassId,ThemeClassId:FthemeClassId,UserId:FuserId},
     				type:"post",
     				dataType:"json",
     				cache:false,
     				success:function(data){ 					
     					
     					//发布完成后
     	     			
     	     			//重新加载
     						$("#ueditor").appendTo("body");
     						   		$("#cancelfb").off();
     								$("#okfb").off();
     								$("#FTheme").off();
     								 UE.getEditor('editor').setContent('');
     						 onClassfn();
     					
     					
     				} 				
     			});
     			
     			
     			
     		
     		
     		});
     		
     		
     		//function 结束
        } ;
        
        
        
        
      
        
        
        	
        });
         
         
         
    
         
         
         }); 
         
         
         $(function(){
        	 
             //================================帖子点击事件==========================================
                                                             //由于普通选择器事件有无效情况 所以这里用document
             	$(document).on("click",'.Tonclick',function(){           	 
            	 var valueA = $(this).attr("value");
            	 var Tflag = true;
            	 var ThemeTitle="";
            	 if(Tflag==true){onThemeRload()};
            	 
              //主题ID查版块ID  	 
     			$.ajax({
	     				url:"HomePageServlet",
	     				data:{state:"SelectThemeIdByClassId",ThemeId:valueA},
	     				type:"post",
	     				 cache:false,
	     				dataType:"json",
	     				success:function(data){ 		     		    
	     					classId=data.classId;
				 
	     				}
				 
					});
            	 
            	 
            	 
            	 function onThemeRload(){
            		 
            		 $("#bgxdiv").children().remove();
            		 /* $("body").remove("#chfbg2"); */
                $(".tbtncf").off();
				$("#FTheme2").off();
				$("#FReply").off();
				$(".Thfbtnxc").off();	
				$("#cancelUpdateBtn").off();	
				$("#ThxUpdate").off();	
				$("#cancelfb").off();	
				$("#cancelfb2").off();	
				$("#okfb").off();	
				$("#okfb2").off();
				 $(document).off();
            	
            	 
            	var TonHeight= $("#bgxdiv").css("height");
            	
            	  $("body").append("<div id='chfbg2'><div id='chfbgx2'> <h4>修改主题</h4><input type='text' class='form-control inTitle' name='uThemeTitle' placeholder='请输入修改后的主题标题' > </div> </div>");
            	 
            	var xTonHeight=TonHeight.replace(/[^\d.]/g,"");
            	var xTonHeightF=parseFloat(xTonHeight);
            	xTonHeightF+=40.0 ;     	 
            	 $("#bgxdiv").css({
            		height:xTonHeightF+"px"		 
            	 }); 
            	 
            	 
            	//实例化Ueditor3
		     	    var ue = UE.getEditor('editor3',{  
		     	    	 toolbars: [
		     	    	        ['fullscreen', 'source', 'undo', 'redo', 'bold','italic','fontfamily', 'fontsize','forecolor','justifyleft', 
		     	    	        'justifycenter', 'justifyright', 'justifyjustify','|', 'link', 'unlink', 'anchor', '|',
		     	    	        'imagenone','simpleupload', 'insertimage', 'emotion',"|","help"]
		     	    	    ],
		     	    	    autoHeightEnabled: true,
		     	    	    autoFloatEnabled: true,
		     	    	    scaleEnabled:true,//设置不自动调整高度
		     	    	    scaleEnabled:false, //是否可以拉伸长高
		     	    	   autoHeightEnabled: false //自动高度
		     	    });
            	 
            	 
            	 if(Tflag==true){
            	 //浏览量加一 
            	$.ajax({
         				url:"HomePageServlet",
         				data:{state:"ThemeViewCount",themeId:valueA},
         				type:"post",
         				dataType:"json",
         				success:function(data){ 					
         					
         				} 				
         			}); 
            	 
            	 };
            	 
            	 //主题帖详情         	 
            	  	$.ajax({
         				url:"HomePageServlet",
         				data:{state:"ThemeInfo",themeId:valueA},
         				type:"post",
         				dataType:"json",
         				cache:false,
         				success:function(data){ 	
     				        totalSize =data.replyList.length+1; //总行数
     				        if(totalSize==0)totalSize=1;
     				        
     				       var SignText = "精华";
        					var TopText = "置顶";					
        					var SignC="sign";   					
        					var TopC="top";
       					
        					if(data.themeSign==1){
        						SignText = "取消精华";
        						SignC ="qsign";
        						
        					}			
        					if(data.themeIsTop==1){
        						TopText = "取消置顶";		
        						TopC="qtop";
        					}
        					
        					var upTime = " IP:0:0:0:0:0:0:0:1.*.*";
        					
        					if(data.themeUpTime!=null&&data.themeUpTime!=""){
        						
        						upTime="  内容于"+data.themeUpTime+"被编辑 ";
        					}
        					ThemeTitle=data.themeTitle;
     				         $("#bgxdiv").append(" <span class='spanThf'><button type='button' value='"+data.themeId+"' text='del' class='tbtncf'>删除</button> <button type='button' value='"+data.themeId+"' text='"+TopC+"' class='tbtncf'>"+TopText+"</button>  <button type='button' value='"+data.themeId+"' text='"+SignC+"' class='tbtncf'>"+SignText+"</button></span> ");		        
         					 $("#bgxdiv").append("<div id='Themeheadbg'>[版块：<b>"+data.className+"</b>] [类别：<b>"+data.themeClassName+"</b>]<b> "+data.themeTitle+"</b> by：<b>"+data.userName+"</b></div><table id='ThemeTable_r'></table><br> <br><br><div id='hfoot'> <button type='button' id='FTheme2'>发帖</button> </div>");
         							 
         					 $("#ThemeTable_r").append("<tr class='hidetr notOnetr'><td><table class='notTable'>	<tr><td class='le cbc'>"+data.userName+"</td><td class='thead'>1# 发表于:"+data.themeTime+""+upTime+" <span class='Thfbtnxcspan'> <button class='Thfbtnxc' type='button' value='"+data.themeId+"' text='Theidt'>编辑</button></span>   <hr></td></tr>"
                     				+"<tr><td class='le'><img src='"+data.userPicture+"' width='100px' height='100px'/></td><td rowspan='6' class='nrong'><span class='hspanbody'>"+data.themeBody+"</span></td></tr>"
                     				+"<tr><td class='le'>UID："+data.userId+"</td></tr>"
                     				+"<tr><td class='le'>性别："+data.userSex+"</td></tr>"
                     				+"<tr><td class='le'>经验值："+data.userExp+"</td></tr>"
                     				+"<tr><td class='le'>金币："+data.userMoney+"</td></tr>"
                     				+"<tr><td class='le cbcx'>注册时间："+data.userRegTime.substr(0,10)+"</td></tr> <tr><td colspan='2'><div  style='height: 6px; width: 100%;background-color: #ECF7FB;'> &nbsp;&nbsp;</div></td></tr>  </td></tr></table>");
         				
         					 //回复编辑按钮 已移除
         			/* 		<button class='Thfbtnxc' type='button' value='"+data.replyId+"' text='Thredit'>编辑</button>  */
         					                
         				     
         			
         			
         			          $(".tbtncf").addClass("hideClass1");	 
         			
         			            //当前登录权限标识
         	    				var classFlaglogin= false;  
         			
         	    				 if(flag1.userId==data.userId){
         	    					classFlaglogin=true;
         	    					$(".tbtncf:contains('删除')").removeClass("hideClass1");
  			     			    	 
  			     			     };
         			
  			     			  if(classFlaglogin==false){
    			     		 	   $(".Thfbtnxc:contains('编辑')").addClass("hideClass1");	 
    			     		     };
         			
         			
         					 $.each(data.replyList,function(i,data){
         						 $("#ThemeTable_r").append("<tr class='hidetr'><td><table class='notTable'> <tr><td class='le cbc'>"+data.userName+"</td><td class='thead'>"+(i+2)+"# 发表于:"+data.replyTime+" IP:0:0:0:0:0:0:0:1.*.* <span class='Thfbtnxcspan2'> <button class='Thfbtnxc' type='button' value='"+data.replyId+"' text='Thrdel'>删除</button></span>  <hr> </td></tr>"
                          				+"<tr><td class='le'><img src='"+data.userPicture+"' width='100px' height='100px'/></td><td rowspan='6' class='nrong'><span class='hspanbody'>"+data.replyBody+"</span></td></tr>"
                          				+"<tr><td class='le'>UID："+data.userId+"</td></tr>"
                          				+"<tr><td class='le'>性别："+data.userSex+"</td></tr>"
                          				+"<tr><td class='le'>经验值："+data.userExp+"</td></tr>"
                          				+"<tr><td class='le'>金币："+data.userMoney+"</td></tr>"
                          				+"<tr><td class='le cbcx'>注册时间："+data.userRegTime.substr(0,10)+"</td></tr> <tr><td colspan='2'><div  style='height: 6px; width: 100%;background-color: #ECF7FB;'> &nbsp;&nbsp;</div></td></tr>  </td></tr></table>");
         						 
         						 
         					
         						 
         						
         						 
         						 if(Tflag==true){
         							
         						   if(totalSize>3){
   				                    var	TonHeight2= $("#bgxdiv").css("height");
				                           var bgdHeight = $("#bgdiv").css("height");
				                          TonHeight2=TonHeight2.replace(/[^\d.]/g,"");   
				                         	bgdHeight=bgdHeight.replace(/[^\d.]/g,"");  
				                         	
				                         	
				                        var	xTonHeightF2=parseFloat(TonHeight2);
				                       	var	xTbgdHeightF2=parseFloat(bgdHeight);
				                           xTonHeightF2+=200 ;     
				                         	xTbgdHeightF2+=210;
				                         	
				                        	 $("#bgdiv").css({
				                         		height:xTbgdHeightF2+"px"		 
				                         	 }); 
				                         	 $("#bgxdiv").css({
				                         		height:xTonHeightF2+"px"		 
				                         	 }); 
   				                	 
   				                 };
         							
         						};
         						
         						
         					
         						 
         					
         						 
         					 });
         					 
         					 
         					 
         					//当前版主或管理员权限标识
      	    				var classFlag= false;  
      	    				  
      	    					$.ajax({
      			     				url:"HomePageServlet",
      			     				data:{state:"SelectModeratorUserId",ClassId:classId},
      			     				type:"post",
      			     				 cache:false,
      			     				dataType:"json",
      			     				success:function(data){ 		
      			     		        $.each(data,function(i,n){    

      			     			     if(flag1.userId==n.userId){
      			     			    	classFlag=true;
      			     			    	$(".tbtncf").removeClass("hideClass1");
      			     			    	
      			     			     };
      			     			
      			     		        });
      			     		        
      			     		       if(flag1.authId==1){			  
      			     		    		classFlag=true;
      			     		    		$(".tbtncf").removeClass("hideClass1");
      			    				  };
      			     		       
      			     		     if(classFlag==false){
      			     		 	   $(".Thfbtnxc:contains('删除')").addClass("hideClass1");	 
      			     		     };
      						 
      						 
      						 
      			     				}
      						 
      	    					});
         					 
      	    			  		//实例化Ueditor4
         			     	    var ue = UE.getEditor('editor4',{  
         			     	    	 toolbars: [
         			     	    	        ['fullscreen', 'source', 'undo', 'redo', 'bold','italic','fontfamily', 'fontsize','forecolor','justifyleft', 
         			     	    	        'justifycenter', 'justifyright', 'justifyjustify','|', 'link', 'unlink', 'anchor', '|',
         			     	    	        'imagenone','simpleupload', 'insertimage', 'emotion',"|","help"]
         			     	    	    ],
         			     	    	    autoHeightEnabled: true,
         			     	    	    autoFloatEnabled: true,
         			     	    	    scaleEnabled:true,//设置不自动调整高度
         			     	    	    scaleEnabled:false, //是否可以拉伸长高
         			     	    	   autoHeightEnabled: false //自动高度
         			     	    });
         					 
         					 
      	    			  		
         			     	//实例化Ueditor2
             		     	    var ue = UE.getEditor('editor2',{  
             		     	    	 toolbars: [
             		     	    	        ['fullscreen', 'source', 'undo', 'redo', 'bold','italic','fontfamily', 'fontsize','forecolor','justifyleft', 
             		     	    	        'justifycenter', 'justifyright', 'justifyjustify','|', 'link', 'unlink', 'anchor', '|',
             		     	    	        'imagenone','simpleupload', 'insertimage', 'emotion',"|","help"]
             		     	    	    ],
             		     	    	    autoHeightEnabled: true,
             		     	    	    autoFloatEnabled: true,
             		     	    	    scaleEnabled:true,//设置不自动调整高度
             		     	    	    scaleEnabled:false, //是否可以拉伸长高
             		     	    	   autoHeightEnabled: false //自动高度
             		     	    });
             		     		 
             		     		 $("#ueditor2").appendTo("#hfoot");

             		     		 $("#ueditor2").show(20);
      	    			  		
      	    			  		
      	    			  		
      	    			  		
      	    			  		
      	    			  		
         					 //发帖2  //发布主题2
         					$("#FTheme2").on("click",function(){
         						if(flag1=="NOUSER"){
         		     				alert("您现在是游客不能发布主题,请登录！");
         		     				return;
         		     			};
         						
         						
         						$("#ueditor2").hide(10);
    				     	    $("#editor2").hide(10);
         			
         			     		 
         			    
     							
     						$("#bgxdiv").append("<div id='chfbg'><div id='chfbgx'><h5>发布主题帖</h5><input type='text' class='form-control inTitle' name='themeTitle' placeholder='请输入主题标题'> </div></div>");
     							
     						 $("#ueditor4").appendTo("#chfbgx");
     						
     						
     						
     		     			
     		     			
     		     			$("#classSelect").children().not(":eq(0)").remove();
     		     			
     		     			//查询主题分类Ajax
     		     			$.ajax({
     		     				url:"HomePageServlet",
     		     				data:{state:"ThemeClass"},
     		     				type:"post",
     		     				dataType:"json",
     		     				cache:false,
     		     				success:function(data){ 					
     		     					$.each(data,function(i,n){
     			                       $("#classSelect").append("<option value='"+n.themeClassId+"'>"+n.themeClassName+"</option>");
     		     					});		
     		     				} 				
     		     			});
     		     			
     		     			$("#ueditor4").show(80);
     		     			$("#chfbg").show(220);
     		     			$("#chfbgx").show(220);
         					
         					
         					
         					
         					
         					});
         					 
         					 
         					 //取消发布
         		     		$("#cancelfb2").on("click",function(){	
         		     			$("#ueditor2").show(0);
    				     	    $("#editor2").show(0);
         		     			$("#ueditor4").hide(80);
         		     			$("#chfbgx").hide(120);
         		     			$("#chfbg").hide(120);
         		     		
         		     		});
         					 
         					 
         					 
         		     	//确认发布
         		     	   
         		     		$("#okfb2").on("click",function(){		
         		     			
         		     			//主题内容
         		     		   var FThemeBody = UE.getEditor('editor4').getContent();   
         		     		   //主题分类ID
         		     			var FthemeClassId = $("select[name='themeClassId2']").val();
         		     			//主题标题
         		     			var FthemeTitle = $("input[name='themeTitle']").val();
         		     			//主题所属板块ID
         		     			var FclassId = classId;
         		     			//用户ID
         		     			var FuserId = flag1.userId;
         		     			
         		     			
         		     			FthemeTitle =	$.trim(FthemeTitle);
         		     			FThemeBody = $.trim(FThemeBody);
         		     			
         		     		
         		     			
         		     			if(FthemeTitle==""){ 				
         		     				alert("请输入主题标题");
         		     				return;
         		     			}
         		     			
         		     			if(FThemeBody==""){ 				
         		     				alert("请输入主题内容");
         		     				return;
         		     			}
         		     			
         		     			if(FthemeClassId=="请选择主题分类"){ 				
         		     				alert("请选择主题分类");
         		     				return;
         		     			}

         		     			
         		     			$.ajax({
         		     				url:"HomePageServlet",
         		     				data:{state:"bClassFTheme",ThemeTitle:FthemeTitle,ThemeBody:FThemeBody,ClassId:FclassId,ThemeClassId:FthemeClassId,UserId:FuserId},
         		     				type:"post",
         		     				dataType:"json",
         		     				cache:false,
         		     				success:function(data){ 					
         		     					
         		     			 UE.getEditor('editor4').setContent('');
         		     			$("#ueditor4").appendTo("body");
         		     			$("#ueditor2").show(0);
    				     	    $("#editor2").show(0);
         		     			$("#ueditor4").hide(80);
         		     			$("#chfbgx").hide(120);
         		     			$("#chfbg").hide(120);

         		     					
         		     				} 				
         		     			});
         		     			
         		     			
         		     			
         		     		
         		     		
         		     		});
         					 
            				
         		     		 
         		     		 
         		     		 //=============帖子操作：删除,置顶等=============
         		     			 
         		     			var ThemeIdTf= valueA;
         		     		    
         		     		    var fState = "";
         		     			 
         		     			 $(".tbtncf[text='del']").on("click",function(){
         		     				fState="del"
         		    /*  				 alert("删除"); */
         		     				ajaxThfCbtn();
         		     				
         
         		     				 
         		     			 });
	                            $(".tbtncf[text='sign']").on("click",function(){
	                            	fState="sign";
	                            	ajaxThfCbtn();
         		     			/* 	 alert("精华"); */
         		     				 
         		     			 });
	                            
	                            $(".tbtncf[text='qsign']").on("click",function(){
	                            	 fState="qsign";
	                            	 ajaxThfCbtn();
        		     			/* 	 alert("取消精华"); */
        		     				 
        		     			 });
	                            
	                            $(".tbtncf[text='top']").on("click",function(){
	                            	fState="top";
	                            	ajaxThfCbtn();
        		     				/*  alert("置顶"); */
        		     				 
        		     			 });
	                            
	                            $(".tbtncf[text='qtop']").on("click",function(){
	                            	fState="qtop";
	                            	ajaxThfCbtn();
       		     			       /* 	   alert("取消置顶"); */
       		     				   
       		     				 
       		     			    });
	                            
	                            
	                        	
	                            
	                          
    				     	
	                            
	                            function ajaxThfCbtn(){
	        						$.ajax({
	        		     				url:"HomePageServlet",
	        		     				data:{state:"btnThemefChange",state2:fState,ThemeId:ThemeIdTf},
	        		     				type:"post",
	        		     				 cache:false,
	        		     				dataType:"json",
	        		     				success:function(data){ 		
	        		     					//是删除则刷新首页,如果是删除以外的操作重新加载
	        		     					
	        		     					if(fState=="del"){
	        		     						
	        		     						window.location.reload();
				
	        		     					}else{
	        		     						
         										Tflag=false;
         										
         										 $("#ueditor2").appendTo("body");
         										$("#ueditor4").appendTo("body");
         										 $("#ueditor2").hide(20);
         										
         										onThemeRload(); 
         										
	        		     					}
	        		     					
	        		     					
	        		     					
	        		     					 
	        		     				
	        		     				} 				
	        		     			});
	        					  
	        					  
	        					  
	        				  };
	        				  
	        				  
	        				//==============详情页楼层编辑/删除===============
	        					
	        					var xThemeIdc="";
	        				    var xReplyIdc="";
	        				    var btntextx="";
	        					
    							
   						
	        				    
	        					$(document).on("click",".Thfbtnxc",function(){		                              
	        						xThemeIdc = $(this).attr("value");		
	        						btntextx= $(this).attr("text");	      
	        						
	        						//主题编辑
	        						if(btntextx=="Theidt"){
	        				     		 
	        				/* 	      var TheBodyValue=	$(this).parent().parent().parent().parent().children().children().eq(3).children().html();	 */ 
	        				
	        				        
	        				     	  var uThemeTitle = $("input[name='uThemeTitle']").val(ThemeTitle);		          				     	  
	        				     	    $("#ueditor2").hide(10);
	        				     	    $("#editor2").hide(10);
	        							 $("#ueditor3").appendTo("#chfbgx2")
	        							 $("#chfbg2").show(20);
	        							 $("#chfbgx2").show(20); 
	        							$("#ueditor3").show(20);		
	        			/* 				UE.getEditor('editor3').setContent('欢迎使用ueditor'); */
	        						}else if (btntextx=="Thredit") {
	        	
	        							   
									}else if (btntextx=="Thrdel") {
	        							   xThcbtnx();
									}
	        							 
    		     			    });
	        					
	        					
	        					
	        					
	        					$("#cancelUpdateBtn").on("click",function(){
    								
   								 $("#chfbg2").hide(20);
       							 $("#chfbgx2").hide(20); 
       							$("#ueditor3").hide(20);
       							 $("#ueditor2").show(0);
	        				     	   $("#editor2").show(0);
   								
   							});
	        					
	        					
	        		
	        					/* 保存修改 */
	        					$("#ThxUpdate").on("click",function(){
	        						var uThemeId = valueA;
	        						 var uThemeTitle = $("input[name='uThemeTitle']").val();
	        						 var uThemeBody =  UE.getEditor('editor3').getContent();
	        						 uThemeTitle =	$.trim(uThemeTitle);
	        						 uThemeBody=	$.trim(uThemeBody);
	        						/*  alert(uThemeId); */
	        						 if(uThemeTitle==""){	 
	        							 alert("请输入修改后的主题标题");
	        							 return;
	        						 };
	        						 
	        						 if(uThemeBody==""){	 
	        							 alert("请输入修改后的主题内容");
	        							 return;
	        						 }
	        						 
	        						 
	        						 
	        							$.ajax({
		        		     				url:"HomePageServlet",
		        		     				data:{state:"btnThemeUpdateChange",state2:"ThemeUedit",ThemeId:uThemeId,ThemeTitle:uThemeTitle,ThemeBody:uThemeBody},
		        		     				type:"post",
		        		     				cache:true,
		        		     				dataType:"json",
		        		     				success:function(data){ 		   	        		     											
	     										Tflag=false;  										
	     										 			
	     		   								 $("#chfbg2").hide(20);
	     		       							 $("#chfbgx2").hide(20); 
	     		       							$("#ueditor3").hide(20);
	     		       						$("#editor2").show(20);
	     		       					$("#ueditor4").appendTo("body");
	     		       						$("#ueditor2").appendTo("#bgdiv");
	     			        				    onThemeRload(); 
	        		     				
		        		     				} 				
		        		     			});
	        						 
	        						 
	        					
	   								
	   							});

	        					
	        					//回复删除
	        					function xThcbtnx(){
	        						
	        						$.ajax({
	        		     				url:"HomePageServlet",
	        		     				data:{state:"btnTfxChange",state2:"del",ReplyId:xThemeIdc},
	        		     				type:"post",
	        		     				cache:true,
	        		     				dataType:"json",
	        		     				success:function(data){ 		   	        		     											
     										Tflag=false;  										
     										$("#ueditor2").appendTo("body");
     										$("#ueditor4").appendTo("body");
     										 $("#ueditor2").hide(20); 				
     										  onThemeRload();
        		     				
	        		     				} 				
	        		     			});
	        						
	        						
	        					};
	        					
	        					
	        			
         		     		
         		     		 
         		     		 
         		     		 
         		     		 
         		     		 
         					//===============详情页发表回复================
         		     		
         		     		$("#FReply").on("click",function(){
         		     			if(flag1=="NOUSER"){
         		     				alert("您现在是游客状态不能回复.请登录！");
         		     				return;
         		     			};
         		     			var rUserIdValue = flag1.userId;
         		     			var ReplyValue = UE.getEditor('editor2').getContent();     			
         		     			 UE.getEditor('editor2').setContent('');
         		     			if(ReplyValue!=""){     
         		     				$.ajax({
        				                 url:"HomePageServlet",
        				                 data:{state:"onThemeInfoReply",themeId:valueA,rUserIdValue:rUserIdValue,ReplyValue:ReplyValue},
        				                 type:"post",
        				                 dataType:"json",
        				                 cache:false,
        				            	 success:function(data){ 	 
                                               /*    alert("ReplyId："+data.userName+data.userPicture); */
                                            /*    <button class='Thfbtnxc' type='button' value='"+data.replyId+"' text='Thredit'>编辑</button> */
                                         	  if(totalSize==0)totalSize=1;
                                         	 totalSize+=1; 
                                         	 
                                         	 
                                         	 
                                         	 
                                         	 
                                         	 
                                             	 $("#ThemeTable_r").append("<tr class='hidetr'><td><table class='notTable'> <tr><td class='le cbc'>"+data.userName+"</td><td class='thead'>"+totalSize+"# 发表于:"+data.replyTime+" IP:0:0:0:0:0:0:0:1.*.* <span class='Thfbtnxcspan2'>  <button class='Thfbtnxc' type='button' value='"+data.replyId+"' text='Thrdel'>删除</button></span>  <hr></td></tr>"
                                           				+"<tr><td class='le'><img src='"+data.userPicture+"' width='100px' height='100px'/></td><td rowspan='6' class='nrong'><span class='hspanbody'>"+data.replyBody+"</span></td></tr>"
                                           				+"<tr><td class='le'>UID："+data.userId+"</td></tr>"
                                           				+"<tr><td class='le'>性别："+data.userSex+"</td></tr>"
                                           				+"<tr><td class='le'>经验值："+data.userExp+"</td></tr>"
                                           				+"<tr><td class='le'>金币："+data.userMoney+"</td></tr>"
                                           				+"<tr><td class='le cbcx'>注册时间："+data.userRegTime.substr(0,10)+"</td></tr> <tr><td colspan='2'><div  style='height: 6px; width: 100%;background-color: #ECF7FB;'> &nbsp;&nbsp;</div></td></tr>  </td></tr></table>");
                                   
                                     
                                             	 
                                         		//当前版主或管理员权限标识
                                 				var classFlag= false;  
                                 				  
                                 					$.ajax({
                             		     				url:"HomePageServlet",
                             		     				data:{state:"SelectModeratorUserId",ClassId:classId},
                             		     				type:"post",
                             		     				 cache:false,
                             		     				dataType:"json",
                             		     				success:function(data){ 		
                             		     		        $.each(data,function(i,n){    

                             		     			     if(flag1.userId==n.userId){
                             		     			    	classFlag=true;
                             		     			    	 
                             		     			     }
                             		     			
                             		     		        });
                             		     		        
                             		     		       if(flag1.authId==1){			  
                             		     		    		classFlag=true;		    					  
                             		    				  }
                             		     		       
                             		     		     if(classFlag==false){
                             		     		 	   $(".Thfbtnxc:contains('删除')").addClass("hideClass1");	 
                             		     		     }  
                             		     		       		        
                             		     				
                             		     				} 				
                             		     			});
                                             	 
                                             	 
                                             	 
                                             	 
                                             	 
                                             	 if(Tflag==true){
                                    	 
                                    	    if(totalSize>3){
             				                    var	TonHeight2= $("#bgxdiv").css("height");
        				                           var bgdHeight = $("#bgdiv").css("height");
        				                          TonHeight2=TonHeight2.replace(/[^\d.]/g,"");   
        				                         	bgdHeight=bgdHeight.replace(/[^\d.]/g,"");  
        				                         	
        				                         	
        				                        var	xTonHeightF2=parseFloat(TonHeight2);
        				                       	var	xTbgdHeightF2=parseFloat(bgdHeight);
        				                           xTonHeightF2+=200 ;     
        				                         	xTbgdHeightF2+=210;
        				                         	
        				                        	 $("#bgdiv").css({
        				                         		height:xTbgdHeightF2+"px"		 
        				                         	 }); 
        				                         	 $("#bgxdiv").css({
        				                         		height:xTonHeightF2+"px"		 
        				                         	 }); 
             				                	 
             				                 }; 
                                    	 
                                    	 
                                     };
                                             
     				                       
     				                              

        				            	 }
        	       		     			
        		     	           	});       		     				
         		     		
         		     				
         		     			}else{
         		     				alert("请输入内容")
         		     				
         		     			}
         		     			
         		     				
         		     		});
                                       
         					
         		     		/* success结束 */
         				} 				
         			}); 
            	 
            	 
            	 
       
            	 
            	 $("html,body").animate({scrollTop:0}, 50);
            	 

            	 
            	 /*onThemeRload()结束  */
             	};
            	 
             });
        	 
        	 
        	 
         });
             

    </script>
    
      <div class="clear"></div>  
  <!--/ bgxdiv -->
  </div>
  
             <!--  板块页发布主题-->
       		<div id="ueditor">
           		 <script id="editor" type="text/plain" style="width:100%;height:100%;"></script>
            	 <input type="hidden" name="classId" >
            	 <input type="hidden" name="userId">
      			 <select id="classSelect" class="form-control" name="themeClassId"><option>请选择主题分类</option></select>
             	 <button id="cancelfb" class="btn btnw btn-warning" type="button">取消</button><button id="okfb" class="btn btnw" type="button">确认发布</button> 
            </div>
            
            
             <!--  主题帖详情页发表回复-->
            <div id="ueditor2">
           		 <script id="editor2" type="text/plain" style="width:100%;height:100%;"></script>
          		 	<button type="button" id="FReply">发表回复</button>
            </div>
            
            
            <!--  主题帖详情页修改主题内容-->
            <div id="ueditor3">
           		 <script id="editor3" type="text/plain" style="width:100%;height:100%;"></script>
          		<span id="eiitxupspan"> <button id="cancelUpdateBtn" type="button">取消</button><button type="button" id="ThxUpdate">保存修改</button></span>
            </div>
            
            
               <!--  主题帖发布主题-->
       		<div id="ueditor4">
           		 <script id="editor4" type="text/plain" style="width:100%;height:100%;"></script>
            	 <input type="hidden" name="classId2" >
            	 <input type="hidden" name="userId2">
      			 <select id="classSelect" class="form-control" name="themeClassId2"><option>请选择主题分类</option></select>
             	 <button id="cancelfb2" class="btn btnw btn-warning" type="button">取消</button><button id="okfb2" class="btn btnw" type="button">确认发布</button> 
            </div>

            
            
            
            
        
            
<!--/ bgdiv -->
</div>

	
	<script type="text/javascript">
	
	$(function(){
		
		$("#personalCenter").on("click",function(){
			$('.dropdown-toggle').dropdown();
			
		});
		
		$('.navbar-nav li').click(function(e){
		       e.preventDefault();
		       $(this).addClass('active').siblings().removeClass('active');
		   }); 
		
		$("#onAdmin").on("click",function(){
			
		
		$("#onAdminModal").modal("show");
		
		
		$("#onAdminBotton").on("click",function(){
			$("#onAdminModal").modal("hide");
			 $("#bgxdiv").children().remove();
			 $("#bgxdiv").load("admin/admin.jsp");
			 $("html,body").animate({scrollTop:0}, 50);
			
		});
		
		
		

			
		});
		
		$("#onIndex").on("click",function(){				
			window.location.href="index.jsp";
			 $("html,body").animate({scrollTop:0}, 50);
		});
		
		
		
	
			
			
	
		
	})
	
	
	</script>
	
		
                <!-- 	----------------登陆，注册，修改-------------------  -->
                
                
	                         <!-- 登陆modal  id为loginModal -->
<div class="modal fade" tabindex="-1" role="dialog" id="loginModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">登录</h4>
      </div>
      <div class="modal-body">
      <form class="form-horizontal" id="loginForm">
  <div class="form-group">
    <div class="col-sm-12">
      <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名">
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
          <a onclick="forgetPassword()" >忘记密码</a>  
          </label>
          </p>
     </div>
    </div>
  </div>
   <div class="form-group">
     <div class="col-sm-12" style="text-align: center;">
       <img  src="images/2_223_79969_503_501.jpg" id="loginHeadImg" width="100px" height="100px">
    </div>
  </div>
 <div class="form-group">
    <div class="col-sm-12" >
      <p style="text-align: center;">
      <button type="button" class="btn btn-success btn-lg" id="loginBotton" style="width: 300px ">登录</button>
      </p>
    </div>
  </div>
</form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


                          <!--  注册modal  id为enrollModal  -->
<div class="modal fade" tabindex="-1" role="dialog" id="enrollModal">
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
      <input type="text" class="form-control" id="enrollUserName" name="userName">
    </div>
     <div class="col-sm-4">
      <span  id="span1" >请输入至少2位字符</span></p>
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
     <span id="span5" >请输入邮箱</span>
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
    <select  name="UserSpe" class="form-control enrollUserSpe">
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
    <select  name="UserPassQ" class="form-control enrollUserPassQ">
    <option value="" selected="selected">请选择问题</option>
    </select>
    </div>
    <div class="col-sm-4">
    <select  name="UserPassA" class="form-control enrollUserPassA">
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
</form>
      </div>
      <div class="modal-footer" >
        <button type="button" id="close" class="btn btn-default" data-dismiss="modal" >关闭</button>
        <button type="button" id="enrollOk" class="btn btn-primary" disabled="disabled" >提交</button>
      </div>
                     <!--      验证               -->
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

                   <!-- 找回密码modal  id为passwordModal  --> 
<div class="modal fade" tabindex="-1" role="dialog" id="passwordModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">找回密码</h4>
      </div>
      <div class="modal-body">
       
       <form class="form-horizontal" id="forgetPassword">
       <div class="form-group">
    <div class="col-sm-12">
      <input type="hidden" class="form-control"  name="state"  value="forgetPassword">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">用户名：</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="forgetUserName" name="forgetUserName" placeholder="userName">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">密保问题：</label>
    <div class="col-sm-9">
     <select  name="UserPassQ" class="form-control enrollUserPassQ" id="UserPassQ" >
    <option value="" selected="selected" id="q">请选择问题</option>
    </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">密保答案：</label>
    <div class="col-sm-9">
     <select  name="UserPassA" class="form-control enrollUserPassA">
    </select>
    </div>
  </div>
  <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">请通过验证：</label>
    <div class="col-sm-9">
        <div id="mpanel2" >
        </div>
    </div>
  </div> 
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" disabled="disabled" id="passwordOk">提交</button>
      </div>
        <script type="text/javascript">
        $('#mpanel2').slideVerify({//验证
    		type : 1,		//类型
    		vOffset : 5,	//误差量，根据需求自行调整
	        barSize : {
	        	width : '550%',
	        	height : '50px',
	        },
	        ready : function() {
	    	},
	        success : function() {
	       $("#passwordOk").removeAttr("disabled")
	        },
	        error : function() {
         //	        	alert('验证失败！');
	        }
	    });
        </script>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

                        <!-- 找回密码验证成功后，修改密码模态框 --> 
<div class="modal fade" tabindex="-1" role="dialog" id="passwordUpdateModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="text-align: center;">修改密码</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="forgetUpdatePassword">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">用户名:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="forgetUpdateUserName" name="userName" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword1" class="col-sm-3 control-label">密码：</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="forgetUpdatePwd1" name="Pwd1" >
    </div>
    <div class="col-sm-4">
     <span id="forgetUpdateSpan1" >请输入6至16位字符</span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword2" class="col-sm-3 control-label">确认密码：</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="forgetUpdatePwd2" name="Pwd2" >
    </div>
    <div class="col-sm-4">
     <span id="forgetUpdateSpan2" >确认密码</span>
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-12">
      <input type="hidden" class="form-control" name="state" value="updatePwd" >
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="forgetUpdateButton">提交</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


                    <!-- 修改密码模态框 id为updateModal -->
<div class="modal fade" tabindex="-1" role="dialog" id="updateModal"> 
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">修改</h4>
      </div>
      <div class="modal-body">      
   <form class="form-horizontal" id="updateForm">
  <div class="form-group">
    <label for="inputName" class="col-sm-3 control-label">用户名：</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="enrollUserName" name="userName" readonly="readonly">
    </div>
     <div class="col-sm-4">
      <span  id="span1" >请输入至少2位字符</span></p>
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
    <select  name="UserSpe" class="form-control enrollUserSpe">
    </select>
    </div>
  </div>
  <div class="form-group">
   <label for="inputBirthday" class="col-sm-3 control-label">请选择头像：</label>
    <div class="col-sm-9">
        <input type="file" class="form-control" id="updateHeadImg" name="headImg" >
       <!--  不选头像返回"" -->
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-12" style="text-align: center;">
       <img alt="" src="" width="100px" height="100px">
    </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="updateOk">提交</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



  <script type="text/javascript">
  var user=null;//定义登陆时点登陆按钮后返回的user对象，若没有则返回null
  var flag=null;//注册时要判断用户名是否重复，
  var flag1=null; //前台修改时要判断是否登陆过
 
  $("#enrollUserName").on("blur",function(){//注册时验证用户名是否符合规范
	  var a=$("#enrollUserName").val();
	  if (a.length<2) {
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
  
  $("#enrollPwd1").on("blur",function(){//注册时验证密码是否符合规范
	  var a=$("#enrollPwd1").val();
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
  
  $("#enrollPwd2").on("blur",function(){//再次输入密码，确保两次输入的密码一致
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
	var reg2 = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	if (reg2.test(email)) {
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
			// url:"/BBS/pioseniumServlet",
			url:"${pageContext.request.contextPath}/pioseniumServlet",
			 type:"get",
			 data:"userName="+$("#userName").val()+"&state=headImg",
			 dataType:"json",
			 success:function(data){
				// alert(data.userPicture);
				$("#loginHeadImg").attr("src",data.userPicture);
			 }
		 });
	});
	
	  $("#forgetUpdatePwd1").on("blur",function(){//找回密码验证成功修改密码时验证密码是否符合规范
		  var a=$("#forgetUpdatePwd1").val();
		  if (a.length<6||a.length>16) {
			 // alert(123);
			  $("#forgetUpdateSpan1").empty();
			  $("#forgetUpdateSpan1").append("密码输入有误！");
			  $("#forgetUpdateSpan1").attr("style","color:red");
			}else{
				  $("#forgetUpdateSpan1").empty();
				 $("#forgetUpdateSpan1").append("输入正确");
				  $("#forgetUpdateSpan1").attr("style","color:black");
			};
	  }); 
	  
	  $("#forgetUpdatePwd2").on("blur",function(){//找回密码验证成功修改密码时再次输入密码，确保两次输入的密码一致
		  var a=$("#forgetUpdatePwd1").val();
		  var b=$("#forgetUpdatePwd2").val();
		  if (a==b&&b.length>=6&&b.length<=16) {
			    $("#forgetUpdateSpan2").empty();
				 $("#forgetUpdateSpan2").append("输入正确");
				  $("#forgetUpdateSpan2").attr("style","color:black");
			 // alert(123);
			}else{
				 $("#forgetUpdateSpan2").empty();
				  $("#forgetUpdateSpan2").append("密码输入有误！");
				   $("#forgetUpdateSpan2").attr("style","color:red"); 
			};
	  }); 
	  
	
	

 function enroll(){//点登陆模态框里的注册时关闭登陆模态框，显示注册模态框
	  $("#loginModal").modal("hide");
	 $("#enrollModal").modal("show");
 };
 
 
 function forgetPassword(){//点登陆模态框里的忘记密码时关闭登陆模态框，显示找回密码模态框
	  $("#loginModal").modal("hide");
	  $("#passwordModal").modal("show");
	  $("#passwordOk").off();
	  $("#passwordOk").on("click",function(){//找回密码提交按钮
	    	if($("#forgetUserName").val()==""){
	    		alert("请完善用户名信息");
	    		return;
	    	}
	    	if($("#UserPassQ").val()==""){
	    		alert("请选择密保问题！");
	    		return;
	    	}
	    	var m =null;
	    	  $.ajax({//查用户名是否存在
	 			 url:"${pageContext.request.contextPath}/pioseniumServlet",
	 			 type:"get",
	 			 async:false,
	 			 data:$("#forgetPassword").serialize(),
	 			 dataType:"json",
	 			 success:function(data){
	 				 /* alert(123); */
	 	          if(data==1){
	 	        	  m=1;
	 	          }else {
					m=data;
				} 
	 			 }
	    	  });
	    	   /* alert("m="+m); */
	    	  if(m==1){
	    		  alert("用户名或密保错误！");
	    		  return;
	    	  }
	    	  $("#passwordModal").modal("hide");
	    	  $("#forgetUpdateUserName").attr("value",m.userName);
	    	  $("#passwordUpdateModal").modal("show");
	    	  $("#forgetUpdateButton").off();
	    	  $("#forgetUpdateButton").on("click",function(){
	    		  if($("#forgetUpdatePwd1").val().length<6||$("#forgetUpdatePwd1").val().length>16){
			    		 alert("请完善密码信息");
				    		return;
			    	 } 
			    	 
			    	 if(($("#forgetUpdatePwd2").val().length<6||$("#forgetUpdatePwd2").val().length>16)||$("#forgetUpdatePwd1").val()!=$("#forgetUpdatePwd2").val()){
			    		 alert("请完善密码信息,且保持两次输入密码一致");
				    		return;
			    	 }  
			    	  $("#passwordUpdateModal").modal("hide");
			    	 $.ajax({
			    		 url:"${pageContext.request.contextPath}/pioseniumServlet",
			    		 type:"get",
			    		 data:$("#forgetUpdatePassword").serialize(),
			    		 dataType:"json",
			    		 success:function(data){
			    			/*  alert(123); */
			    			 window.location.reload(true);//刷新页面
			    		 } 
			    	 });
			    	 
			    	 
	    	  });
	    });
};
 
 
 
 $.ajax({//查擅长领域下拉框的内容
	 url:"${pageContext.request.contextPath}/pioseniumServlet",
	 type:"get",
	 data:"state=selectAllBclass",
	 dataType:"json",
	 success:function(data){
		  $.each(data,function(i,n){//data是数组要循环遍历
         $(".enrollUserSpe").append("<option value='"+n.className+"'>"+n.className+"</option>");
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
         $(".enrollUserPassQ").append("<option value='"+key+"'>"+key+"</option>");
	  }
	  $(".enrollUserPassQ").on("change",function(e){//当问题下拉框改变时
		  event=e||event;
		//  alert(event.target.value);//湖北省
		var cityArray =citys[event.target.value];//长沙,湘潭 object
		//console.log($("#UserPassA option"));
		$(".enrollUserPassA").empty();//清除答案下拉框中的内容
	   for(var i in cityArray){////向答案下拉框中加入option
		//alert(cityArray[i]);
        $(".enrollUserPassA").append("<option value='"+cityArray[i]+"'>"+cityArray[i]+"</option>");
	    }  
	  });
	  
	  
	  $("#login").on("click",function(e){//登陆时弹出模态框
		    event=e||event;
		   event.preventDefault();//清除表单中的提交功能 
		   $("#userName").attr("value","");
		   $("#userPwd").attr("value","");
		  $("#loginModal").modal("show");
		  $("#loginBotton").off();
		  $("#loginBotton").on("click",function(){
			 // alert($("#userId").val());
			 if($("#userName").val()==""||$("#userPwd").val()==""){
				 alert("用户名或密码为空！");
				 return;
			 }
			 $.ajax({
		    		 url:"${pageContext.request.contextPath}/pioseniumServlet",
					 data:$("#loginForm").serialize(),
					 async:false,
					 success:function(data){
/* 				 		 alert(data);  */
						 if(data==null){
							 user=1;
						 }else {
							 user=data;
							// alert("登陆了成功，跳转首页并判断权限！");
						}
					 }
		    	});
			 if(user==1){
				 alert("用户名或密码错误或账户被禁用！"); 
				 return;
			 };
			 
			 
			  $("#loginModal").modal("hide");
			  
			  window.location.reload();
		/* 	  if(user.authId==1){
				  $("#onAdmin").attr("style","display: block;");
				  $("#login").attr("style","display: none;");
				  $("#enroll").attr("style","display: none;");
				  $("#personalCenter").attr("style","display: block;");
				  
			  }else {
				  $("#login").attr("style","display: none;");
				  $("#enroll").attr("style","display: none;");
				  $("#personalCenter").attr("style","display: block;");
			}  
			   */
			  
			  
		  });
	  });
	   
	  $("#enroll").on("click",function(e){//注册时弹出模态框
		    event=e||event;
		    $("#enrollModal").modal("show");
	  });
		    $("#enrollOk").off();
		    $("#enrollOk").on("click",function(){//注册提交按钮
		    	  $.ajax({//查用户名是否被占用
		 			 url:"${pageContext.request.contextPath}/pioseniumServlet",
		 			 type:"get",
		 			 async:false,
		 			 data:"state=selectAllUserName&userName="+$("#enrollUserName").val(),
		 			 dataType:"json",
		 			 success:function(data){
		 				/*  alert(data); */
		 				 if(data==null){
		 					flag=false;
		 				 }else{
		 					flag=true;
		 				 }
		 			 }
		 		 });
		    	if(flag){
		    		alert("此用户名已被占用");
		    		return;
		    	}
		    	  
		    	if($("#enrollUserName").val().length<2){
		    		alert("请完善用户名信息");
		    		return;
		    	}
		    	
		    	 if($("#enrollPwd1").val().length<6||$("#enrollPwd1").val().length>16){
		    		 alert("请完善密码信息，且保持两次输入密码一致");
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
		    	 var reg2=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
		    	 if(!reg2.test(email)){
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
					/* console.log(fd); */
		    	  $.ajax({
		    		 url:"${pageContext.request.contextPath}/pioseniumServlet?state=enroll",
		    		 data:fd,
					 type:"post",
					 dataType:"json",
					 processData:false,
					 contentType:false,
					 success:function(data){
						/*   alert(data); */
						  window.location.reload(true);//刷新页面
					 }
		    	});	
		  
		    
		    
	  });
		    
		    $("#update").on("click",function(e){//修改时弹出模态框
			    event=e||event;
			    $.ajax({
		    		 url:"${pageContext.request.contextPath}/pioseniumServlet?state=selectUser",
					 type:"post",
					 async:false,
					 dataType:"json",
					 success:function(data){
						 flag1=data;
					 }
		    	});
			    if(flag1==null){
			    	alert("请先登录！");
			    	return;
			    }
		/* 	    alert(flag1.userPicture); */
		    $("#updateModal").modal("show");
		    $("#updateForm [name='userName']").attr("value",flag1.userName);
		    $("#updateForm [name='Pwd1']").attr("value",flag1.userPwd);
		    $("#updateForm [name='Pwd2']").attr("value",flag1.userPwd);
		    $("#updateForm [name='Phone']").attr("value",flag1.userPhone);
		    $("#updateForm [name='Email']").attr("value",flag1.userEmail);
		    $("#updateForm [name='Birthday']").attr("value",flag1.userBirth);
		    $("#updateForm [type='radio'][value='"+flag1.userSex+"']").attr("checked",true);
			$("#updateForm option:contains('" + flag1.userSpe + "')").attr("selected", true);
		    $("#updateForm img").attr("src",flag1.userPicture);
		    $("#updateOk").off();
		    $("#updateOk").on("click",function(){//修改提交按钮
		    	
		    	if($("#updateHeadImg").val()==""){
		    		alert("请选择头像");
		    		return;
		    	}
		    	  $("#updateModal").modal("hide");
		    		 var fd = new FormData($("#updateForm")[0]);//通过[0]将jQuery转换成js
						/* console.log(fd); */
			    	  $.ajax({
			    		 url:"${pageContext.request.contextPath}/pioseniumServlet?state=update",
			    		 data:fd,
						 type:"post",
						 dataType:"json",
						 processData:false,
						 contentType:false,
						 success:function(data){
							 /*  alert(data); */
							  window.location.reload(true);//刷新页面
						 }
			    	});	
		    
		  });
	  });
  });
  </script>
	 <!--页眉 动态包含  -->
	<jsp:include page="foot.jsp"></jsp:include>
</body>

    	
</html>