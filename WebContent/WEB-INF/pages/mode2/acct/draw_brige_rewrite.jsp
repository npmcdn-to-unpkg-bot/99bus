<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>提现申请</title>
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
</head>
<body style="text-align:left;padding:10px;font-size:18px;line-height:50px;background:url('filesource/images/u0.png')">
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 
	<a  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  	以获得更好的体验！
</p>
<![endif]-->
	<form action="cshoprtn/drawRqst" method="post">
	<div style="border:1px solid #ccc;width:100%;background:white;" class="border-c">
		<table style="margin:auto;margin-top:4px; width:100%;" >
			<Tr>
				<td width="30%" height=50 style="padding:5px;">可提现余额</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">${response.withdrawalAmount}元</td>
			</tr>
			<Tr style="border-top:1px dashed #ccc;">
				<td width="30%" height=50 style="padding:5px;">提现银行卡</td>
				
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">
					<select multiple data-am-selected name="bankId">
						<c:forEach items="${response.bankList}" var="ppp" varStatus="t" >
							  <option value="${ppp.id}">${ppp.bankName} + ${ppp.subAccount.substring(ppp.subAccount.length()-4)}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
	
	<div style="border:1px solid #ccc;width:100%;margin-top:10px;background:white;" class="border-c">
		<table style="margin:auto;margin-top:4px; width:100%;" >
			<Tr>
				<td width="30%" height=50 style="padding:5px;">提现金额</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">
					<input class="am-form-field border-c" type="text" style="height:50px;border:0px;"  name="amount" placeholder="请输入金额" value="${amount}">
				</td>
			</tr>
			<Tr>
				<td width="30%" height=50 style="padding:5px;">交易密码</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">
					<input class="am-form-field border-c" type="password" style="height:50px;border:0px;"  name="payPassword" placeholder="请输入交易密码">
				</td>
			</tr>
		</table>
	</div>
	
	<div style="text-align:right;color:red;">
		提现说明
	</div>
	
	<div style="margin:0px;"></div>
	
	<button class="am-btn am-btn-danger background-red border-c" type="submit" style="width:100%;margin-top:15px;height:50px;font-size:18px;line-height:18px;" target="_blank">提交请求</button>
	
	<div style="text-align:right;color:red;">
		忘记密码
	</div>
	</form>
</body>
</html>
