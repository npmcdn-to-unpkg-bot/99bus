<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>输入手机号</title>
  <meta http-equiv="cache-control" content="max-age=0" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta http-equiv="expires" content="0" />
  <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="pragma" content="no-cache" />
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"  content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <jsp:include page="../inc.jsp"></jsp:include>
 <script type="text/javascript">
	function submitLogin() {
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if(!myreg.test($("#mobile").val())) 
		{ 
		    alert('请输入有效的手机号码！'); 
		    return false; 
		} 
		$('#submistForm').submit();
	}
	
</script>
</head>
<body style="text-align:center;font-size:20px;background:url('filesource/images/u0.png')">
	<div style="padding:20px;">
  	<form action="usr/toResetLoginPwd" method="post" id="submistForm"> 
		<table style="margin:auto; width:100%">
			<Tr>
				<td width="20%">
					<button type="button" class="am-btn background-red color-white border-c" style="height:50px;">+86</button>
				</td>
				<td width="80%">
					<input class="am-form-field border-c" required id="mobile" name="mobile" type="text" style="height:50px;" placeholder="请输入手机号" pattern="^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$" value="${moblie}">
				</td>
			</tr>
		</table><br>
		<button type="submit" class="am-btn background-red color-white border-c" style="width:70%;height:50px;line-height:30px;"  id="nextBtn">下一步</button>
		<div style="maring:0px;"></div>
		<span class="color-red" style="font-size:13px;margin-top:15px;">*您正在操作找回密码</span>
	</form>
	</div>
</body>
</html>
