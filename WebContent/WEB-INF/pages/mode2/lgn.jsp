<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录</title>
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
<script type="text/javascript">
	function submitLogin() {
		var crypt = new JSEncrypt();
		crypt.setPublicKey($('#publicKey').val());
		var pwdN = crypt.encrypt($('#pwd').val());
		var useN = crypt.encrypt($('#username').val());
		$('#pwd').val(pwdN);
		$('#username').val(useN);
	}
</script>
</head>

<body
	style="text-align: center;; background: url('filesource/images/u0.png')">
	<div style="padding: 20px;padding-top:30px;">
		<textarea id="publicKey" rows="15"
			style="width: 100%; height: 200px; display: none;" readonly>${pubKey}</textarea>
		<form action="usr/lgn" method="post" id="loginForm"
			onsubmit="submitLogin()">
			<div style="margin-top: 15px;">
				<input class="am-form-field border-c" id="username"
					style="font-size: 20px;" name="userName" type="text"
					placeholder="请输入手机号" placeholder="请输入手机号"
					pattern="^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$"
					required />
			</div>
			<div style="margin-top: 5px;">
				<input class="am-form-field border-c" id="pwd"
					style="font-size: 20px;" name="pwd" type="password"
					placeholder="请输入密码" required />
			</div>
			<div
				style="text-align: left; font-size: 13px; line-height: 13px; margin-top: 10px; width: 50%; float: left;">
				<input type="checkbox" onclick="checkBoxChoose()" disabled
					id="cbxread"> 绑定微信
			</div>
			<div
				style="text-align: right; color: red; font-size: 13px; margin-top: 10px; width: 50%; float: right;">
				<a
					onclick="convertHrefToForm('usr/toResetLoginPwdShow?v='+new Date().getTime())"
					style="color: red;">忘记密码？</a>
			</div>
			<button type="submit"
				class="am-btn background-red color-white border-c"
				style="width: 70%; margin-top: 15px; font-size: 20px;">登录</button>
		</form>
		<div style="margin-top: 10px;">
			<a
				onclick="convertHrefToForm('rgstr/toRgstr?v='+new Date().getTime())">没有帐号？我要注册！！</a>
		</div>
	</div>
</body>
</html>
