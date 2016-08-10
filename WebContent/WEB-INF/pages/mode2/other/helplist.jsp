<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>帮助中心</title>
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
<body style="padding:3px;" >

<section data-am-widget="accordion" class="am-accordion am-accordion-gapped" data-am-accordion='{  }' style="margin:0px;">

	<c:forEach items="${response.list}" var="ppp" varStatus="t" >
				<c:if test="${t.index==0}">
					<dl class="am-accordion-item am-active">
				</c:if>
				<c:if test="${t.index>0}">
					<dl class="am-accordion-item">
				</c:if>
		        <dt class="am-accordion-title">
		          	${ppp.title}
		        </dt>
		        <c:if test="${t.index==0}">
					<dd class="am-accordion-bd am-collapse am-in">
				</c:if>
				<c:if test="${t.index>0}">
					<dd class="am-accordion-bd am-collapse">
				</c:if>
				<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content" style="font-size:12px;">
					${ppp.content}
					
	            </div>
	        </dd>
	    </dl>
	</c:forEach>
</section>
</body>
</html>
