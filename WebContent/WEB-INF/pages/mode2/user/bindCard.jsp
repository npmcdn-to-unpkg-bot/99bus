<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>实名认证并绑定银行卡</title>
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
	style="text-align: left; font-size: 14px; background: url('filesource/images/u0.png')">
	<div style="padding:20px;">
	<form action="rgstr/bind" method="post" id="submitForm">
		<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 不提供支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
		<!-- 
		<div class="am-slider am-slider-default" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li><img src="images/no-pic.png" width="100%" height=140px /></li>
			</ul>
		</div>
		 -->
		<span class="color-red">实名认证</span>
		<table
			style="margin: auto; margin-top: 4px; width: 100%; background: white;"
			class="border-c">
			<Tr style="border-bottom: 1px solid #f0f1f4;">
				<td width="70%" height="50px">
					<c:if test="${user.realName != null}">
						<input  id="realityName" name="realityName" class="am-form-field border-c" type="text" style="border: white;" required placeholder="请输入姓名" readonly="readonly" value="${user.realName}">
					</c:if>
					<c:if test="${user.realName == null}">
						<input  id="realityName" name="realityName" class="am-form-field border-c" type="text" style="border: white;" required placeholder="请输入姓名" value="${realityName}">
					</c:if>
					
				</td>
			</tr>
			<Tr>
				<td width="70%" height="50px">
					<c:if test="${user.idNo != null}">
						<input class="am-form-field border-c" type="text" style="border: white;" id="idNumber" name="idNumber" 	required placeholder="请输入身份证" readonly="readonly" value="${user.idNo}">
					</c:if>
					<c:if test="${user.idNo == null}">
						<input class="am-form-field border-c" type="text" style="border: white;" id="idNumber" name="idNumber" 	required placeholder="请输入身份证"  value="${idNumber}">
					</c:if>
				</td>
			</tr>
		</table>
		<div style="margin-top: 10px;">
			<span class="color-red">绑定银行卡</span>
		</div>
		<table	style="margin: auto; margin-top: 0px; width: 100%; background: white; font-size: 16px;"	class="border-c">
			<Tr style="border-bottom: 1px solid #f0f1f4;"  data-am-modal="{target:'#my-alert'}">
				<td width="20%" style="padding-left: 5px;">银行</td>
				<td width="80%" height="50px" colspan="2">
					<input type="hidden" id="bank_cd" name="bank_cd" value="${bank_cd}">
					<input type="hidden" id="bank_nm" name="bank_nm" value="${bank_nm}">
					<div style="float:left;width:90%" id="banckname"> </div>
					<div style="width:10%;float: right; color: #ccc;">》</div>
				</td>
			</tr>
			<Tr style="border-bottom: 1px solid #f0f1f4;">
				<td width="30%" style="padding-left: 5px;">开户地区</td>
				<td height="50px" colspan="2">
					<div style="float: left; width: 48%;">
						<select data-am-selected="{btnWidth: '100%', btnSize: 'sm',maxHeight: 150}" 	onchange="choseSQ()" style="font-size: 12px;" id="bank_prov"	name="bank_prov">
							<option value="">请选择省份</option>
						</select>
					</div>
					<div style="float: left; width: 48%;">
						<select data-am-selected="{btnWidth: '100%', btnSize: 'sm',maxHeight: 150}"  style="font-size: 12px;" id="bank_city" name="bank_city">
							<option value="">请选择市区</option>
						</select>
					</div>
				</td>
			</tr>
			<Tr>
				<td width="20%" style="padding-left: 5px;">卡号</td>
				<td width="80%" height="50px" colspan="2">
					<input	class="am-form-field border-c" type="text" style="border: white;" id="capAcntNo" name="capAcntNo" value="${capAcntNo}"	required placeholder="请输入银行卡号">
				</td>
			</tr>
			<Tr>
				<td width="20%" style="padding-left: 5px;">支付密码</td>
				<td width="80%" height="50px" colspan="2">
					<input	class="am-form-field border-c" type="password" style="border: white;" id="password" name="password" value="${password}"	required placeholder="请输入交易密码" />
				</td>
			</tr>
		</table>
		<button class="am-btn am-btn-danger background-red border-c" type="submit"	style="width: 100%; margin-top: 10px; height: 50px; line-height: 18px; font-size: 18px"	target="_blank">确认领取9999元体验金</button>
	</form>
	<button class="am-btn am-btn-default background-gray border-c " onclick="convertHrefToForm('prdct/index?v='+new Date().getTime())"	style="width: 100%; margin-top: 10px; color: black; height: 50px; line-height: 18px; font-size: 18px"	target="_blank">再看看</button>
	</div>
</body>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
	<div class="am-modal-dialog">
		<div class="am-modal-hd">选择银行</div>
		<div class="am-modal-bd">
			<ul class="am-list">
				<li><a onclick="setbank('0102','中国工商银行')" data-am-modal-close>中国工商银行</a></li>
				<li><a onclick="setbank('0105','中国建设银行')" data-am-modal-close>中国建设银行</a></li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	function setbank(bankCd, bankNm) {
		$('#banckname').html(bankNm);
		$('#bank_cd').val(bankCd);
		$('#bank_nm').val(bankNm);
	}
	var prov;
	$(function() {
		$('#bank_city').html("");
		$('#bank_city').html("<option value=''></option>");
		prov = ${response.bank_city};
		var newPro  = new Array();
		for (var i = 0; i < prov.length; i++) {
			var check = 0;
			for (var j = 0; j < newPro.length; j++) {
				if (prov[i].prov_cd == newPro[j].prov_cd) {
					check = 1;
				}
			}
			if(check == 0){
				newPro[newPro.length] = prov[i];
				
			}

		}
		for (var i = 0; i < newPro.length; i++) {
			new_obj = $("<option value='"+newPro[i].prov_cd+"'>"+ newPro[i].prov_nm + "</option>");
			new_obj.appendTo($('#bank_prov'));
		}

	});
	function choseSQ() {
		$('#bank_city').html("");
		$('#bank_city').html("<option value=''></option>");
		var bankProv = $('#bank_prov').val();
		for (var i = 0; i < prov.length; i++) {
			if (prov[i].prov_cd == bankProv) {
				new_obj = $("<option value='"+prov[i].city_cd+"'>"+ prov[i].city_nm + "</option>");
				new_obj.appendTo($('#bank_city'));
			}
		}
		
	}
</script>
</html>
