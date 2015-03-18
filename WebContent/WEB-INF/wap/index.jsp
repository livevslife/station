<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="wapcss/cp_style20130306.css" rel="stylesheet"
	type="text/css">
<title>登陆</title>
<script type="text/javascript"
	src='<c:url value="/jquery/jquery-1.9.1.js"/>'></script>
<script type="text/javascript">
	function login() {
		var name = $("#login_name").val();
		var pwd = $("#login_pwd").val();
		var method = {
			username : name,
			password : pwd
		};

		$.ajax({
			url : "login.do",
			type : "post",
			data : method,
			success : function(data) {
				if (data.sms == "success") {
					window.location.href="welcome.do";
				} else {
					alert(data.sms);
				}
			}
		});
	}
</script>
</head>
<header><jsp:include page="include/header.jsp" flush="true" /></header>
<section>
<div class="content">
	<article> <!--article-->
	<div class="login-box">
			<dl class="login-tab">
				<dd>
					用户名： <input type="text" name="username" id="login_name"
						class="login-text" placeholder="" maxlength="32">
				</dd>
				<dd>
					密&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password" name="password"
						id="login_pwd" class="login-text" placeholder=""
						autocomplete="off" maxlength="32">
				</dd>
				<dd class="code" style="height: auto;">
					<input type="checkbox" name="remember" value="1" checked="checked">
					记住我
				</dd>
			</dl>
			<div class="deal-btn" style="margin-top: 15px;">
				<input type="button" class="j_submit" onclick="javascript:login();" name="dologin" value="登录">
			</div>

	</div>
	<article>
</section>
<footer class="footer_v3"><jsp:include
	page="include/footer.jsp" flush="true" /></footer>
</html>