<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>我的资产</title>
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
		background-color:#ff7e00;
		color:white;
	}
  </style>
</head>
<script type="text/javascript">
	function payIn(){
		$.ajax({
			url:"cshoprtn/checkBank",
			type: "post",
			data: {},			
			success: function(data){
				var json=JSON.parse(data);
				if(json.error != '-1')
					choseBandCard();
				else {
					$('#payInf').modal();
				}
		    }
		})
	}
	function drawOut(){
		$.ajax({
			url:"cshoprtn/checkBank",
			type: "post",
			data: {},			
			success: function(data){
				var json=JSON.parse(data);
				if(json.error != '-1')
					choseBandCard();
				else {
					$('#drawOut').submit();
				}
		    }
		})
	}
	function choseBandCard(){
		$('#confirmMsgContext').html("您还未绑卡！点击确定跳转到绑卡界面!");
		$('#my-confirm').modal({
	        relatedTarget: this,
	        onConfirm: function(options) {
	        	$('#bankCard').submit();
	        },
	        onCancel: function() {
	        }
	      });
	}
</script>
<body style="text-align:center;background:url('filesource/images/u0.png')">
<form action="rgstr/toBndCrd" method="post" id="bankCard"></form>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border-top-width:0px;border-bottom-width:0px;line-height:0px;background:#F37B1D;" >
	<tr class="title-bg" > 
		<td colspan=6 class="am-text-middle" style="border-width:0px;">
			------&nbsp;总资产(元)&nbsp;------
		</td>
	</tr>
	<tr class="title-bg" > 
		<td colspan=6 class="am-text-middle" style="border-width:0px;">
			<font size="10">${userBalance}</font>
		</td>
	</tr>
	<!-- 
	<tr class="title-bg">
		<td class="am-text-middle" style="border-width:0px;">&nbsp;</td>
		<td class="am-text-middle" colspan=2 style="border-width:0px;">待收收益（元）</td>
		<td class="am-text-middle" style="border-width:0px;border-right: 1px solid white ;"></td>
		<td class="am-text-middle" style="border-width:0px;">已赚取收益（元） </td>
		<td class="am-text-middle" style="border-width:0px;">&nbsp;</td>
	</tr>

	<tr class="title-bg">
		<td class="am-text-middle" style="border-width:0px;"></td>
		<td class="am-text-middle" colspan=2 style="border-width:0px;">${withdrawalAmount}</td>
		<td class="am-text-middle" style="border-width:0px;border-right: 1px solid white ;" ></td>
		<td class="am-text-middle"  style="border-width:0px;">${score}</td>
		<td class="am-text-middle" style="border-width:0px;"></td>
	
	</tr>
	 -->
</table>
<table width="98%" style="border-bottom:1px" class="borde-gray">
	<Tr>
		<Td>可用余额(元)</td>
		<td rowspan=2 style="text-align:right;vertical-align:middle;"><a  onclick="payIn()">充值</a>&nbsp;&nbsp;<a onclick="drawOut()">提现</a></td>
		<form action="cshoprtn/toDrwOt" method="post" id="drawOut"></form>
	</tr>
	<Tr>
		<Td style="color:#ff6c00;">&nbsp; ${withdrawalAmount} &nbsp;</td>
	</tr>
</table>
<div style="float:left;text-align:center;width:100%;height:120px;font-size:12px;line-height:12px;">
	<table style="width:80%;height:100px;margin:auto;">
		<tr>
			<td width="33%">
				我的体验金
			</td>
			<td  width="33%">
				我的现金卷
			</td>
			<td  width="33%">
				我的红包
			</td>
		</tr>
	　　<tr>
	　　	<td style="vertical-align:middle;">
				<table style="width:90px;height:60px;margin:auto;" >
					<Tr >
						<td class="am-radius" style="vertical-align:middle;background-color:#ff6c00;WORD-WRAP: break-word;color:white;">
							0元
						</td>
					</tr>
				</table>
			</td>
			<td style="vertical-align:middle;">
				<table style="width:90px;height:60px;margin:auto;">
					<Tr>
						<td class="am-radius" style="vertical-align:middle;background-color:#16a0ec;WORD-WRAP: break-word;color:white;">
							0.00
						</td>
					</tr>
				</table>
			</td>
			<td style="vertical-align:middle;">
				<table style="width:90px;height:60px;margin:auto;">
					<Tr>
						<td class="am-radius" style="vertical-align:middle;background-color:#de00ff;WORD-WRAP: break-word;color:white;">
							你还没有红包请留意平台活动
						</td>
					</tr>
				</table>
			</td>
	　　</tr>
	</table>
</div>
<div class="am-tabs border-c" data-am-tabs="{noSwipe: 1}">
  <ul class="am-tabs-nav am-nav am-nav-tabs">
    <li class="am-active" style="width:50%;text-align:center;"><a href="#tab1">待收款</a></li>
    <li style="width:50%;text-align:center;"><a href="#tab2">历史记录</a></li>
  </ul>
  <div class="am-tabs-bd" style="background:white;">
    <div class="am-tab-panel  am-in am-active" id="tab1">
		<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border-width:0px;">
			<c:if test="${respHolding.list.size()==0}">
				<tr> 
						<td style="border-left:0px;">
							你目前未持有任何产品 <a onclick="convertHrefToForm('prdct/index?v='+new Date().getTime());">购买产品</a>
						</td>
				</tr>
			</c:if>
			<c:if test="${respHolding.list.size()>0}">
				<tr> 
						<td style="border-left:0px;">
							已收金额
						</td>
						<td style="border-left:0px;">
							本息合计应收金额
						</td>
						<td style="border-left:0px;">
							年利率
						</td>
				</tr>
				<c:forEach items="${respHolding.list}" var="ppp" varStatus="t" >
					<tr> 
						<td style="border-left:0px;">
							${ppp.has_received_amount} 
						</td>
						<td style="border-left:0px;">
							 ${ppp.receiving_amount}
						</td>
						<td style="border-left:0px;">
							 ${ppp.apr}
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
    </div>
    <div class="am-tab-panel am-fade" id="tab2">
		<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border-width:0px;">
			<c:if test="${respHistory.list.size()==0}">
				<tr> 
					<td style="border-left:0px;" min-height="200px">
						你目前未有任何持仓记录 <a onclick="convertHrefToForm('prdct/index?v='+new Date().getTime());">购买产品</a>
					</td>
				</tr>
			</c:if>
			<c:if test="${respHistory.list.size()>0}">
				<tr> 
						<td style="border-left:0px;">
							标的编号
						</td>
						<td style="border-left:0px;">
							投资金额
						</td>
						<td style="border-left:0px;">
							年利率
						</td>
				</tr>
				<c:forEach items="${respHistory.list}" var="ppp" varStatus="t" >
					<tr> 
						<td style="border-left:0px;">
							${ppp.no} 
						</td>
						<td style="border-left:0px;">
							 ${ppp.invest_amount}
						</td>
						<td style="border-left:0px;">
							 ${ppp.apr}
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
    </div>
  </div>
</div>
<!--
	<Tr height='50'>
		<td class="am-text-middle" style="border-width:0px;">&nbsp;</td>
		<td class="am-text-middle" colspan=2 style="border-width:0px;"><span class="am-icon-shopping-basket">&nbsp;我的持仓</span></td>
		<td class="am-text-middle" style="border-width:0px;"></td>
		<td class="am-text-middle" style="border-width:0px;" colspan=2><a>查看历史持仓</a></td>
	</tr>
</table>
 <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
<table class="am-table am-table-bordered am-table-centered" style="font-size:14px;border-top-width:0px;border-bottom-width:0px;">
	<tr> 
			<td>
				你目前未持有任何产品 <a href="">购买产品</a>
			</td>
	</tr>
</table>
    -->
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
			<li style="background:#F5280F;">
			  <a onclick="convertHrefToForm('usrbs/toCptl?v='+new Date().getTime())">
				<span class="am-navbar-label" style="color:white;font-size:15px;line-height:55px;">资产</span>
			  </a>
			</li>
			<li>
			  <a onclick="convertHrefToForm('usrbs/toInf?v='+new Date().getTime())">
				<span class="am-navbar-label" style="font-size:15px;line-height:55px;">我</span>
			  </a>
			</li>
		</ul>
	</div>
 <div class="am-modal am-modal-no-btn" tabindex="-1" id="payInf">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
		<form class="am-form am-form-horizontal" method=post action="cshoprtn/toDrwIn" data-am-validator>
		  <div class="am-form-group">
			<div class="am-u-sm-10">
			  <input type="text" id="amount" name="amount" pattern="^([1-9][\d]{0,7})(\.[\d]{1,2})?$"  placeholder="请输入充值金额(大于0)" required>
			</div>
		  </div>
		  <div class="am-form-group">
			<div class="am-u-sm-10">
			  <button type="submit" class="am-btn am-btn-default" >充值</button>
			</div>
		  </div>
		</form>
    </div>
  </div>
</div>
</body>
</html>
