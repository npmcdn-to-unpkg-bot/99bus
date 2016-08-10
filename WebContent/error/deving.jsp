<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Sorry！！</title>
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
  <script  src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" ></script>
  <script type="text/javascript">
  	function closeWin(){
  		WeixinJSBridge.call('closeWindow');
  		
  	}
  	function hiddenMenu(){
  		wx.hideOptionMenu();
  	}
  </script>
</head>
<body style="text-align:center;">
	<a>功能开发中！</a><br>
	<button onclick="history.back(-1);">返回</button>
</body>
</html>