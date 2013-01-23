<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> 

<html>
<head>
	<title>编辑奖品</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<sx:head extraLocales="en-us,nl-nl,de-de" />
	
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
        body {
			font: 11px Arial, Helvetica, sans-serif;
			background: #ffffff url(images/main-bg.gif);
			padding: 0;
			margin: 0;
		}
    </style>
    
</head>

<body>
<h1 align="center">欢迎进入Lottery系统</h1>
	<h3 align="center">
        <s:if test="null == prize">
             <p>增加奖品&nbsp;<a href="<s:url action="listPrize"/>">返回</a>&nbsp;&nbsp;<a href="<s:url action="index"/>">首页</a></p>
        </s:if>
        <s:else>
            <p> 编辑奖品&nbsp;<a href="<s:url action="listPrize"/>">返回</a>&nbsp;&nbsp;<a href="<s:url action="index"/>">首页</a></p>
        </s:else>
    </h3>
    <table align="center">
        <tr>
        	<td>
		        <s:form name="editForm" action="save" validate="true" method="post" enctype="multipart/form-data">
			
				 <s:textfield label="奖品名称" name="prize.prizeName"/>
				 <s:textfield label="奖品级别" name="prize.prizeLevel"/>
				 <s:textfield label="总数量" name="prize.totalNum"/>
			     <s:textfield label="剩余数量" name="prize.leftNum"/>
			     <s:file label="奖品图片" name="image"/> 
			     
			     <s:textfield label="奖品描述" name="prize.description"/>
			     
				 <s:if test="null == prize">
				 	<s:hidden name="prize.id" value="%{id}"/>
				 </s:if>	 	
			     <s:else>
				 	<s:hidden name="prize.id" />
				 	<s:hidden name="prize.gmtCreate" />
				 	<s:hidden name="prize.gmtModify" />
				 	<s:hidden name="prize.picture" />
				 </s:else>
				 <s:hidden name="queryName" />
				 <s:hidden name="queryValue" />
				 <s:submit value="%{getText('保存')}" />
			 </s:form>
        	</td>
        </tr>
    </table>
	
</body>
</html>
