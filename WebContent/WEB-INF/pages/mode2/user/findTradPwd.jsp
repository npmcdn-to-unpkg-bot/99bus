<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>重置交易密码</title>
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
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var i = 0;
	function change() {
		if (i >0) {
			$('#sendBtn').attr('disabled', true);
			$('#sendBtn').html("<font color=white>"+i + "秒</a>");
		} else {
			$('#sendBtn').attr('disabled', false);
			$('#sendBtn').html("<font color=white>重新发送</a>");
			clearInterval(tm);
			i = 60;
		}
		i = i - 1;
	}
	function interl() {
		tm = setInterval(change, 1000);
	}
	function check(){
		var newPwd = $('#tradpwd').val();
		var newPwd2 = $('#tradpwd2').val();
		if(newPwd != newPwd2){
			showCheckMsg("newloginpwd2","两次输入新密码必须相同");
			return false;
		}
	}
</script>
</head>
<body
	style="text-align: center; padding: 20px; background: url('filesource/images/u0.png')">
	<form action="usr/findTradPwd" method="post" class="am-form" onsubmit="return check()" id="form-with-tooltip">
		<span>您正在重置用户${showUseName} 的交易密码</span>
		<table style="margin: auto; margin-top: 15px; width: 100%">
			<Tr>
				<td width="70%">
					<div class="am-form-group border-c">
						<input class="am-form-field border-c"
						type="text" id="randomCode" name="randomCode" 
						placeholder="请输入手机验证码"
						style="height: 50px;" pattern="^\d{4}$" 
						required data-foolish-msg="请输入4位验证码">
					</div>
				</td>
				<td width="30%">
					<div class="am-form-group border-c">
						<button type="button"
							class="am-btn background-red color-white border-c" 
							style="height: 50px; line-height: 18px; font-size: 18px"
							id="sendBtn" onclick="interl()">发送</button>
					</div>
				</td>
			</tr>
		</table>
		<table
			style="margin: auto; margin-top: 15px; width: 100%;"
			class="border-c">
			<Tr style="border-bottom: 1px solid #f0f1f4;">
				<td width="80%" colspan=2>
					<div class="am-form-group border-c">
						<input class="am-form-field border-c" 
						required	type="password" id=tradpwd 
						name=tradpwd style="border: white; height: 50px;"	
						placeholder="请输入新交易密码(密码应为6-20位字母加数字)"
						pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"
						data-foolish-msg="密码应为6-20位字母加数字">
					</div>
				</td>
			</tr>
		</table>
		<table
			style="margin: auto; margin-top: 15px; width: 100%;"
			class="border-c">
			<Tr style="border-bottom: 1px solid #f0f1f4;">
				<td width="80%" colspan=2>
					<div class="am-form-group border-c">
						<input class="am-form-field border-c" 
						required	type="password" 
						id=tradpwd2 name=tradpwd2  
						data-equal-to="#tradpwd" 
						style="border: white; height: 50px;"	
						placeholder="请再次输入新交易密码"
						data-foolish-msg="必须与第一次输入密码相同">
					</div>
				</td>
			</tr>
		</table>
		<button type="submit" 
		class="am-btn background-red color-white border-c"
		style="width: 80%; height: 50px; line-height: 18px; font-size: 18px; margin-top: 50px;">提&nbsp;&nbsp;交</button>
	</form>
	
</body>
</html>
