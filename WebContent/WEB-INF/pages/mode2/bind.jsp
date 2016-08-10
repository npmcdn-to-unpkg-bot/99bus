<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录并绑定</title>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<jsp:include page="inc.jsp"></jsp:include>
</head>
<script type="text/javascript">
	function submitLogin() {
		var crypt = new JSEncrypt();
		crypt.setPublicKey($('#publicKey').val());
		var usrN = crypt.encrypt($('#userName').val());
		var pwdN = crypt.encrypt($('#pwd').val());
		$('#userName').val(usrN);
		$('#pwd').val(pwdN);
		$('#loginForm').submit();
	}
</script>

<body style="text-align: center; padding: 100px 10px;background:url('filesource/images/u0.png')">
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<!-- 公钥区 -->
	<textarea id="publicKey" rows="15" style="width: 100%; height: 200px; display: none;" readonly>${pubKey}</textarea>
	<form action="login/bind" method="post" id="loginForm">
		<input type="text" id="userName" name="userName" style="height:50px;border:0px;"
			class="am-form-field am-radius border-c" placeholder="请输入账号-只需要输入一次"> <input
			type="password" id="pwd" name="pwd" class="am-form-field am-radius border-c"
			placeholder="请输入密码-请随意" style="margin-top: 10px;height:50px;border:0px;">
		<button type="button" class="am-btn am-btn-warning am-btn-block background-red border-c"
			style="margin-top: 10px;font-size:20px;height:50px;" onclick="submitLogin();">登录</button>
			<div> <a onclick="convertHrefToForm('user/registerStep1?v='+new Date().getTime())">没有帐号？我要注册！！</a></div>
	</form>
</body>
</html>
