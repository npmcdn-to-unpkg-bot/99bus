<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>交易记录</title>
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
</head>
<body
	style="text-align: center;  background: url('filesource/images/u0.png')">
  <div data-am-widget="list_news" class="am-list-news am-list-news-default border-c" >
  <!--列表标题-->
		<div class="am-list-news-bd " >
			<ul class="am-list">
				<c:if test="${response.page.page.size()<=0}">
						 <li class="am-g am-list-item-dated" style="padding:5px;text-align:center;" >
					        <a class="am-list-item-hd " style="text-align:center;">
					       		亲！您还没有产生交易记录啦！					        	
					        </a>
					    </li>
				</c:if>
				<c:forEach  items="${response.page.page}" var="ppp">
						 <li class="am-g am-list-item-dated" style="padding:5px;" >
					        <a class="am-list-item-hd " style="text-align:left;font-size:11px;">
					       		 <div style="float:left;width:100%"> 
					        	余额 ￥${ppp.user_balance} 元
					        	</div>
					        	<div style="float:left;width:80px;" class="color-as">
					        	${ppp.summary}
					        	</div>
					        	<div style="float:left;width:100px;" class="color-as"> 
					        	￥${ppp.amount} 元
					        	</div>
					        	
					        </a>
					        <span class="am-list-date" style="width:150px;">${ppp.timeStr}</span>
					    </li>
				</c:forEach>
			</ul>
		</div>
    </div>
</body>
</html>
