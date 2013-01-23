<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
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
	<title>Index抽奖</title>
	<script src="js/jquery-min.js"></script>
	<script src="js/jquery.catslider.js"></script>
	<script src="js/modernizr.custom.63321.js"></script>
	<script>
		$(function() {
			window.location.href = 'index.action';
		});
	</script>

</head>
<body>
</body>
</html>