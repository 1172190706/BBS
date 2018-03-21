<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style type="text/css">	
		    body *{font-family: Microsoft YaHei UI;}
		    body{background-color: #ECF7FB;height: 100%;}
		</style> 
</head>
        <link rel="stylesheet" href="css/front.css" />
		<link rel="stylesheet" href="css/layout.css" />
		<link rel="stylesheet" href="css/whole.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-table.css" />
		
		<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table.js" ></script>
		<script type="text/javascript" src="js/bootstrap-table-zh-CN.js" ></script>
		
<body>
<table id="tab01"></table>
<script type="text/javascript">
$(function(){
	
	window.oxxx={
			"click .a":function(q,w,e){//取消置顶
				$.ajax({
				    url:"/BBS/backstageThemeServlet",
					 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
					 data:"themeId="+e.themeId+"&state=top&isTopState=1",
					 async:false,
					 success:function(data){
						 // alert(data); 
						 $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 });
					 }
			});
			},"click .b":function(q,w,e){//置顶
				//alert("b");
				$.ajax({
					    url:"/BBS/backstageThemeServlet",
						 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
						 data:"themeId="+e.themeId+"&state=top&isTopState=0",
						 async:false,
						 success:function(data){
							 // alert(data); 
							 $("#tab01").bootstrapTable("refresh",{
								 silent:true
							 });
						 }
				});
			/* 	var tr= $(e).parents("tr");
				tr.fadeOut().fadeIn();
				$("#tab01").prepend(tr); */
			}
	};
	window.oxx={
			"click .a":function(q,w,e){//设为精华帖
				$.ajax({
				    url:"/BBS/backstageThemeServlet",
					 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
					 data:"themeId="+e.themeId+"&state=sign&themeSign=1",
					 success:function(data){
						/* alert(data);  */
						 $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 });
					 }
			});
			},"click .b":function(q,w,e){//设为普通帖
				$.ajax({
				    url:"/BBS/backstageThemeServlet",
					 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
					 data:"themeId="+e.themeId+"&state=sign&themeSign=0",
					 success:function(data){
					/* 	alert(data);  */
						 $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 });
					 }
			});
			}
			
	};
	window.ox={
			"click .a":function(q,w,e){//删除帖子
				$.ajax({
				    url:"/BBS/backstageThemeServlet",
					 /* data:[{"userId":e.userId},{"state":"join"},{"userState":"N"}], */
					 data:"themeId="+e.themeId+"&state=delete",
					 success:function(data){
					/* 	alert(data);  */
						 $("#tab01").bootstrapTable("refresh",{
							 silent:true
						 });
					 }
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
	                	  field:"themeId",
	                	  title:"编号"
	                  },{
	                	  field:"className",
	                	  title:"所属版面"
	                  },{
	                	  field:"themeClassName",
	                	  title:"主贴类别 "
	                  },{
	                	  field:"themeTitle",
	                	  title:"主贴标题"
	                  },{
	                	  field:"themeBody",
	                	  title:"主贴内容"
	                  },{
	                	  field:"themeTime",
	                	  title:"发表时间"
	                  },{
	                	  field:"themeViewCount",
	                	  title:"浏览量"
	                  },{
	                	  field:"themeSign",
	                	  title:"主题标记",
	                	  formatter:function(i,n){
	                		  if(i==0){
	                			  return "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp普通帖<button type='button' class='a btn btn-warning'>设为精华帖</button>"
	                		  }else{
	                			  return "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp精华帖<button type='button' class='b btn btn-warning'>设为普通帖</button>"
	                		  }
	                	  },
	                	  events:oxx
	                  },{
	                	  field:"themeIsTop",
	                	  title:"是否置顶",
	                	  formatter:function(i,n){
	                		  if(i==0){
	                			  return "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置顶<button type='button' class='a  btn btn-warning'>取消置顶</button>"
	                		  }else{
	                			  return "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp不置顶<button type='button' class='b  btn btn-warning'>置顶</button>"
	                		  }
	                	  },
	                	  events:oxxx
	                  },{
	                	  field:"themeUpTime",
	                	  title:"修改时间"
	                  },{
	                	  title:"操作",
	                	  formatter:function(i,n){
	                		  return "<button type='button' class='a btn btn-danger'>删除</button>";
	                	  },
	                	  events:ox
	                  }
	                  ],
	        data: [],
	        totalField: 'total',
	        dataField: 'rows',
	        method: 'get',
	        url:'/BBS/backstageThemeServlet',
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
	        pageSize: 5,
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