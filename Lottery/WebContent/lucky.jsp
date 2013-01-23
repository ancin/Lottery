<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Lucky!</title>
    <meta charset="GBK">
    <link href="css/lucky.css" rel="stylesheet">
</head>
<body>

<button id="go" data-text-start="空格开始  ESC取消 回车确认" data-text-stop="空格结束" data-action="start"></button>

<div id="container">
    <ul id="balls">
    </ul>
    <ul id="lucky-balls">
    </ul>
</div>


<script src="js/sea.js"></script>
<script>
    seajs.use(['./js/lucky', './js/jqueryLucky'], function(Lucky, $) {
    	
        $.ajax({
        	url:"./getAllAlipayer.action",
        	dataType:"json",
        	success:function(data){
        		var allUsers = $.parseJSON(data.JSONRESULT),allUsersArr=[];
        		for(var i in allUsers){
        			var user={};
        			user.name=allUsers[i].name;
        			user.uid=allUsers[i].id;
        			allUsersArr.push(user);
        		}
        		Lucky.init(allUsersArr);
        	}
        });
    	
    })
</script>

</body>
</html>