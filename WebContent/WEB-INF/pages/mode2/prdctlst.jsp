<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>投资列表</title>
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
<body style="background:url('filesource/images/u0.png');padding:3px;" >
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<style>
	a{
		color:black;
	}
</style>
<div class="am-tabs">
  <ul class="am-tabs-nav am-nav am-nav-tabs">
    <li style="width:50%;text-align:center;"><a style="background:#ff7e00;color:white;">我要投资</a></li>
    <li style="width:50%;text-align:center;"><a onclick="convertHrefToForm('prdct/toTrnsfrLst?v='+new Date().getTime())">债权变现</a></li>
  </ul>
<div style="width:100%;background:#d4cfcf;font-size:12px;">
	<center style="padding:10px">高收益稳健性投资产品，期限金额灵活选择</center>
</div>

<section data-am-widget="accordion" class="am-accordion am-accordion-gapped" data-am-accordion='{  }' style="margin:0px;">

	<c:forEach items="${response.list}" var="ppp" varStatus="t">
			<c:if test="${ppp.loan_schedule=='100'}">
					<dl class="am-accordion-item am-active background-adj" style="background:white;border:0px;border-radius:0;">	
			</c:if>
			<c:if test="${ppp.loan_schedule!='100'}">
					<dl class="am-accordion-item am-active" style="background:white">
			</c:if>
			<dd class="am-accordion-bd am-collapse am-in">
			<c:if test="${ppp.loan_schedule=='100'}">
				<a onclick="convertHrefToForm('prdct/toOverBdDtl?bid=${ppp.id}&product_name=${ppp.product_name}&v='+new Date().getTime())">
			</c:if>
			<c:if test="${ppp.loan_schedule!='100'}">
				<a onclick="convertHrefToForm('prdct/toBdDtl?bid=${ppp.id}&product_name=${ppp.product_name}&v='+new Date().getTime())">
			</c:if>
					<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border-top-width:0px;border-bottom-width:0px;border:0px;background:url('filesource/images/kbx.png?p=2') no-repeat right top;">
						<tr> 
							<td colspan=4 style="text-align:left;border:0px;">
								<font color="#095f8a"><b>[${ppp.product_name}]</b></B></font>&nbsp;${ppp.title}
							</td>
						</tr>
						<tr style="border:0px;">
							<td class="am-text-middle" style="text-align:left;border:0px;"></td>
							<td class="am-text-middle" style="text-align:left;border:0px;"><font color="#ff7e00"  size="5px">${ppp.apr_formatter}%</font><br><font class="color-as" size=2>年利率</font></td>
							<td class="am-text-middle" style="text-align:left;border:0px;">${ppp.period} ${ppp.periodUnitStr}<br><font class="color-as" size=2>期限</font></td>
							<td class="am-text-middle" style="text-align:left;border:0px;">${ppp.can_inverster_amt_formatter}元<br><font class="color-as" size=2>可投金额</font></td>
						</tr>
						<tr>
							<Td colspan=4 style="border:0px;">
								<div class="down">
									<div class="box1" style="width:100%;padding:0px;">
										<div class="box1" style="width:100%"></div>
									</div>
									<div class="box1" style="width:100%;padding:0px;">
										<div class="box2 star" style="width:${ppp.loan_schedule}%"></div>
									</div>
								</div>	
								<div class="title color-xms">
									<c:if test="${ppp.loan_schedule=='100'}">
									售罄	
									</c:if>
									<c:if test="${ppp.loan_schedule!='100'}">
									已投${ppp.loan_schedule}	%
									</c:if>
								</div>				
							</td>
						</tr>
					</table>
				</a>
			</dd>
		</dl>
		</c:forEach>
</section>
<script>
/**
	amount = "0";
	var exp = /^([1-9][\d]{0,10}|0)(\.[\d]{1,2})?$/;
    if(exp.test(amount)){
		alert(true);
    }else{
		alert(false);
    }
**/
</script>
</body>
</html>
