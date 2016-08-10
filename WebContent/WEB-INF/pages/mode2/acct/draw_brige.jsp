<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>提现申请</title>
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
	<script type="text/javascript">
		function funEvent(){
			try{
				$('#fyFrame').css("height",$('#bottomNav').offset().top);
				try{
					var txt = window.fyFrame.document.body.innerHTML;
					var json=JSON.parse(txt);
					alert(json.msg);
					$('#crossForm').submit();
				} catch(e){
					alert("异常",e.message);
				}
				
			}catch(e){
				alert("异常",e.message);
			}
		}
	</script>
</head>
<body style="text-align:left;font-size:18px;line-height:50px;overflow-y:hidden;">
	<iframe id="fyFrame" name="fyFrame" width="100%"  style="margin:0;padding:0;width:100%;right:0px;border:solid 0px red;" src="${webdomain}cshoprtn/toDrawOutPage" onload="funEvent();">  </iframe>
	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default  am-no-layout" id="bottomNav" style="border-top:1px solid #ddd;height:55px;">
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
</body>
</html>
