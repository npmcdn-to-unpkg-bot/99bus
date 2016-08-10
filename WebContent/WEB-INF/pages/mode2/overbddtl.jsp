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
	<div class="padding-10">
		<div class="float-left ">
			<a style="font-size: 14px; padding: 5px;" class="color-sls">[${response.product_name}]</a> <font
				size="2" class="color-xms"></font> <font size="2">${response.borrowTitle}
			</font>
		</div>
		<div class="float-right " style="font-size: 14px; padding: 3px;">
			<font class="color-as" size="1"></font>编号:${response.no}
		</div>
	</div>
	<hr>

	<div class="clearfix">
		<font
			style="font-size: 60px; line-height: 40px; float: left; width: 55%; text-align: right; padding-right: 30px"
			class="color-xms ">${response.annualRate_formatter}</font>
		<div style="float: left; width: 45%; text-align: left;"
			class="color-as">年化利率</div>
		<div style="float: left; width: 10%; text-align: left;">%</div>
	</div>
	<div
		style="float: left; width: 100%; text-align: left; font-size: 2px; line-height: 25px; color: #388bff; text-align: center;">${response.paymentMode}
	</div>

	<div class="float-left" style="width: 37%; text-align: center;">
		${response.deadline}<br>
		<font class="color-as">产品期限</font>
	</div>
	<div class="float-left" style="width: 30%; text-align: center;"]>
		<div id="days" style="float: left; width: 25%;">0天</div>
		<div id="hours" style="float: left; width: 25%;">0时</div>
		<div id="minutes" style="float: left; width: 25%;">0分</div>
		<div id="seconds" style="float: left; width: 25%;">0秒</div>
		<Br> <font class="color-as">投资剩余时间</font>
	</div>
	<div class="float-left" style="width: 30%; text-align: center;">
		$${response.borrowAmount_formatter}<br>
		<font class="color-as">总金额(元)</font>
	</div>

	<table class="am-table am-table-bordered"	style="font-size: 14px; border-top-width: 0px; border-bottom-width: 0px;">
		<tr>
			<td class="am-text-middle" style="border-width: 0px;" colspan=2></td>
			<td class="am-text-middle" style="border-width: 0px;" colspan=2></td>

			<td class="am-text-middle" style="border-width: 0px;" colspan=2></td>
		</tr>
		<tr>
			<Td style="border-width: 0px; border-top-width: 1px;" colspan=2><font
				class="color-as">进度</font> ${response.schedules}%</td>
			<Td colspan=4
				style="border-width: 0px; border-top-width: 1px; text-align: right;"><font
				class="color-as">可投金额(元)</font> <font class="color-xms" size="3">${response.canInvestAmount_formatter}</font></td>
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
	</table>
	<section data-am-widget="accordion"
		class="am-accordion am-accordion-gapped" data-am-accordion='{  }'
		style="margin: 0;">
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
							<div class="am-u-sm-3">${ppp.invest_amount_formatter}</div>
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
</body>
</html>
