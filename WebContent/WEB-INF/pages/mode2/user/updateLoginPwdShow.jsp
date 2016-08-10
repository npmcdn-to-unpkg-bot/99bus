<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>修改登录密码</title>
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
		ajax("vld/sndSms",{});
		tm = setInterval(change, 1000);
	}
</script>
</head>
<body
	style="text-align: center;  background: url('filesource/images/u0.png')">
	<div style="padding: 20px;">
		<form action="usr/toUpdateLoginPwd" method="post" id="submitForm" onsubmit="check()" class="am-form" data-am-validator>
			<table
				style="margin: auto; margin-top: 15px; width: 100%; background: white;"
				class="border-c">
				<Tr style="border-bottom: 1px solid #f0f1f4;">
						<td style="width:30%;font-size:16px;">用户</td>
						<td style="width:60%;height:50px;text-align:left;font-size:16px;" class="color-blue">${mobileShow} </td>
				</tr>
			</table>
			
			<button type="submit" 
			class="am-btn background-red color-white border-c"
			style="width: 80%; height: 50px; line-height: 18px; font-size: 18px; margin-top: 50px;">下一步</button>
		</form>
	</div>
</body>
</html>
