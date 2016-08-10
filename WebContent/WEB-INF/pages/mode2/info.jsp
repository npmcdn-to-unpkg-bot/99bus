<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>个人信息</title>
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
</head>
<body style="color:gray;font-size:14px;background:url('filesource/images/u0.png')">
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<style>
	a{
		color:black;
	}
	.divArea{
		line-height:35px;
		margin-top:10px;
		padding:0px;
		border:1px #f0f1f4 solid;
		border-radius:5px;
		padding-left:10px;
		padding-right:10px;
		background:white;
	}
</style>
<div data-am-widget="list_news" class="am-list-news am-list-news-default" style="margin:3px;">
<!--列表标题-->
	<div class="am-list-news-hd am-cf" style="margin:0px;border:1px #f0f1f4 solid;border-radius:5px;padding-left:5px;background:white;">
	   <!--带更多链接-->
			<Table width="100%">
				<Tr>
					<Td rowspan=3 width="30%">
						<img src="${resourceUrl}${headerImg}" width=80 height=100 class="am-img-thumbnail am-circle"/>
					</td>
					<Td width="70%">
					</td>
				</tr>
				<Tr>
					<Td >
						${response.realName.substring(0,1)}**
					</td>
				</tr>
				<Tr>
					<Td >
					</td>
				</tr>
			</table>
	</div>
	<div class="am-list-news-bd divArea">
		<ul class="am-list" style="margin-bottom:0px;">
		  <li class="am-g" style="border:0px;">
				证件号码<span style="float:right;">${response.idNo.substring(0,3)}************${response.idNo.substring(15)}</span>
		  </li>
		  <li class="am-g" style="border-color:#f0f1f4;">
				手机号码<span style="float:right;">${response.cellPhone1.substring(0,3)}*******${response.cellPhone1.substring(10)}</span>
		  </li>
		  <li class="am-g"  style="border-color:#f0f1f4;">
				银行卡管理 
				<c:if test="${!response.bindCard}">
					<span style="float:right;color:gray;" onclick="convertHrefToForm('rgstr/toBndCrd?v='+new Date().getTime())">
						 未绑定&nbsp;>
					</span>
				</c:if>
				
				 <c:if test="${response.bindCard}">
				 	<span style="float:right;color:gray;">
						  已绑定&nbsp;>
					</span>
				 </c:if>
		  </li>
		</ul>
	</div>
	<div class="am-list-news-bd divArea">
		<ul class="am-list" style="margin-bottom:0px;">
		  <li class="am-g"  style="border:0px;margin-bottom:0px;">
				<div onclick="convertHrefToForm('cshoprtn/toQueryTradList?v='+new Date().getTime())">交易记录<span style="float:right;">></span></div>
		  </li>
		</ul>
	</div>
	<div class="am-list-news-bd divArea">
		<ul class="am-list" style="margin-bottom:0px;">
			  <li class="am-g"  style="border:0px;" >
				<div onclick="convertHrefToForm('usr/toUpdateLoginPwdShow?v='+new Date().getTime())">修改登录密码<span style="float:right;">></span></div>
			  </li>
   	  		<c:if test="${response.setTradPwd}">		
		  	  <li class="am-g" style="border-color:#f0f1f4;"> 
				<div onclick="convertHrefToForm('usr/toUpdateTradPwd?v='+new Date().getTime())">修改交易密码<span style="float:right;">></span></div>
			  </li>
			  <li class="am-g" style="border-color:#f0f1f4;">
				 <div onclick="convertHrefToForm('usr/toFindTradPwd?v='+new Date().getTime())" >重置交易密码<span style="float:right;">></span></div>
	 		  </li>
			</c:if>
			<c:if test="${!response.setTradPwd}">
				<li class="am-g" style="border-color:#f0f1f4;">
					<div onclick="convertHrefToForm('usr/toSetTradPwd?v='+new Date().getTime())">设置交易密码<span style="float:right;">></span></div>
				</li>	
			</c:if>
		</ul>
	</div>
	<div class="am-list-news-bd divArea">
		<ul class="am-list" style="margin-bottom:0px;">
		  <li class="am-g" style="border:0px;margin-bottom:0px;" onclick="convertHrefToForm('thr/toQuestion?v='+new Date().getTime())">
				帮助中心  <span style="float:right;">></span>
		  </li>
		</ul>
	</div>
</div>
<a class="am-btn am-btn-danger background-red border-c" onclick="convertHrefToForm('usr/quit?v='+new Date().getTime())" style="width:100%;margin:auto;margin-top:10px;font-size:20px;" target="_blank">安全退出</a>
<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default  am-no-layout" id="" style="border-top:1px solid #ddd;height:55px;">
	<ul class="am-navbar-nav am-cf am-avg-sm-4">
		<li>
		  <a onclick="convertHrefToForm('prdct/index?v='+new Date().getTime())">
			<span class="am-navbar-label" style="font-size:15px;line-height:55px;">主页</span>
		  </a>
		</li>
		<li>
		  <a onclick="convertHrefToForm('thr/toActvty?v='+new Date().getTime())">
				<span class="am-navbar-label" style="font-size:15px;line-height:55px;">活动</span>
		  </a>
		</li>
		<li >
		  <a onclick="convertHrefToForm('usrbs/toCptl?v='+new Date().getTime())">
			<span class="am-navbar-label" style="font-size:15px;line-height:55px;">资产</span>
		  </a>
		</li>
		<li style="background:#F5280F;">
		  <a onclick="convertHrefToForm('usrbs/toInf?v='+new Date().getTime())">
			<span class="am-navbar-label" style="color:white;font-size:15px;line-height:55px;">我</span>
		  </a>
		</li>
	</ul>
</div>

<div class="am-modal am-modal-alert" tabindex="-1" id="develep-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">信息</div>
    <div class="am-modal-bd">
      维护中！！
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
</body>
</html>
