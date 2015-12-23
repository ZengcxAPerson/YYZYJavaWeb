<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>货源浏览</title>
	<style type="text/css">
	<!--
	body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	}
	.STYLE1 {
		color: #e1e2e3;
		font-size: 12px;
	}
	.STYLE6 {color: #000000; font-size: 12; }
	.STYLE10 {color: #000000; font-size: 12px; }
	.STYLE19 {
		color: #344b50;
		font-size: 12px;
	}
	.STYLE21 {
		font-size: 12px;
		color: #3b6375;
	}
	.STYLE22 {
		font-size: 12px;
		color: #295568;
	}
	-->
	</style>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 货源信息->货源浏览</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="image" src="images/add_on.gif" width="60" height="19" onclick="location.href='BeforeHytjServlet'" /> <span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">单价</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">数量</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">始发地</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">目的地</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">紧急程度</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">仓库编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></td>
      </tr>
      
      <c:forEach var="goods" items="${page.list}" varStatus="index">
     
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${goods.goodsNumber }</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsName }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsPrice }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsAmount }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsStart }</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">${goods.goodsDestination }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsABC }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${goods.goodsStockId }</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">${goods.goodsState }</div></td>
      </tr>
     </c:forEach>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> ${page.totalCount }</strong> 条记录，当前第<strong>${page.currentPageNo }</strong> 页，共 <strong>${page.totalPageNo }</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
           
            <td width="49"><div align="center"><a href="hyxx/HyllServelet?currentPageNo=${page.currentPageNo-1 }"><img src="images/main_56.gif" width="45" height="15" /></a></div></td>
            <td width="49"><div align="center"><a href="hyxx/HyllServelet?currentPageNo=${page.currentPageNo+1 }"><img src="images/main_58.gif" width="45" height="15" /></a></div></td>
           
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><img src="images/main_56.gif" width="26" height="15" /></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

	<img src="images/car.jpg" />
</body>
<script type="text/javascript">
	function go() {
		var pageCount = Document().getElementById("").value;
	}
</script>
</html>

