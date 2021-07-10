<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>物品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>总价</td>
			</tr>

			<c:forEach items="${requestScope.orderItems}" var="orderItem">

				<tr>
					<td>${orderItem.name}</td>
					<td>${orderItem.count}</td>
					<td>${orderItem.price}</td>
					<td>${orderItem.totalPrice}</td>
				</tr>

			</c:forEach>

			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr><td colspan="5">订单号为：${param.orderId}</td></tr>

<%--			<tr>--%>
<%--				<td>2015.04.20</td>--%>
<%--				<td>20.00</td>--%>
<%--				<td>已发货</td>--%>
<%--				<td><a href="#">查看详情</a></td>--%>
<%--			</tr>	--%>
<%--			--%>
<%--			<tr>--%>
<%--				<td>2014.01.23</td>--%>
<%--				<td>190.00</td>--%>
<%--				<td>已完成</td>--%>
<%--				<td><a href="#">查看详情</a></td>--%>
<%--			</tr>		--%>
		</table>
	
	</div>

	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>