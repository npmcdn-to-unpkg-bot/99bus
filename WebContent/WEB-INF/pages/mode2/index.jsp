<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>99金融</title>
  <meta http-equiv="cache-control" content="max-age=0" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="expires" content="0" />
  <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="pragma" content="no-cache" />
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"  content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <jsp:include page="inc.jsp"></jsp:include>
</head>
<body style="background:url('filesource/images/u0.png?v=tt');padding-bottom:100px;" >
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<div data-am-widget="slider" class="am-slider am-slider-a1 border-c" data-am-slider='{"directionNav":false}'>
  <ul class="am-slides">
  	<c:forEach items="${adsList}" var="ads">
  		<li>
      		<img src="${resourceUrl}${ads.image_filename}">
    	</li>
  	</c:forEach>
  </ul>
</div>
  <ul data-am-widget="gallery" class="am-gallery am-avg-sm-4 am-avg-md-4 am-avg-lg-4 am-gallery-imgbordered " data-am-gallery="{  }" style="background:white;font-size:11px;">
      <li>
        <div class="am-gallery-item">
            <a onclick="convertHrefToForm('prdct/toJckrBd?v='+new Date().getTime())" class="">
              <img src="filesource/images/no-pic.png"/>
                <h3 class="am-gallery-title" style="text-align:center;">新手标</h3>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a onclick="convertHrefToForm('prdct/toLst?v='+new Date().getTime())" class="">
              <img src="filesource/images/zy-zhengrd.png" />
                <h3 class="am-gallery-title" style="text-align:center;">政融贷</h3>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a onclick="convertHrefToForm('prdct/toLst?v='+new Date().getTime())" class="">
              <img src="filesource/images/zy-zhird.png" />
                <h3 class="am-gallery-title" style="text-align:center;">直融贷</h3>
            </a>
        </div>
      </li>
      <li>
        <div class="am-gallery-item">
            <a onclick="convertHrefToForm('prdct/toTrnsfrLst?v='+new Date().getTime())" class="">
              <img src="filesource/images/no-pic.png" />
                <h3 class="am-gallery-title" style="text-align:center;">变现区</h3>
            </a>
        </div>
      </li>
  </ul>
<div style="float:left;width:95%;padding:0px;margin:10px;border-bottom: 1px solid #dedede;">
	<div style="float:left;width:65%;text-align:left;height:30px;line-height:30px;">
		<font color="red" style="font-size:19px;">政信项目</font>
		&nbsp;&nbsp;
		<font style="font-size:14px;">高保障 高收益</font>
	</div>
	<div style="float:left;width:35%;text-align:right;height:30px;line-height:30px;font-size:19px;" onclick="convertHrefToForm('prdct/toLst?v='+new Date().getTime())"><font class="color-sls" size="4">全部项目</font></div>
</div>  
<div style="margin:0px;"></div>
<section data-am-widget="accordion" class="am-accordion am-accordion-gapped" data-am-accordion='{  }' style="margin:0px;">
		<c:forEach items="${jresponse.list}" var="ppp" varStatus="t" >
		
				<c:if test="${ppp.loan_schedule!='100'}">
					<dl class="am-accordion-item am-active" style="background:white;border:0px;border-radius:0;">
			<dd class="am-accordion-bd am-collapse am-in">
			  <!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content" style="padding:0px;background:url('filesource/images/kbx.png?p=2') no-repeat right top;">
					
					<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border:0px;margin:0px;" onclick="convertHrefToForm('prdct/toBdDtl?bid=${ppp.id}&product_name=${ppp.product_name}&v='+new Date().getTime())">
						<tr> 
							<td colspan=3 style="text-align:left;border-left:0px;">
								<font color="#095f8a"><b>[${ppp.product_name}]</b></font>${ppp.title} <br>
								<!--<center>1号18期 陆渔公路项目 </center>
								<center>政融贷</center>-->
								<div style="float:left;width:30%;text-align:center;height:40px;line-height:40px;"><font class="color-xms">${ppp.apr}%</font></div>
								<div style="width:1%;float:left;height:40px;line-height:40px;color:#b9b9b9;">|</div>
								<div style="float:left;width:30%;text-align:center;height:40px;line-height:40px;">${ppp.period} ${ppp.periodUnitStr}</div>
								<div style="width:1%;float:left;height:40px;line-height:40px;color:#b9b9b9;">|</div>
								<div style="float:left;width:30%;text-align:center;height:40px;line-height:40px;">${ppp.amount-ppp.has_invested_amount}</div>
								<br><br>
								<div class="down">
									<div class="box1" style="width:100%;padding:0px;">
										<div class="box1" style="width:100%"></div>
									</div>
									<div class="box1" style="width:100%;padding:0px;">
										<div class="box2 star" style="width:${ppp.loan_schedule}%"></div>
									</div>
									
								</div>				
								<div class="title color-xms" style="text-align:center;">
									<c:if test="${ppp.loan_schedule=='100'}">
									售罄	
									</c:if>
									<c:if test="${ppp.loan_schedule!='100'}">
									已投${ppp.loan_schedule}	%
									</c:if>
								</div>
							</td>
						</tr>
						<!--
						<tr>
							<td style="border-top-width:0px;border-left:0px;">
								<a href="JavaScript:window.location.href='cplb.htm?v='+new Date().getTime();"><button type="button" class="am-btn am-btn-primary am-btn-block">立即选购</button></a>
							</td>
						</tr>
						-->
					</table>
			  </div>
			</dd>
		</dl></c:if>
				</c:forEach>
	 </section>
	
	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default  am-no-layout" id="" style="border-top:1px solid #ddd;height:55px;">
		<ul class="am-navbar-nav am-cf am-avg-sm-4">
			<li  style="background:#F5280F;">
			  <a onclick="convertHrefToForm('prdct/index?v='+new Date().getTime())">
				<span class="am-navbar-label" style="color:white;font-size:15px;line-height:55px;">主页</span>
			  </a>
			</li>
			<li>
			  <a onclick="convertHrefToForm('thr/toActvty?v='+new Date().getTime())">
					<span class="am-navbar-label" style="font-size:15px;line-height:55px;">活动</span>
			  </a>
			</li>
			<li>
			  <a onclick="convertHrefToForm('usrbs/toCptl?v='+new Date().getTime())">
				<span class="am-navbar-label" style="font-size:15px;line-height:55px;">资产</span>
			  </a>
			</li>
			<li>
			 <a onclick="convertHrefToForm('usrbs/toInf?v='+new Date().getTime())">
				<span class="am-navbar-label" style="font-size:15px;line-height:55px;">我</span>
			  </a>
			</li>
		</ul>
	</div>
</body>
</html>
