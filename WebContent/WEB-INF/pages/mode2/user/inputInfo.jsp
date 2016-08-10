<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>注册</title>
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
	var i = 60;
	$(function() {
		$('#sendBtn').attr('disabled', true);
		tm = setInterval(change, 1000);

	});
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
		ajax("vldt/sndSMS","${mobile}");
		tm = setInterval(change, 1000);
	}
	function check(){
		var newPwd = $('#pwd').val();
		var newPwd2 = $('#pwd2').val();
		if(newPwd != newPwd2){
			showCheckMsg("pwd2","两次输入新密码必须相同");
			return false;
		}
	}
</script>
</head>
<body style="text-align: center; background: url('filesource/images/u0.png')">
	<div style="padding:20px;">
	<form action="rgstr/rgstr" method="post" class="am-form" id="form-with-tooltip" onsubmit="return check()" >
		<span style="text-align: left; font-size: 13px;">
				我们已发送短信验证码至${mobileshow},请在输入框内填写验证码,若未收到请耐心等候. </span> <input
				type="hidden" name="mobile" id="mobile" value="${mobile}" />
			<table style="margin: auto; margin-top: 15px; width: 100%">
				<Tr>
					<td width="70%">
						<div class="am-form-group border-c mrgn-pdng-zero">
						<input class="am-form-field" 
							type=text id="randomCode" name="randomCode" 
							style="height: 50px;" pattern="^\d{4}$" 
							required data-foolish-msg="请输入4位验证码">
						</div>
					</td>
					
					<td width="30%"><div class="am-form-group border-c mrgn-pdng-zero">
						<button type="button"
							class="am-btn background-red color-white border-c" 
							style="height: 50px; line-height: 18px; font-size: 18px"
							id="sendBtn" onclick="interl()">重新发送</button>
						</div>
					</td>
				</tr>
			</table>
			
			<table
				style="margin: auto; margin-top: 15px; width: 100%;"
				class="border-c">
				<Tr style="border-bottom: 1px solid #f0f1f4;">
					<td width="80%">
						<div class="am-form-group border-c mrgn-pdng-zero">
							<input class="am-form-field" 
								pattern="^[a-zA-Z0-9]{3,10}$" 
								required	
								data-foolish-msg="用户名应为3-10个字符（不含特殊字符）" 
								type="text" 
								id=name name=name style="height:50px;"	placeholder="请设置用户名(用户名应为3-10个字符（不含特殊字符）)">
						</div>	
					</td>
				</tr>
			</table>
			<table	style="margin: auto; margin-top: 15px; width: 100%;" class="border-c">
				<Tr style="border-bottom: 1px solid #f0f1f4;">
					<td width="80%" colspan=2>
						<div class="am-form-group border-c mrgn-pdng-zero">
							<input class="am-form-field border-c"  
							required	
							type="password" 
							id=pwd name=pwd 
							style="border: white; height: 50px;"
							pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"
							data-foolish-msg="密码应为6-20位字母加数字" 
							placeholder="请设置密码(6-20位字母加数字)">
						</div>
					</td>
				</tr>
				<Tr>
					<td width="80%" colspan=2>
						<div class="am-form-group border-c mrgn-pdng-zero">
							<input class="am-form-field border-c"  
							required	type="password" 
							id=pwd2 name=pwd2 
							style="border: white; height: 50px;"  
							data-equal-to="#pwd" placeholder="请再次输入密码" 
							data-foolish-msg="必须与第一次输入密码相同" />
						</div>
					</td>
				</tr>
			</table>
			<table style="margin: auto; margin-top: 15px; width: 100%; background: white;"	class="border-c">
				<Tr style="border-bottom: 1px solid #f0f1f4;">
					<td width="80%" colspan=2><input class="am-form-field border-c"
						type="text" id="referrerName" name="referrerName"
						style="border: white; height: 50px;"
						placeholder="请输入邀请码"></td>
				</tr>
			</table>
			<table
				style="margin: auto; margin-top: 15px; width: 100%; background: white; text-align: left; font-size: 13px;"
				class="border-c">
				<Tr
					style="border-bottom: 1px solid #E4E4E4; background: #BCBCBC; height: 30px;">
					<td width="80%" colspan=2 style="padding-left: 5px;">怎么获得邀请码？</td>
				</tr>
	
				<Tr style="background: #BCBCBC; height: 50px; line-height: 25px;"
					class="border-c">
					<td width="80%" colspan=2 style="padding-left: 5px;">填写<font color=red>好友手机号码</font>，和好友一起拿特权<br>无好友邀请码，填写<font color=red>666666</font>也能拿特权
					</td>
				</tr>
			</table>
			<button type="submit" 
			class="am-btn background-red color-white border-c"
			style="width: 80%; height: 50px; line-height: 18px; font-size: 18px; margin-top: 50px;">注&nbsp;&nbsp;册</button>		
	</form>
	</div>
</body>
</html>
