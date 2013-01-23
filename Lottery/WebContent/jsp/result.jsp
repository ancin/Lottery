<%@page pageEncoding="gb2312" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Lottery系统</title>
</head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

table thead tr th {
	border: 1px solid black;
	padding: 3px;
	background-color: #cccccc;
}

table tbody tr td {
	border: 1px solid black;
	padding: 3px;
}
</style>


<script language="JavaScript">
	function doSearch() {
		if (document.all.queryValue.value == "") {
			alert("请输入查询关键字!");
		} else {
			window.location.href = "bookAdmin/result.action?queryValue="
					+ document.all.queryValue.value;
		}
	}
</script>
<body>
	<h1 align="center">欢迎进入Lottery抽奖结果页面</h1>
	<table align="center">
<tr align="center">
	<td>
		<p> <select name="searchName">
				<option value="number">工号</option>
				<option value="name">姓名</option>
				
		 </select>
		<input type="text" name="searchValue" value="" size="10"/>
		<input type="button" value="查询" onClick="doSearch();">
		<a href="<s:url action="index"/>">首页</a></p>
	</td>
</tr>
<tr align="center">	
	<td>
		<a href="<s:url action="resultLottery" includeParams="none"/>">全部</a>
		<a href='<s:url action="editAlipayer" ></s:url>'>增加</a>
	</td>
</tr>
<tr>
<td>
<table cellspacing="0" align="center" width="100%" hight="100%">
	<thead>
    <tr>
        <th>ID</th>
							<th>获奖人员</th>
							<th>奖品名称</th>							
							
    </tr>
    </thead>
    <tbody>
    <s:iterator value="availableItems" status="L">
							<tr class="trs">
						     	<td><s:property value="id" /></td>
								<td><s:property value="alipayerName" /></td>
								<td><s:property value="prizeName" /></td>
							</tr>
						</s:iterator>
    <tr align="right">
    	<td colspan="9">
    		共<s:property value="totalRows"/>行&nbsp;
    		第<s:property value="currentPage"/>页&nbsp;
    		共<s:property value="pager.getTotalPages()"/>页&nbsp;
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">上一页</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">下一页</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">尾页</a>
    	</td>
    </tr>	
    </tbody>
</table>
</body>
</html>
