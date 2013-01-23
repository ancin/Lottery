
<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head><title>Lottery系统</title></head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/MagicZoom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/mz-packed.js"></script>
    <style type="text/css">
        table {
            border: 1px solid blue;
            border-collapse: collapse;
        }
        
        table thead tr th {
            border: 1px solid blue;
            padding: 3px;
            background-color: #cccccc;
        }
        
        table tbody tr td {
            border: 1px solid blue;
            padding: 3px;
        }
        body {
			font: 11px Arial, Helvetica, sans-serif;
			background: #ffffff url(images/main-bg.gif);
			padding: 0;
			margin: 0;
		}
    </style>


	<script language="JavaScript">   
	    function doSearch(){
			if(document.all.searchValue.value=="")
			{	
				alert("请输入查询关键字!");
			}else{
				window.location.href="products/listAlipayer.action?queryName="+document.all.searchName.value+"&&queryValue="+document.all.searchValue.value;
		 	}
		}
	</script>
<body>
<h1 align="center">Alipay质量部应用测试组抽奖系统系统</h1>
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
		<a href="<s:url action="listAlipayer" includeParams="none"/>">全部</a>
		<a href='<s:url action="editAlipayer" ></s:url>'>增加</a>
	</td>
</tr>
<tr>
<td>
<table cellspacing="0" align="center" width="100%" hight="100%">
	<thead>
    <tr>
        <th>工号</th>
        <th>姓名</th>
        <th>花名</th>
        <th>手机</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="availableItems">
        <tr class="trs">
            <td>
            <a href='<s:url action="editAlipayer" ><s:param name="id" value="id" /></s:url>'>
            <s:property value="number"/>
            </a>
            </td>
            <td><s:property value="name"/></td>
            <td><s:property value="nickName"/></td>               
            <td><s:property value="tele" /></td>
			<td><s:property value="desc" /></td>			
            <td> <a href="javascript:if(confirm('确实要删除吗?'))location='deleteAlipay.action?id=<s:property value="id"/>'">删除</a></td>
        </tr>
    </s:iterator>
    <tr align="right">
    	<td colspan="9">
    		共<s:property value="totalRows"/>行&nbsp;
    		第<s:property value="currentPage"/>页&nbsp;
    		共<s:property value="pager.getTotalPages()"/>页&nbsp;
    		<a href="<s:url value="listAlipayer.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
    		<a href="<s:url value="listAlipayer.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">上一页</a>
    		<a href="<s:url value="listAlipayer.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">下一页</a>
    		<a href="<s:url value="listAlipayer.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">尾页</a>
    	</td>
    </tr>	
    </tbody>
</table>
</td>
</tr>
</table>
</body>
</html>
