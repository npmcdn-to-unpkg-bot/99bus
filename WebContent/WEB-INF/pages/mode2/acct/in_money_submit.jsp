<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>充值</title>
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
<body style="text-align:left;padding:20px;font-size:15px;background:url('filesource/images/u0.png')">
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<div style="width:100%;">
		<table style="margin:auto;margin-top:4px; width:100%;background:white;" class="border-c" >
			<Tr>
				<td width="30%" height=50 style="padding:5px;">卡号</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">尾号2666</td>
			</tr>
			<Tr style="border-top:1px dashed #ccc;">
				<td width="30%" height=50 style="padding:5px;">银行</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">中国建设银行</td>
			</tr>
			<Tr style="border-top:1px dashed #ccc;">
				<td width="30%" height=50 style="padding:5px;">单笔限额</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">5万</td>
			</tr>
			<Tr style="border-top:1px dashed #ccc;">
				<td width="30%" height=50 style="padding:5px;">单日限额</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">5万</td>
			</tr>
		</table>
		<table style="margin:auto;margin-top:20px; width:100%;background:white;" class="border-c" >
			<Tr>
				<td width="30%" height=50 style="padding:5px;">充值金额</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">5000.00元</td>
			</tr>
		</table>
		<table style="margin:auto;margin-top:4px; width:100%;background:white;" class="border-c" >
		
			<Tr>
				<td width="30%" height=50 style="padding:5px;">实际到帐</td>
				<td width="70%" style="padding:5px;text-align:right;color:#ccc;">5000.00元</td>
			</tr>
		</table>
		<table style="margin:auto;margin-top:4px; width:100%;">
			<Tr>
				<td width="30%" colspan=2 style="padding:5px;font-size:12px;">
					<font color=red>温馨提示:</font><br>
					如果您的充值金额超过银行卡充值限额，请通过电脑登录99金额官网wwww.99jinrong.com进行网银充值.
				</td>
			</tr>
		</table>
	</div>
	<a class="am-btn am-btn-danger background-red border-c" href="#" style="width:100%;margin-top:15px;font-size:20px;" target="_blank">充值</a>
</body>
</html>
