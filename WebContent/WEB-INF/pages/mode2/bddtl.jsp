<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>标的详情</title>
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
<jsp:include page="inc.jsp"></jsp:include>
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<table class="am-table am-table-bordered"
		style="font-size: 14px; border-top-width: 0px; border-bottom-width: 0px;">
		<tr>
			<td colspan=4 style="border-radio: 3px;">
				<a style="font-size:14px;padding:5px;" class="color-sls">[${response.product_name}]</a>
				<font size="2" class="color-xms"></font>${response.borrowTitle}
			</td>
			<td colspan=2 style="border-width: 0px;"><font class="color-as"
				size="2">编号:${response.no}</font></td>
		</tr>
		<tr>
			<td colspan=6 class="am-text-middle"
				style="border-width: 0px; text-align: center;">
				<div style="width: 60%; margin: auto;">
					<font
						style="font-size: 40px; line-height: 40px; float: left; width: 50%"
						class="color-xms">${response.annualRate_formatter}</font>
					<div style="float: left; width: 50%; text-align: left;"
						class="color-as">年化利率</div>
					<div style="float: left; width: 10%; text-align: left;">%</div>
				</div>
			</td>
		</tr>
		<tr>
			<td class="am-text-middle" style="border-width: 0px;" colspan=2>${response.deadline}<br>
			<font class="color-as">产品期限</font></td>
			<td class="am-text-middle" style="border-width: 0px;" colspan=2>
				<div id="days" style="float: left; width: 30px;"></div>
				<div id="hours" style="float: left; width: 45px;">:</div>
				<div id="minutes" style="float: left; width: 40px;">:</div>
				<div id="seconds" style="float: left; width: 30px;"></div> <Br>
				<font class="color-as">投资剩余时间</font>
			</td>
			<td class="am-text-middle" style="border-width: 0px;" colspan=2>${response.borrowAmount_formatter}<br>
			<font class="color-as">总金额(元)</font></td>
		</tr>
		<tr>
			<Td style="border-width: 0px; border-top-width: 1px;" colspan=2><font
				class="color-as">进度</font> ${response.schedules}%</td>
			<Td colspan=4
				style="border-width: 0px; border-top-width: 1px; text-align: right;"><font
				class="color-as">可投金额(元)</font> <font class="color-xms" size="3">${response.canInvestAmount_formatter }</font></td>
		</tr>
		<tr>
			<Td colspan=6 style="border-width: 0px;">
				<div class="down">
					<div class="box1" style="width: 100%; padding: 0px;">
						<div class="box1" style="width: 100%"></div>
					</div>
					<div class="box1" style="width: 100%; padding: 0px;">
						<div class="box2 star" style="width:${response.schedules}%"></div>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="font-size: 16px; line-height: 40px; border-right: 0px;">金额</td>
			<td colspan=5 style="text-align: left; border-left: 0px;"><input
				class="am-form-field border-c" type="text"
				style="width: 80%; height: 40px; border: 0px;" id="amount"
				placeholder="请输入金额" onchange="changeMoney()"></td>
		</tr>
		<tr>
			<td colspan=6 style="text-align: center;"><font class="color-as">预期收益(元)</font><font
				class="color-xms" size="2" id="showAmt">0.00</font></td>
		</tr>
		<Tr>
			<Td colspan=6>
				<button type="button" class="am-btn am-btn-warning"
					style="width: 100%; border-radius: 8px;" onclick="showMeTheMoney()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;立即投资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
			</td>
		</tr>
	</table>
	<section data-am-widget="accordion"
		class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
		<dl class="am-accordion-item am-active">
			<dt class="am-accordion-title">借款详情说明</dt>
			<dd class="am-accordion-bd am-collapse am-in">
				<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content" style="font-size: 12px;">
					<b>${response.detailsTitleOne}</b><br> <span>${response.description}</span><br>

					<b>${response.detailsTitleTwo}</b><br> <span>${response.descriptionTwo}</span><br>
					<br> <b>${response.detailsTitleThree}</b><br> <span>${response.descriptionThree}</span><br>
					<br> <b>${response.detailsTitleFour}</b><br> <span>${response.descriptionFour}</span><br>
					<br> <b>${response.detailsTitleFive}</b><br> <span>${response.descriptionFive}</span><br>
					<br>
				</div>
			</dd>
		</dl>
		<dl class="am-accordion-item">
			<dt class="am-accordion-title">投标记录</dt>
			<dd class="am-accordion-bd am-collapse ">
				<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content">
					<div class="am-g">
						<div class="am-u-sm-3">投标人</div>
						<div class="am-u-sm-3">投标金额</div>
						<div class="am-u-sm-6">投标时间</div>
					</div>
					<c:forEach items="${inverstRecord.list}" var="ppp">
						<div class="am-g">
							<div class="am-u-sm-3">${ppp.name}</div>
							<div class="am-u-sm-3">${ppp.invest_amount}</div>
							<div class="am-u-sm-6">${ppp.timeStr}</div>
						</div>
					</c:forEach>
				</div>
			</dd>
		</dl>
		<dl class="am-accordion-item">
			<dt class="am-accordion-title">必要材料审核科目</dt>
			<dd class="am-accordion-bd am-collapse ">
				<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content">
					<c:forEach items="${response.list}" var="ppp">
						<div class="am-g">
							<div class="am-u-sm-6">${ppp.AuditSubjectName}</div>
							<div class="am-u-sm-3">${ppp.auditStatus}</div>
							<div class="am-u-sm-3">
								<a href="${resourceUrl}${ppp.imgpath}">查看</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</dd>
		</dl>
		<dl class="am-accordion-item">
			<dt class="am-accordion-title">借款人信息</dt>
			<dd class="am-accordion-bd am-collapse ">
				<div class="am-accordion-content">
					<div class="am-g">
						<div class="am-u-sm-6">企业名称</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.enterprises_name}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">企业地址</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.address}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">营业执照</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.business_license}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">组织机构代码</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.organization_code}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">注册资金</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.capital_registered}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">企业法人</div>
						<div class="am-u-sm-6">${borrowerInfo.enterprises.corporation_name}</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">贷款记录</div>
						<div class="am-u-sm-6">
							<font class="color-xms">${response.SuccessBorrowNum}</font>次正常,<font
								class="color-xms">${response.borrowFailureNum}</font>次流标
						</div>
					</div>
					<div class="am-g">
						<div class="am-u-sm-6">还款记录</div>
						<div class="am-u-sm-6">
							<font class="color-xms">${response.NormalRepaymentNum}</font>次正常,<font
								class="color-xms">${response.OverdueRepamentNum}</font>次逾期
						</div>
					</div>
				</div>
			</dd>
		</dl>
	</section>
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="showSubmitArea">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				<a href="javascript: void(0)" class="am-close am-close-spin"
					data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd">
				<form class="am-form am-form-horizontal"
					action="cshoprtn/inverstBid" data-am-validator method="post">
					<div class="am-form-group">
						<div class="am-u-sm-10">
							<input type="text" id="tradMoney" class="js-pattern-amount"
								name="amount" required readonly> <input type="hidden"
								id="borrowId" name="borrowId" value="${response.borrowid}">
						</div>
					</div>
					<div class="am-form-group">
						<div class="am-u-sm-10">
							<input type="password" id="doc-ipt-pwd-2" name="dealPwd"
								placeholder="请输入交易密码" required>
						</div>
					</div>
					<div class="am-form-group">
						<div class="am-u-sm-10">
							<button type="submit" class="am-btn am-btn-default">购买</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var t;
		$(function() {
			t = ${response.remainTimeCalc};
			var days = parseInt(t / 1000 / 60 / 60 / 24);
			var hours = parseInt((1 * t - days * (1000 * 60 * 60 * 24))
					/ (1000 * 60 * 60));
			var minutes = parseInt((t - days * (1000 * 60 * 60 * 24) - hours
					* (1000 * 60 * 60))
					/ (1000 * 60));
			var seconds = (t - days * (1000 * 60 * 60 * 24) - hours
					* (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
			$('#days').html(days + "天");
			$('#hours').html(hours + "小时");
			$('#minutes').html(minutes + "分");
			$('#seconds').html(seconds + "秒");
			tm = setInterval(change, 1000);
		});
		function change() {
			t = t - 1000;
			var days = parseInt(t / 1000 / 60 / 60 / 24);
			var hours = parseInt((1 * t - days * (1000 * 60 * 60 * 24))
					/ (1000 * 60 * 60));
			var minutes = parseInt((t - days * (1000 * 60 * 60 * 24) - hours
					* (1000 * 60 * 60))
					/ (1000 * 60));
			var seconds = (t - days * (1000 * 60 * 60 * 24) - hours
					* (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
			$('#days').html(days + "天");
			$('#hours').html(hours + "小时");
			$('#minutes').html(minutes + "分");
			$('#seconds').html(seconds + "秒");
		}
		function changeMoney() {
			var amount = $('#amount').val();
			var apr = ${response.annualRate};
			var period = ${response.period};
			var periodUnit = ${response.periodUnit};
			var showAmt = 0;
			if (periodUnit == "-1") {
				showAmt = period * amount * apr / 100;
			} else if (periodUnit == "0") {
				showAmt = period * amount * apr / 100 / 12;
			} else if (periodUnit == "1") {
				showAmt = period * amount * apr / 100 / 365;
			}
			$('#showAmt').html(showAmt);
		}
		function showMeTheMoney() {
			var amount = $('#amount').val();
			if (amount <= 0 || amount % 1000 != 0) {
				alert('信息', '投资金额必须大于0且必须是1000的倍数');
				return;
			}
			$.ajax({
				url : "cshoprtn/checkTrad",
				type : "post",
				data : {},
				success : function(data) {
					var json = JSON.parse(data);
					if (json.error == '-9') {
						$('#confirmMsgContext').html("您还未登录！点击确定跳转到登录界面!");
						$('#my-confirm').modal({
							relatedTarget : this,
							onConfirm : function(options) {
								$('#lgnFrmComm').submit();
							},
							onCancel : function() {
							}
						});
					} else if (json.error == '-8') {
						$('#confirmMsgContext').html(
								"您还 未设置交易密码！点击确定跳转到设置交易密码界面!");
						$('#my-confirm').modal({
							relatedTarget : this,
							onConfirm : function(options) {
								$('#setTradPwdFrmComm').submit();
							},
							onCancel : function() {
							}
						});
					} else {
						$('#tradMoney').val(amount);
						$('#showSubmitArea').modal();
					}
				}
			})

		}
	</script>
</body>
</html>
