<%@ page contentType="text/html;charset=gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>腾达物流管理</title>
<style type="text/css">
	html,body{
		padding:0px;
		margin:0px;
	}
	#menu{
		width:147px;
		margin:0px auto;
	}
	#menu ul{
		list-style:none;
		margin:0px;
		padding:0px;
	}
	#menu ul li{
		width:147px;
		text-align:center;
		line-height:23px;
	}
	#menu ul li span{
		width:140px;
		height:23px;
		display:block;
		cursor:pointer;
	}
	#menu li.first{
		background-image:url(images/main_34.gif);
		background-repeat:no-repeat;
		font-size:14px;
		font-weight:bold;
	}
	#menu .first:hover{
		cursor:pointer;
	}
	#menu .first li a{
		text-decoration:none;
		font-size:13px;
		font-weight:normal;
		color:#333333;
	}
	#menu .first li a:hover{
		text-decoration:underline;
		color:#FF0000;
	}
</style>
<script language="javascript">
	function $(id){
		return document.getElementById(id);
	}
	window.onload=function(){
		var liNodes=$("menu").getElementsByTagName("li");
		for(var index=0;index<liNodes.length;index++){
			var ulNodes=liNodes[index].getElementsByTagName("ul");
			if(ulNodes.length>0){
				liNodes[index].getElementsByTagName("span")[0].onclick=function(){
					if(this.parentNode.getElementsByTagName("ul")[0].style.display=="none"){
						this.parentNode.getElementsByTagName("ul")[0].style.display="block";
					}
					else{
						this.parentNode.getElementsByTagName("ul")[0].style.display="none";
					}
				};
			}
		}
	};
</script>
</head>
<body>
	<div id="menu">
		<ul>
			<li class="first"><span>货源信息</span>
				<ul>
					<li><a href="hyxx/HyllServelet" target="rightFrame">货源浏览</a></li>
					<li><a href="hyxx/HytypeServlet" target="rightFrame">货源类型</a></li>
					<li><a href="hyxx/HyShowConsigneeServlet" target="rightFrame">收货管理</a></li>
					<li><a href="hyxx/HyShowConsignerServlet" target="rightFrame">发货管理</a></li>
				</ul>
			</li>
			<li class="first"><span>仓库信息</span>
				<ul>
					<li><a href="ckxx/ShowCkglServlet" target="rightFrame">仓库管理</a></li>
					<li><a href="ckxx/ShowGoodsPlaceServlet" target="rightFrame">货物位置管理</a></li>
					<li><a href="ckxx/EntryStoreServlet" target="rightFrame">入库单管理</a></li>
					<li><a href="ckxx/ShowOutStoreServlet" target="rightFrame">出库单管理</a></li>
				</ul>
			</li>
			<li class="first"><span>车队信息</span>
				<ul>
					<li><a href="cdxx/xlglServlet" target="rightFrame">线路管理</a></li>
					<li><a href="cdxx/cdglServlet" target="rightFrame">车队管理</a></li>
					<li><a href="cdxx/clglServlet" target="rightFrame">车辆管理</a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>
