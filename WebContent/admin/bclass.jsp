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
		
		<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table-zh-CN.js" ></script>
		
		<style type="text/css">	
		    body *{font-family: Microsoft YaHei UI}
              #insertBtn{margin-top: 32px;}
		</style>
		
		
</head>
<body>
<!--   <img  src="images/my.jpg">  -->
<button type="button" class="btn btn-info" id="insertBtn">添加板块</button>
  <table id="tab01"></table>
  
  <div class="modal fade" tabindex="-1" role="dialog" id="modal1">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改</h4>
      </div>
      <div class="modal-body">
      
      <form class="form-horizontal" id="updateForm">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">板块编号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="id" readonly="readonly" name=classId>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板块名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3"  name="className">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板面公告</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword4"  name="classMsg">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板块log</label>
    <div class="col-sm-10">
      <input type="file" class="form-control"   name="classPicture">
      <img  width="100px" height="100px">
    </div>
  </div>
</form>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  
    
  <div class="modal fade" tabindex="-1" role="dialog" id="modal2">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加</h4>
      </div>
      <div class="modal-body">
      
      <form class="form-horizontal" id="insertForm" >
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板块名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3"  name="className">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板面公告</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword4"  name="classMsg">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">板块log</label>
    <div class="col-sm-10">
      <input type="file" class="form-control"  name="classPicture">
    </div>
  </div>
</form>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">添加</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" tabindex="-1" role="dialog" id="modal3">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改版主</h4>
      </div>
      <div class="modal-body">
       <form action="" id="form3">
       <select multiple class="form-control" id="selectOption" name="userId">
       </select>
       <input type="hidden" name="state" value="updateModerator"/>
       <input type="hidden" name="classId" />
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="closeButton">关闭</button>
        <button type="button" class="btn btn-primary" id="updateButton">修改</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

  <script type="text/javascript">
  $(function(){
	  
	 $.ajax({
		 url:"/BBS/backstageUsersServlet",
		 type:"get",
		 data:"state=selectAllUsers",
		 dataType:"json",
		 success:function(data){
			 console.log(data);
			  $.each(data,function(i,n){//data是数组要循环遍历
	 $("#selectOption").append("<option value='"+data[i].userId+"'>"+data[i].userName+"</option>");
			  })
		 }
	 });
	  
	  $("button:contains('添加板块')").on("click",function(){
		  $("#insertForm input[name=className]").val("");
	      $("#insertForm input[name=classMsg]").val("");
	      $("#insertForm input[name=classPicture]").val(""); 
		  $("#modal2").modal("show");
	      $("[class*='modal-footer'] button:eq(3)").off();
	      $("div[class*='modal-footer'] button:eq(3)").on("click",function(){
	    	  if($("#insertForm input[name='className']").val()==""){
	    		  alert("请输入板块名称！");
	    		  return;
	    	  }
	    	  if($("#insertForm input[name='classMsg']").val()==""){
	    		  alert("请输入板面公告！");
	    		  return;
	    	  }
	    	  if($("input[type='file']:eq(1)").val()==""){
	    		  alert("请选择log图片！");
	    		  return;
	    		}

	    		 $("#modal2").modal('hide');
	    		 var fd = new FormData($("#insertForm")[0]);//通过[0]将jQuery转换成js
					console.log(fd);
		    	  $.ajax({
		    		 url:"/BBS/backstageBclassInsertServlet",
		    		 data:fd,
					 type:"post",
					 dataType:"json",
					 processData:false,
					 contentType:false,
					 success:function(data){
						// alert(data);
						 $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 });
					 }
		    	});	
		  
	    });
	  });
	  window.oxx={
			  "click .a":function(q,w,e){//修改版主
				  $(":selected").removeAttr("selected");
				  $("#modal3").modal("show");
				  $("html,body").animate({scrollTop:0},50);
				  $("#form3 input[name=classId]").val(e.classId);
				  $("#updateButton").off();
				  $("#updateButton").on("click",function(){
						$("#modal3").modal("hide");
						$.ajax({
							url :"/BBS/backstageBclassServlet",
							data : $("#form3").serialize(),
							success : function(data) {
								//alert(data);
							 	$("#tab01").bootstrapTable("refresh", {
									silent : true
								}); 
							}

						});
				 });
			  }
	  };
	  window.ox={
			  "click .a":function(q,w,e){//删除
			  $.ajax({
					 url:"/BBS/backstageBclassServlet",
					 data:"classId="+e.classId+"&state=Delete",
					 success:function(data){
				/* 		 alert(data); */
						   $("#tab01").bootstrapTable("refresh" ,{
							  silent:true
						  });
					 }
				 }); 
			  },
			  "click .b":function(q,w,e){//修改
				  
				 $("#modal1").modal("show");
			      $("#updateForm input[name=classId]").val(e.classId);
			      $("#updateForm input[name=className]").val(e.className);
			      $("#updateForm input[name=classMsg]").val(e.classMsg);
			      $("#updateForm img").attr("src","${pageContext.request.contextPath}/"+e.classPicture);
			  //    $("#updateForm input[name=classPicture]").val(e.classPicture);
			      $("div[class*='modal-footer'] button:eq(1)").off();
			      $("div[class*='modal-footer'] button:eq(1)").on("click",function(){
			    	  if($("input[type='file']:eq(0)").val()==""){
			    		  alert("请选择log图片！");
			    		  return;
			    		}
			    	/*   $("#updateForm input[name=classId]").val("");
				      $("#updateForm input[name=className]").val("");
				      $("#updateForm input[name=classMsg]").val("");
				      $("#updateForm img").attr("src",e.classPicture); */
			    		 $("#modal1").modal('hide');
			    			var fd = new FormData($("#updateForm")[0]);//通过[0]将jQuery转换成js
							console.log(fd);
			    	  $.ajax({
			    		 url:"/BBS/backstageBclassUpdateServlet",
						 data:fd,
						 type:"post",
						 dataType:"json",
						 processData:false,
						 contentType:false,
						 success:function(data){
						//	 alert(data);
							 $("#tab01").bootstrapTable("refresh",{
								 silent:true
							 });
						 },
			    		
			    	});
			      });
				  
			  }
	  };

	  $("#tab01").bootstrapTable({
		  
	        classes: 'table table-hover',
	        sortClass: undefined,
	        locale: undefined,
	        height: undefined,
	        undefinedText: '-',
	        sortName: "",
	        sortOrder: 'asc',
	        sortStable: true,
	        striped: true,
	        columns: [
	                  {
	                	  field:"classId",
	                	  title:"板块编号"
	                  },{
	                	  field:"className",
	                	  title:"板块名称"
	                  },{
	                	  field:"classMsg",
	                	  title:"版面公告"
	                  },{
	                	  field:"userName",
	                	  title:"版主",
	                	  formatter:function(i,n){
	                		//  alert(typeof(i));
	                 	  if(i==undefined){
	  	                	 return "无版主<button type='button' class='a btn btn-warning'>修改版主</button>";
	                	  }else{
		                  return i+"<button type='button' class='a btn btn-warning'>修改版主</button>";
	                 } 
	                	//  return i+"<button type='button' class='a btn btn-warning'>修改版主</button>";
	                	  },
	                	  events : oxx
	                	/*   formatter:function(i,n){
	                		  return "<button type="button" class="a btn btn-warning">修改版主</button>"
	                	  },
	                	  events:oxx */
	                  },{
	                	  field:"classPicture",
	                	  title:"板块图片相对路径",
	                	  formatter:function(i,n){
	                /*   alert("<img  src='"+i+"'>"); */
	                		  return "<img  src='${pageContext.request.contextPath}/"+i+"' width='100px' height='100px'>";
	                	  }
	                  }, {
	                	  title:"操作",
	                	  formatter:function(i,n){
	                		  return "<button class='a btn btn-danger'>删除</button><button class='b btn btn-warning'>修改</button>";
	                	  },
	                	  events : ox
	                  } 
	                  ],
	        data: [],
	        totalField: 'total',
	        dataField: 'rows',
	        method: 'get',
	        url: '/BBS/backstageBclassServlet',
	        ajax: undefined,
	        cache: false,
	        contentType: 'application/json',
	        dataType: 'json',
	        ajaxOptions: {},
	        queryParams: function (params) {
	        	console.log(params);
	        	  return {
	          	    limit : params.limit,  /* 请求参数 */
	  				offset : params.offset,
	  				search : params.search,
	  				state : "Manager",
	  				sort:params.sort,
	  				order:params.order
	             };
	        },
	        queryParamsType: 'limit', // undefined
	        responseHandler: function (res) {
	            return res;
	        },
	        pagination: true,
	        onlyInfoPagination: false,
	        paginationLoop: true,
	        sidePagination: 'server', // client or server
	        totalRows: 0, // server side need to set
	        pageNumber: 1,
	        pageSize: 6,
	        pageList: [10, 25, 50, 100],
	        paginationHAlign: 'right', //right, left
	        paginationVAlign: 'bottom', //bottom, top, both
	        paginationDetailHAlign: 'left', //right, left
	        paginationPreText: '&lsaquo;',
	        paginationNextText: '&rsaquo;',
	        search: true,
	        searchOnEnterKey: false,
	        strictSearch: false,
	        searchAlign: 'right',
	        selectItemName: 'btSelectItem',
	        showHeader: true,
	        showFooter: true,
	        showColumns: true,
	        showPaginationSwitch: false,
	        showRefresh: true,
	        showToggle: true,
	        buttonsAlign: 'right',
	        smartDisplay: true,
	        escape: false,
	        minimumCountColumns: 1,
	        idField: undefined,
	        uniqueId: undefined,
	        cardView: false,
	        detailView: false,
	        detailFormatter: function (index, row) {
	            return '';
	        },
	        trimOnSearch: true,
	        clickToSelect: false,
	        singleSelect: false,
	        toolbar: "#toolbar",
	        toolbarAlign: 'left',
	        checkboxHeader: true,
	        sortable: true,
	        silentSort: true,
	        maintainSelected: false,
	        searchTimeOut: 500,
	        searchText: '',
	        iconSize: undefined,
	        buttonsClass: 'default',
	        iconsPrefix: 'glyphicon', // glyphicon of fa (font awesome)
	        icons: {
	            paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
	            paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
	            refresh: 'glyphicon-refresh icon-refresh',
	            toggle: 'glyphicon-list-alt icon-list-alt',
	            columns: 'glyphicon-th icon-th',
	            detailOpen: 'glyphicon-plus icon-plus',
	            detailClose: 'glyphicon-minus icon-minus'
	        },

	        customSearch: $.noop,

	        customSort: $.noop,

	        rowStyle: function (row, index) {
	            return {};
	        },

	        rowAttributes: function (row, index) {
	            return {};
	        },

	        footerStyle: function (row, index) {
	            return {};
	        },

	        onAll: function (name, args) {
	            return false;
	        },
	        onClickCell: function (field, value, row, $element) {
	            return false;
	        },
	        onDblClickCell: function (field, value, row, $element) {
	            return false;
	        },
	        onClickRow: function (item, $element) {
	            return false;
	        },
	        onDblClickRow: function (item, $element) {
	            return false;
	        },
	        onSort: function (name, order) {
	            return false;
	        },
	        onCheck: function (row) {
	            return false;
	        },
	        onUncheck: function (row) {
	            return false;
	        },
	        onCheckAll: function (rows) {
	            return false;
	        },
	        onUncheckAll: function (rows) {
	            return false;
	        },
	        onCheckSome: function (rows) {
	            return false;
	        },
	        onUncheckSome: function (rows) {
	            return false;
	        },
	        onLoadSuccess: function (data) {
	            return false;
	        },
	        onLoadError: function (status) {
	            return false;
	        },
	        onColumnSwitch: function (field, checked) {
	            return false;
	        },
	        onPageChange: function (number, size) {
	            return false;
	        },
	        onSearch: function (text) {
	            return false;
	        },
	        onToggle: function (cardView) {
	            return false;
	        },
	        onPreBody: function (data) {
	            return false;
	        },
	        onPostBody: function () {
	            return false;
	        },
	        onPostHeader: function () {
	            return false;
	        },
	        onExpandRow: function (index, row, $detail) {
	            return false;
	        },
	        onCollapseRow: function (index, row) {
	            return false;
	        },
	        onRefreshOptions: function (options) {
	            return false;
	        },
	        onRefresh: function (params) {
	          return false;
	        },
	        onResetView: function () {
	            return false;
	        }
		  
	  });
  });
  </script>
   
   
</body>
</html>