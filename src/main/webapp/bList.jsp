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
<table>
	<tr>
		<td colspan="7">
		<form action="getB" method="post">
		<input type="hidden" name="pageNum" value="${page.pageNum}">
			图书名称：<input type="text" name="bname" value="${map.bname}">
			图书类型：<select name="type_id">
				<option value="-1">请选择</option>
				<s:forEach items="${tList}" var="t">
					<option value="${t.tid}" ${t.tid==map.type_id?'selected':''}>${t.tname}</option>
				</s:forEach>
			</select>
			受欢迎程度：<input type="text" name="minSales" value="${map.minSales}">————
			<input type="text" name="maxSales" value="${map.maxSales}">
			<input type="submit" value="搜索">
		</form>
		</td>
	</tr>
	<tr>
		<td colspan="7">
			<input type="button" name="quan" value="全选">
			<input type="button" name="not" value="不选">
			<input type="button" name="fan" value="反选">
			<input type="button" name="dels" value="批量删除">
			<input type="button" name="add" value="添加图书">
		</td>
	</tr>
	<tr>
		<td>请选择</td>
		<td>序号</td>
		<td>图书名称</td>
		<td>类型</td>
		<td>受欢迎程度</td>
		<td>手机号</td>
		<td>操作</td>
	</tr>
	<s:forEach items="${page.list}" var="b">
		<tr>
			<td><input type="checkbox" name="arr" value="${b.bid}"></td>
			<td>${b.bid}</td>
			<td>${b.bname}</td>
			<td>${b.tname}</td>
			<td>${b.sales}%</td>
			<td>${b.phone}</td>
			<td><input type="button" value="删除" onclick="shan(${b.bid})"></td>
		</tr>
	</s:forEach>
	<tr>
		<td colspan="7">
		当前第${page.pageNum}页/共${page.pages}页, 共有${page.total}条记录&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="${page.isFirstPage==true}">
				<input type="submit" value="首页">
				<input type="submit" value="上一页">
			</s:if>
			<s:if test="${page.isFirstPage!=true}">
				<input type="submit" value="首页" onclick="getPageNum(1)">
				<input type="submit" value="上一页" onclick="getPageNum(${page.pageNum-1})">
			</s:if>
			<s:if test="${page.isLastPage!=true}">
				<input type="submit" value="下一页" onclick="getPageNum(${page.pageNum+1})">
				<input type="submit" value="尾页" onclick="getPageNum(${page.pages})">
			</s:if>
			<s:if test="${page.isLastPage==true}">
				<input type="submit" value="下一页">
				<input type="submit" value="尾页">
			</s:if>
		</td>
	</tr>
</table>
<script type="text/javascript">
function getPageNum(p) {
	$("[name=pageNum]").val(p);
	$("form").submit();
}

$("[name=dels]").click(function() {
	var id = $("[name=arr]:checked").map(function() {
		return $(this).val();
	}).get().join(",");
	if (id != null) {
		del(id);
	} else {
		alert("请至少选择一条记录!");
	}
});

$("[name=add]").click(function() {
	location = "addBooks.jsp";
});

$("[name=quan]").click(function() {
	$("[name=arr]").attr("checked", true);
});
$("[name=not]").click(function() {
	$("[name=arr]").attr("checked", false);
});
$("[name=fan]").click(function() {
	$("[name=arr]").each(function() {
		this.checked = !this.checked;
	});
});

function shan(id) {
	del(id);
}

function del(id) {
	var bo = confirm("确定删除"+id+"吗?");
	if (bo) {
		$.post("deleteBooks", {bid:id}, function(res) {
			if (res) {
				alert("删除成功!");
				location.reload();
			}
		});
	}
}
</script>
</body>
</html>