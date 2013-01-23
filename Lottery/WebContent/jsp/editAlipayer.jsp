<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> 

<html>
<head>
	<title>编辑员工</title>
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
<h1 align="center">欢迎进入Lottery系统---员工管理</h1>
	<h3 align="center">
        <s:if test="null == alipayer">
             <p>增加员工&nbsp;<a href="<s:url action="listPrize"/>">返回</a>&nbsp;&nbsp;<a href="<s:url action="index"/>">首页</a></p>
        </s:if>
        <s:else>
            <p> 编辑员工&nbsp;<a href="<s:url action="listPrize"/>">返回</a>&nbsp;&nbsp;<a href="<s:url action="index"/>">首页</a></p>
        </s:else>
    </h3>
    <table align="center">
        <tr>
        	<td>
		        <s:form name="editForm" action="saveAlipayer" validate="true" method="post" enctype="multipart/form-data">
			
				 <s:textfield label="工号" name="alipayer.number"/>
				 <s:textfield label="姓名" name="alipayer.name"/>
				 <s:textfield label="花名" name="alipayer.nickName"/>
			     <s:textfield label="电话" name="alipayer.tele"/>			     
			     <s:textfield label="描述" name="alipayer.desc"/>
			     
				 <s:if test="null == alipayer">
				 	<s:hidden name="alipayer.id" value="%{id}"/>
				 </s:if>	 	
			     <s:else>
				 	<s:hidden name="alipayer.id" />
				 	<s:hidden name="alipayer.gmtCreate" />
				 	<s:hidden name="alipayer.gmtModify" />
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
