<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>活动</title>
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
  <jsp:include page="inc.jsp"></jsp:include>
  <style type="text/css">
	.title-bg{
		background-color:#0e90d2;
		color:white;
	}
  </style>
  <base href="${resourceUrl}">
</head>
<body style="background:url('filesource/images/u0.png')">
	<div style="padding:5px;">
	<div data-am-widget="list_news" class="am-list-news am-list-news-default" >
	  <!--列表标题-->
		<div class="am-list-news-bd">
			<ul class="am-list">
			 <c:if test="${response.hasActvty=='false'}">
			 	<li class="am-g am-list-item-desced" style="text-align: center">
			         <a class="am-list-item-hd ">近期无活动</a>
			     </li>
			 </c:if>
			 <c:if test="${response.hasActvty=='true'}">
			 	<c:forEach items="${response.list}" var="ppp" varStatus="t" >
			     <li class="am-g am-list-item-desced">
			         <a class="am-list-item-hd ">${ppp.title}</a>
			         	<!-- ${ppp.content} -->
			         	<div class="am-gallery-item">
			         		<a href="${resourceUrl}${ppp.imgUrl}"><img src="${resourceUrl}${ppp.image_filename}" alt=""  width="95%" class="am-radius" style="margin-top:10px;height:150px;"></a>
			         	</div>
			     </li>
			    </c:forEach>
			 </c:if>
			 
			</ul>
		</div>
	</div>
	</div>
</body>
</html>
