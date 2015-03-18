<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#edit").click(
						function() {
							var username = $("#username").val();
							var age = $("#age").val();
							var id=$("#id").val();
							var user = {
									id:id,
								username : username,
								age : age
							};

							$.ajax({
										url : "updateUser",
										type : "post",
										data : user,
										success : function(data) {
										alert(data.update);
										}
									});
						});
			});
</script>
</head>
<body>
	
		<input type="hidden" name="id" id="id" value="${user.id }"> name:<input
			type="text" name="username" id="username" value="${user.username }"> <br>
		age:<input type="text" name="age"  id="age"value="${user.age }"> <br>
		<input type="button" value="edit" id="edit">

</body>
</html>