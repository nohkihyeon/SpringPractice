<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MemberJoinProc</title>
</head>

<link rel="stylesheet" type="text/css" href="/css/ui.jqgrid.css"/>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="/css/ui.multiselect.css"/>

<script src="/js/jquery.js" type="text/javascript"></script>
<!-- <script src="/js/jquery.jqGrid" type="text/javascript"></script> -->
<script src="/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
<script src="/js/jquery.jqGrid.min.js" type="text/javascript"></script>

<body>
	<div>  <!-- 조회 옵션 부분 -->
		<form action = "member/list">
			<select name="search" id="search" class = "search" onchange="reLoad()">
				<option value='general'>일반</option>
				<option value='all'>전체</option>
				<option value='admin'>관리자</option>
				
			</select>		
		</form>
	</div>
	<table id="list"></table>
	<div id="pager"></div>
</body>

<!-- onchange="reLoad(this.value)" -->
<script type="text/javascript">
$(document).ready(function () {
jQuery("#list").jqGrid({
   	url:'/member/list',
	datatype: "json",
   	colNames:['아이디','이름', '성별', '생년월일', '이메일', '전화번호','주소','등급'],
   	colModel:[
   		{name:'id',index:'id', width:55},
   		{name:'name',index:'name', width:90},
   		{name:'gender',index:'name asc, invdate', width:100},
   		{name:'birth',index:'birth', width:80, align:"center"},
   		{name:'email',index:'email', width:80, align:"center"},
   		{name:'phone',index:'phone', width:80, align:"center"},
   		{name:'address',index:'address', width:80, align:"center"},
   		{name:'grade',index:'grade', width:80, align:"center",     
   		    stype: "select",
            searchoptions: { value: "general:general;admin:admin;all:all" }
        }
 
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#pager',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
    caption:"회원 리스트",
	
});


jQuery("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false},{},{},{},{
	multipleSearch:false,
	multipleGroup:false,
	showQuery:false,
	top: 190,
	left: 200,
	caption: "Searching standard, admin Member",
	closeAfterSearch:false,
	sopt:['eq'],
},);

});
function reLoad() {
	console.log($(".search").val());
	$("#formId").submit();
	 jQuery("#list").trigger("reloadGrid");  
}


</script>

</html>