<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>货源添加</title>
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



<form action="hyxx/DoHytjServlet" method="post">
<table width="40%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 货源信息->货源浏览->添加货源</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="image" src="images/add.gif" width="10" height="10" /> <span class="STYLE1"><input type="submit" value="添加"/>&nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
     
      <tr>
        <td  height="20" width="70" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">货源名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="goodsName" size="25"/>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">发货人编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="goodsConsignerId" size="25"/>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">收货人编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="goodsConsigneeId" size="25"/>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">始发地</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsStart">
        		<option value="北京">北京</option>
        		<option value="上海">上海</option>
        		<option value="杭州">杭州</option>
        		<option value="武汉">武汉</option>
        		<option value="合肥">合肥</option>
        		<option value="上海">徐州</option>
        		<option value="天津">天津</option>
        		<option value="南京">南京</option>
        	</select>
        	&nbsp;&nbsp;
        	目的地
        	<select name="goodsDestination">
        		<option value="北京">北京</option>
        		<option value="上海">上海</option>
        		<option value="杭州">杭州</option>
        		<option value="武汉">武汉</option>
        		<option value="合肥">合肥</option>
        		<option value="上海">徐州</option>
        		<option value="天津">天津</option>
        		<option value="南京">南京</option>
        	</select>
        	
        	
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">紧急程度</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsABC">
        		<option value="A">A</option>
        		<option value="B">B</option>
        		<option value="C">C</option>
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">货源产地</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsCity">
        		<option value="北京">北京</option>
        		<option value="上海">上海</option>
        		<option value="杭州">杭州</option>
        		<option value="武汉">武汉</option>
        		<option value="合肥">合肥</option>
        		<option value="上海">徐州</option>
        		<option value="天津">天津</option>
        		<option value="南京">南京</option>
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">货源类型</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsTypeId">
        		<c:forEach var="goodsType" items="${goodsTypeList }">
        			<option value="${goodsType.goodsTypeNumber}">${goodsType.goodsTypeName}</option>
        		</c:forEach>       	       		
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">所在仓库</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsStockId">
				<c:forEach var="ware" items="${wareList }">
        			<option value="${ware.wareHouseNumber}">${ware.wareHouseName}</option>
        		</c:forEach> 
        	</select>
        	所在仓库位置
        	&nbsp;&nbsp;
        	<select name="goodsStockRegionId">
				<c:forEach var="stock" items="${stockList }">
        			<option value="${stock.stockRegionNumber}">${stock.stockRegionName}</option>
        		</c:forEach> 
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">单价</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="goodsPrice" size="10"/>
        	数量 <input type="text" name="goodsAmount" size="10" value="1"/>
        	单位
        	<select name="goodsUnit">
        		<option value="台">台</option>
        		<option value="个" selected="selected">个</option>
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">状态</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="goodsState">
        		<option value="未发货">未发货</option>
        		<option value="运送中">运送中</option>
        		<option value="未入库">未入库</option>
        		<option value="已入库">已入库</option>
        	</select>
        </span></div>
        </td>
     </tr>
           
      </table>
      </td>
  </tr>
 
   
</table>
</form>
	<img src="/Jsp01/WebRoot/images/car.jpg" />
</body>
</html>