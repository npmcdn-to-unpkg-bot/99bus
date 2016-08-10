<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="${webdomain}">
<link rel="icon" type="image/png" href="filesource/images/99header.jpg">
<link rel="stylesheet" href="filesource/assets/css/amazeui.css">
<link rel="stylesheet" href="filesource/assets/css/app.css?v=20160710">
  <link rel="stylesheet" href="filesource/assets/css/style.css">
<script src="filesource/assets/js/jquery.min.js"></script>
<script src="filesource/assets/js/amazeui.js"></script>
<script src="filesource/assets/js/handlebars.min.js"></script>
<script src="filesource/assets/js/amazeui.widgets.helper.js"></script>
<script src="filesource/assets/js/jsencrypt.min.js"></script>
<script src="filesource/assets/js/app.js"></script>
	<div id = "pagedefinedDiv"></div>
	<form action="usr/toLgn" method="post" id="lgnFrmComm" ></form>
	<form action="usr/toSetTradPwd" method="post" id="setTradPwdFrmComm" ></form>
	<div class="am-modal am-modal-alert" tabindex="-1" id="develep-alert">
	 <div class="am-modal-dialog">
	    <div class="am-modal-hd"><div id="inforMsgTitle">信息</div></div>
	    <div class="am-modal-bd"><div id="inforMsgContext" style="text-align:left;">功能开发中！！  </div></div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn">确定</span>
	    </div>
	  </div>
	</div>
	<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">请选择</div>
	    <div class="am-modal-bd">
	     		<div id="confirmMsgContext" style="text-align:left;">功能开发中！！  </div>
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
	      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
	    </div>
	  </div>
	</div>
<!-- 共通界面初始化js-请勿更换位置 -->
<script type="text/javascript">
	$(function() {
		msg = "${msg}";
		if (msg != "") {
			alert("信息", msg, "");
		}
	});
</script>
<script src="filesource/assets/js/common-init.js"></script>
<!-- js 初始化结束 -->

<style>
  #vld-tooltip {
    position: absolute;
    z-index: 1000;
    padding: 5px 10px;
    background: #F37B1D;
    min-width: 150px;
    color: #fff;
    transition: all 0.15s;
    box-shadow: 0 0 5px rgba(0,0,0,.15);
    display: none;
  }
  #vld-tooltip:before {
    position: absolute;
    top: -8px;
    left: 50%;
    width: 0;
    height: 0;
    margin-left: -8px;
    content: "";
    border-width: 0 8px 8px;
    border-color: transparent transparent #F37B1D;
    border-style: none inset solid;
  }
  .mrgn-pdng-zero{
  	margin:0px;
  	padding:0px;
  }
</style>


<style>
  .scrollspy-nav {
    top: 0px;
    z-index: 10000;
    background: #0e90d2;
    width: 40px;
    padding: 0;
    float:left;
    position: absolute;
    background-color:gray; opacity:0.3;filter:alpha(opacity=50); 
  }

  .scrollspy-nav ul {
    margin: 0;
    padding: 0;
  }

  .scrollspy-nav li {
    display: inline-block;
    list-style: none;
  }

  .scrollspy-nav span {
    color: white;
    padding: 10px;
    display: inline-block;
  }

  .scrollspy-nav a.am-active {
    color: white;
    font-weight: bold;
  }

  .am-panel {
    margin-top: 20px;
  }

</style>
<nav class="scrollspy-nav" data-am-scrollspynav="{offsetTop: 45}" data-am-sticky>
  <ul>
    <li><span onclick="history.back(-1)"><<</span></li>
  </ul>
</nav>

