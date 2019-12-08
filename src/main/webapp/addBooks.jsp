<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
<h1 align="center" style="font-family: 华文行楷;font-size: 28px;">图书列表页面</h1>
<hr>
<form action="addBooks" method="post">
<p>图书类型：<select name="type_id">
	<option value="-1">请选择</option>
</select></p>
<p>图书名称：<input type="text" name="bname"></p>
<p>图书收欢迎程度：<input type="text" name="sales"></p>
<p>电话号：<input type="text" name="phone"></p>
<p><input type="submit" value="提交"></p>
</form>
<script type="text/javascript">
$(function() {
	$.post("getTypeList", function(res) {
		for ( var i in res) {
			var op = $('<option value="'+res[i].tid+'">'+res[i].tname+'</option>');
			$("[name=type_id]").append(op);
		}
	})
});
</script>
</body>
</html>