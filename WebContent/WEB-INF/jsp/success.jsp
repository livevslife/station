<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src='<c:url value="/jquery/jquery-1.9.1.js"/>'></script>
<script type="text/javascript">
	function del(id) {
		var method = {
			id : id
		};

		$.ajax({
			url : "delUser",
			type : "post",
			data : method,
			success : function(data) {
				if (data.del == "success") {
					alert(data.del);
					location.reload();
				}else{
					alert(data.del);
				}
			}
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table border="1">
		<tr>
			<td>name</td>
			<td>age</td>
			<td>contrlt</td>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach items="${list }" var="u">
				<tr>
					<td>${u.username }</td>
					<td>${u.age }</td>
					<td><a href="getUser?id=${u.id }">edit</a> <a id="ajaxadd"
						href="javascript:del('${u.id }');">ajaxdel</a></td>

				</tr>
			</c:forEach>
		</c:if>

	</table>
</body>
</html>