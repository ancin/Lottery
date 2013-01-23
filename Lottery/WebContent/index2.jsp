<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Alipay抽奖页面</title>
		<meta name="description" content="Simple Multi-Item Slider: Category slider with CSS animations" />
		<meta name="keywords" content="jquery plugin, item slider, categories, apple slider, css animation" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/style_slider.css" />
		<link rel="stylesheet" type="text/css" href="css/test.css" />
		<style type="text/css">
			
        </style>
		<script src="js/modernizr.custom.63321.js"></script>


	</head>
	<body>
		<div class="container">	
			
			<div class="main">
				<div id="mi-slider" class="mi-slider">
					
					<ul>
						<s:iterator value="prizeLevel4">
					       <li><a href="prizeGo.action?id=<s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>"   onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
					    <s:if test="prizeLevel4.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<ul>
						<s:iterator value="prizeLevel3">
					       <li><a href="prizeGo.action?id=<s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>"  onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
					    <s:if test="prizeLevel3.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<ul>
						<s:iterator value="prizeLevel2">
					       <li><a href="prizeGo.action?id=<s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>" onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
					    <s:if test="prizeLevel2.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<ul>
					    <s:iterator value="prizeLevel1">
					       <li><a href="<%=basePath + "prizeGo.action?id="%><s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>"  onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
						<s:if test="prizeLevel1.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<ul>
						<s:iterator value="prizeLevel0">
					       <li><a href="prizeGo.action?id=<s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>"  onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
						<s:if test="prizeLevel0.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<ul>
						<s:iterator value="prizeLevel5">
					       <li><a href="prizeGo.action?id=<s:property value="id"/>">
					       <img src="<%=basePath + "/prizem/getImage?id="%><s:property value="id"/>"  onerror="javascript:this.src='images/default.png'" />
					       <h4><s:property value="prizeName"/>剩余:<s:property value="leftNum"/></h4></a></li>
					    </s:iterator>
						<s:if test="prizeLevel5.size() == 0">
						   <li><a href="#"><img src="images/noresult.png" alt="img15"><h4>奖品没有了</h4></a></li>
						</s:if>
					</ul>
					<nav>
						<a href="#">阳光奖</a>
						<a href="#">三等奖</a>
						<a href="#">二等奖</a>
						<a href="#">一等奖</a>
						<a href="#">特等奖</a>
						<a href="#">临时添加奖项</a>
					</nav>
				</div>
			</div>
		</div><!-- /container -->


<div style="display: none">

</div>
		<script src="js/jquery-min.js"></script>
		<script src="js/jquery.catslider.js"></script>
		<script>
			$(function() {

				$( '#mi-slider' ).catslider();
				
			});
		</script>
		



<div id="footer">
<div id="footer_content">
    	
        <div id="pasare1" onmouseover="afis_tag('tag_pasare1')" onmouseout="afis_tag('tag_pasare1')"><a href="listAlipayer.action"><img src="images/bird_01.png" alt="img01"><h4>人员管理</h4></a></div>
        <div id="tag_pasare1"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_adi.png" alt=""/></div>
        <div id="pasare2" onmouseover="afis_tag('tag_pasare2')" onmouseout="afis_tag('tag_pasare2')"><img src="images/bird_02.png" alt=""/></div>
        <div id="tag_pasare2"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_razvan.png" alt=""/></div>
        <div id="pasare3" onmouseover="afis_tag('tag_pasare3')" onmouseout="afis_tag('tag_pasare3')"><img src="images/bird_03.png" alt=""/></div>
        <div id="tag_pasare3"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_rcarata.png" alt=""/></div>
        <div id="pasare4" onmouseover="afis_tag('tag_pasare4')" onmouseout="afis_tag('tag_pasare4')"> <a href="listPrize.action"><img src="images/bird_04.png" alt="img01"><h4>奖项管理</h4></a></div>
        <div id="tag_pasare4"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_stefan.png" alt=""/></div>
        
        <div id="pasare5" onmouseover="afis_tag('tag_pasare5')" onmouseout="afis_tag('tag_pasare5')"> <a href="resultLottery.action"><img src="images/bird_05.png" alt="img01"><h4>结果管理</h4></a></div>
        <div id="tag_pasare5"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_marius.png" alt=""/></div>
        <div id="pasare6" onmouseover="afis_tag('tag_pasare6')" onmouseout="afis_tag('tag_pasare6')"><img src="images/bird_06.png" alt=""/></div>
        <div id="tag_pasare6"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_cristina.png" alt=""/></div>
        <div id="pasare7" onmouseover="afis_tag('tag_pasare7')" onmouseout="afis_tag('tag_pasare7')"><img src="images/bird_07.png" alt=""/></div>
        <!--<div id="tag_pasare7"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_catalina.png" alt=""/></div>-->
        <div id="pasare8" onmouseover="afis_tag('tag_pasare8')" onmouseout="afis_tag('tag_pasare8')"><img src="images/bird_08.png" alt=""/></div>
        <div id="tag_pasare8"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_felicia.png" alt=""/></div>  
        <div id="pasare9" onmouseover="afis_tag('tag_pasare9')" onmouseout="afis_tag('tag_pasare9')"><img src="images/bird_09.png" alt=""/></div>
        <!--<div id="tag_pasare9"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_vlad.png" alt=""/></div>-->
        <div id="pasare10" onmouseover="afis_tag('tag_pasare10')" onmouseout="afis_tag('tag_pasare10')"><img src="images/bird_10.png" alt=""/></div>
        <!--<div id="tag_pasare10"><img src="http://www.bei.ro/blog/wp-content/themes/ozn_bei/images/tag_mirel.png" alt=""/></div>-->
        <div id="dog" onmouseover="afis_tag('tag_dog')" onmouseout="afis_tag('tag_dog')"><img src="images/dog.png" alt=""/></div>
        <div id="tag_dog"><img src="images/tag_dog.png" alt=""/></div>                                                        
        <br style="clear:both"/>
    </div>
  </div>  
	</body>
</html>