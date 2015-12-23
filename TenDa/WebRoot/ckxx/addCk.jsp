<%@ page language="java" import="java.util.*,com.cmbb.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>添加仓库</title>
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
		a:hover{
		color: #000000;
		font-size: 12px;
		text-decoration: none;
	}
	a:visited {
		 font-size: 12px;
		 color: #e1e2e3;
		 text-decoration: none;
		}
	a:link {
		 font-size: 12px;
		 color: #e1e2e3;
		 text-decoration: none;
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



<form action="ckxx/AddCkServlet" method="post">
<table width="40%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center">&quot;<img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 仓库管理>>添加仓库 </span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="image" src="images/add.gif" width="10" height="10" /> <span class="STYLE1"><input type="submit" value="添加"></a>&nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    <tr>
    	<td height="20" bgcolor="d3eaef" class="STYLE6" colspan="2" style="padding-left: 10px">带*为必填选项</td>
    </tr>
    
    
      <tr>
        <td  height="20" width="70" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">仓库编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="WareHouseNumber" size="25"/>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">仓库名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="WareHouseName" size="25"/>*
        </span></div>
        </td>
     </tr>
    
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">负责人</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="chargeId1">
        		<c:forEach var="list" items="${list }">
        			<option value="${list.loginId }">${list.loginName}</option>
        		</c:forEach> 
        	</select>       	
        </span></div>
        </td>
     </tr>
    
    
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">仓库地址</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="WareHouseAdd" size="25"/>
        </span></div>
        </td>
     </tr>
     

      </table>
      </td>
  </tr>
 
   
</table>
</form>
	<img src="images/car.jpg" />
</body>
</html>