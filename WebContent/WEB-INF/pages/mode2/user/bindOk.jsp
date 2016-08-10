<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>成功绑定银行卡</title>
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
<body style="text-align:left;padding:20px;font-size:18px;background:url('filesource/images/u0.png')">
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<span class="color-red">已成功绑定银行卡</span>
	<div style="border:1px solid #ccc;background:white;" class="border-c">
		<table style="margin:auto;margin-top:4px; width:100%;" >
			<Tr>
				<td width="20%" style="padding:5px;">
					<img src="images/header-small.jpg" width=50 height=50 class="am-img-thumbnail am-circle"/>
				</td>
				<td width="80%" style="padding:5px;">
					<span style="float:right;line-height:30px;">${bank_nm}</span>
				</td>
			</tr>
			<Tr style="border-top:1px dashed #ccc;">
				<td width="20%" height=60 style="padding:5px;">
					卡号
				</td>
				<td width="80%" style="padding:5px;">
					<span style="float:right;line-height:30px;">${capAcntNo}</span>
				</td>
			</tr>
		</table>
	</div>
	<div style="border:1px solid #ccc;margin-top:4px;background:white;" class="border-c">
		<table style="margin:auto; width:100%">
			<Tr>
				<td style="padding:5px;">
					<span  class="color-orange">中国银行快捷充值限额</span>
				</td>
			</tr>
			<Tr>
				<td style="padding:5px;">
					单笔限额：5万
				</td>
			</tr>
			<Tr>
				<td style="padding:5px;">
					单日限额：50万
				</td>
			</tr>
		</table>
	</div>
	<a class="am-btn am-btn-danger background-red border-c" href="user/inMoney" style="width:100%;margin-top:15px;font-size:20px;" target="_blank">去充值</a>
	<a class="am-btn am-btn-default background-gray border-c " href="prdct/index" style="width:100%;margin-top:4px;color:black;font-size:20px;" target="_blank">再看看</a>
</body>
</html>
