<%@page pageEncoding="gb2312" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Lotteryϵͳ</title>
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
			alert("�������ѯ�ؼ���!");
		} else {
			window.location.href = "bookAdmin/result.action?queryValue="
					+ document.all.queryValue.value;
		}
	}
</script>
<body>
	<h1 align="center">��ӭ����Lottery�齱���ҳ��</h1>
	<table align="center">
<tr align="center">
	<td>
		<p> <select name="searchName">
				<option value="number">����</option>
				<option value="name">����</option>
				
		 </select>
		<input type="text" name="searchValue" value="" size="10"/>
		<input type="button" value="��ѯ" onClick="doSearch();">
		<a href="<s:url action="index"/>">��ҳ</a></p>
	</td>
</tr>
<tr align="center">	
	<td>
		<a href="<s:url action="resultLottery" includeParams="none"/>">ȫ��</a>
		<a href='<s:url action="editAlipayer" ></s:url>'>����</a>
	</td>
</tr>
<tr>
<td>
<table cellspacing="0" align="center" width="100%" hight="100%">
	<thead>
    <tr>
        <th>ID</th>
							<th>����Ա</th>
							<th>��Ʒ����</th>							
							
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
    		��<s:property value="totalRows"/>��&nbsp;
    		��<s:property value="currentPage"/>ҳ&nbsp;
    		��<s:property value="pager.getTotalPages()"/>ҳ&nbsp;
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">��ҳ</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">��һҳ</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">��һҳ</a>
    		<a href="<s:url value="resultLottery">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">βҳ</a>
    	</td>
    </tr>	
    </tbody>
</table>
</body>
</html>
