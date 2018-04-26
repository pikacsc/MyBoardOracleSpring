<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>AOP TABLE</h2>
		<table class="table table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th class="col-xs-1 col-sm-1 col-md-1 col-lg-1">No</th>
					<th class="col-xs-6 col-sm-6 col-md-6 col-lg-6">담당 개발자</th>
					<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">담당 메소드명</th>
					<th class="col-xs-2 col-sm-2 col-md-2 col-lg-2">소요시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{aopresult}" var="aop">
					<tr>
						<td></td>
						<td>${aop.stdname }</td>
						<td>${aop.method }</td>
						<td>${aop.time }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>