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

		</style>
		
</head>
<body>
 
    <table id="tab01"></table>
    <div class="modal fade" tabindex="-1" role="dialog" id="updateModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改</h4>
      </div>
      <div class="modal-body">
      
      <form class="form-horizontal" id="updateForm">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户编号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="userName" name="userId" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="userName" name="userName" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="userPwd" name="userPwd">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-10">
      <input type="hidden" class="form-control"   name="state" value="updatePwd">
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
    <script type="text/javascript">
    $(function(){
    	window.oxx={
    			 "click .a":function(q,w,e){//加入黑名单
    				 $.ajax({
   			    		 url:"/BBS/backstageUsersServlet",
   						 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
   						 data:"userId="+e.userId+"&state=join&userState=N",
   						 success:function(data){
   							/*  alert(data); */
   							 $("#tab01").bootstrapTable("refresh",{
   								 silent:true
   							 });
   						 }
   			    	});
     			},"click .b":function(q,w,e){//解除黑名单
     				 $.ajax({
   			    		 url:"/BBS/backstageUsersServlet",
   						 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
   						 data:"userId="+e.userId+"&state=join&userState=Y",
   						 success:function(data){
   							/*  alert(data); */
   							 $("#tab01").bootstrapTable("refresh",{
   								 silent:true
   							 });
   						 }
   			    	});
     			} 
     	
    	};
    	window.ox={
    			"click .a":function(q,w,e){//修改密码
    				  
   				 $("#updateModal").modal("show");
   				$("#updateForm input[name=userId]").val(e.userId);
   			      $("#updateForm input[name=userName]").val(e.userName);
   			      $("#updateForm input[name=userPwd]").val(e.userPwd);
   			      $("div[class*='modal-footer'] button:eq(1)").off();
   			      $("div[class*='modal-footer'] button:eq(1)").on("click",function(){
   			    		 $("#updateModal").modal('hide');
   			    	  $.ajax({
   			    		 url:"/BBS/backstageUsersServlet",
   						 data:$("#updateForm").serialize(),
   						 success:function(data){
   							/*  alert(data); */
   							 $("#tab01").bootstrapTable("refresh",{
   								 silent:true
   							 });
   						 }
   			    		
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
  	                	  field:"userId",
  	                	  title:"用户编号"
  	                  },{
  	                	  field:"userName",
  	                	  title:"用户姓名"
  	                  },{
  	                	  field:"userPwd",
  	                	  title:"用户密码"
  	                  },{
  	                	  field:"authMsg",
  	                	  title:"权限描述"
  	                  },{
  	                	  field:"state",
  	                	  title:"用户状态",
  	                	  formatter:function(i,n){
  	                		  if(i=="Y"){
  	                			  return "可用&nbsp<button type='button' class='a btn btn-warning'>加入黑名单</button>";
  	                		  }else{
  	                			  return "禁用&nbsp<button type='button' class='b btn btn-warning'>解除黑名单</button>";
  	                		  }
  	                	  },
  	                	events : oxx
  	                  },{
  	                	  title:"操作",
  	                	  formatter:function(){
  	                		  return "<button type='button' class='a btn btn-warning'>修改</button>";
  	                	  },
  	                	  events:ox
  	                  }
  	                  ],
  	        data: [],
  	        totalField: 'total',
  	        dataField: 'rows',
  	        method: 'get',
  	        url:'/BBS/backstageUsersServlet',
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
  	  				state: "Manager",
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
  	        pageSize: 10,
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